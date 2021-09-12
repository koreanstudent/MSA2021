package kr.co.msa.msauser.domain.user;

import kr.co.msa.msauser.api.user.dto.UserRes;
import kr.co.msa.msauser.api.user.dto.UserSaveReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    @Autowired ModelMapper modelMapper;

    public Long saveUser(UserSaveReq userDto) {
        String rawPassword =userDto.getPassword();
        String encodeedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        userDto.changePassword(encodeedPassword);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);


        User userEntity = modelMapper.map(userDto, User.class);


        return userRepository.save(userEntity).getId();
    }

    /**
     * [사용자] 단건 조회
     */
    public UserRes findUser(Long userId) {
        return  userRepository.findById(userId)
                .map(UserRes::new)
                .orElseThrow();

    }

}
