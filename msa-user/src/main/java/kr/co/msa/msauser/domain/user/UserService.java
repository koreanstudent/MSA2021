package kr.co.msa.msauser.domain.user;

import kr.co.msa.msauser.api.user.dto.UserRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    /**
     * [사용자] 단건 조회
     */
    public UserRes findUser(Long userId) {
        return  userRepository.findById(userId)
                .map(UserRes::new)
                .orElseThrow();

    }

}
