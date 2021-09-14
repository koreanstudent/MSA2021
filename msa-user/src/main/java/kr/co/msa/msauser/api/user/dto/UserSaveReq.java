package kr.co.msa.msauser.api.user.dto;

import lombok.Data;

@Data
public class UserSaveReq {

    private String loginId;
    private String password;
    private String name;
    private String email;

    public void changePassword(String password) {
        this.password = password;
    }
}
