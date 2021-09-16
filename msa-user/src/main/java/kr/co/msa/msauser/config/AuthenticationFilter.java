package kr.co.msa.msauser.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.co.msa.msauser.api.login.dto.AccountGetReq;
import kr.co.msa.msauser.api.user.dto.UserRes;
import kr.co.msa.msauser.domain.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private  UserService userService;
    private  Environment environment;

    public AuthenticationFilter (AuthenticationManager authenticationManager, UserService userService,Environment environment ) {
        super.setAuthenticationManager(authenticationManager);
        this.userService = userService;
        this.environment = environment;
    }


    // 로그인 시도하면 제일먼저 실행됨
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {

            AccountGetReq creds = new ObjectMapper().readValue(request.getInputStream(),AccountGetReq.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getLoginId(),
                            creds.getPassword(),
                            new ArrayList<>()
                    )
            );


        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        log.debug( "successfulAuthentication : {}",((User)authResult.getPrincipal()).getUsername() );
        String userName = ((User)authResult.getPrincipal()).getUsername();

        UserRes UserDetails = userService.getUserDeatailsLoginId(userName);
        String token = Jwts.builder()
                .setSubject(UserDetails.getLoginId())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret"))
                .compact();

        response.addHeader("token", token);
        response.addHeader("userId", UserDetails.getLoginId());
    }
}
