package kr.co.msa.msauser.domain.user;

import kr.co.msa.msauser.api.user.dto.UserRes;
import kr.co.msa.msauser.api.user.dto.UserSaveReq;
import kr.co.msa.msauser.exception.BusinessException;
import kr.co.msa.msauser.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    public Long saveUser(UserSaveReq userDto) {
        String rawPassword =userDto.getPassword();
        String encodeedPassword = passwordEncoder.encode(rawPassword);
        userDto.changePassword(encodeedPassword);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);


        User userEntity = modelMapper.map(userDto, User.class);

        return userRepository.save(userEntity).getId();
    }

    public UserRes findUser(Long userId) {
        return  userRepository.findById(userId)
                .map(UserRes::new)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER));

    }

    public List<UserRes> findUsers() {
        return userRepository.findAll()
                .stream().map(UserRes::new).collect(Collectors.toList());

    }

    public UserRes getUserDeatailsLoginId(String loginId) {
        return  userRepository.findByLoginId(loginId)
                .map(UserRes::new)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER));

    }
}
