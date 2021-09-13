package kr.co.msa.msauser.api.user;

import io.micrometer.core.annotation.Timed;
import kr.co.msa.msauser.api.user.dto.UserRes;
import kr.co.msa.msauser.api.user.dto.UserSaveReq;
import kr.co.msa.msauser.domain.user.UserService;
import kr.co.msa.msauser.response.Result;
import kr.co.msa.msauser.utill.HttpUtill;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

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
     * [사용자] 단건 등록
     */
    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody UserSaveReq saveReq) throws URISyntaxException {
        Long id = userService.saveUser(saveReq);

        return ResponseEntity.created(HttpUtill.getCurrentUri(id))
                .body(Result.success());
    }
    /**
     * [사용자] 단건 조회
     */
    @GetMapping("/user/{userId}")
    @Timed(value ="users.fundUser", longTask = true)
    public ResponseEntity findUser(@PathVariable Long userId){
        UserRes user = userService.findUser(userId);

        return ResponseEntity.ok(Result.success(user));
    }

    /**
     * [사용자] 다건 조회
     */
    @GetMapping("/user")
    public ResponseEntity findUsers(){
        List<UserRes> users = userService.findUsers();

        return ResponseEntity.ok(Result.success(users));
    }
}
