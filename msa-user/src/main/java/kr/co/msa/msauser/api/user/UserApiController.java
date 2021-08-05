package kr.co.msa.msauser.api.user;

import io.micrometer.core.annotation.Timed;
import kr.co.msa.msauser.api.user.dto.UserRes;
import kr.co.msa.msauser.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-service")
public class UserApiController {

    private final UserService userService;

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to user service";
    }
    /**
     * [사용자] 단건 조회
     */
    @GetMapping("/user/{userId}")
    @Timed(value ="users.fundUser", longTask = true)
    public ResponseEntity findUser(@PathVariable Long userId){
        UserRes user = userService.findUser(userId);

        return ResponseEntity.ok(user);
    }
}
