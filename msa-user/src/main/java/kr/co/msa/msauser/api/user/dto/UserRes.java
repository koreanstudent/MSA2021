package kr.co.msa.msauser.api.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.msa.msauser.domain.user.User;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRes {

    private Long id;

    @JsonProperty("userId")
    private String loginId;

    private String email;

    private String name;


//    public UserRes(Long id) {
//        this.id = id;
//    }

    public UserRes(User entity) {
        this.id = entity.getId();
        this.loginId = entity.getLoginId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }

}
