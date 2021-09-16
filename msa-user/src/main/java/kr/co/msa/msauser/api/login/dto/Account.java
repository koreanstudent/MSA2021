package kr.co.msa.msauser.api.login.dto;


import kr.co.msa.msauser.domain.user.User;
import lombok.*;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    private Long id;
    private String loginId;
    private String password;
    private String name;


    public Account(User entity) {
        this.id = entity.getId();
        this.loginId = entity.getLoginId();
        this.password = entity.getPassword();
        this.name = entity.getName();


    }
}
