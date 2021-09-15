package kr.co.msa.msauser.api.login.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AccountGetReq {

    @NotBlank
    @Size(max = 16)
    private String loginId;

    @NotBlank
    @Size(max = 128)
    private String password;

    private int sessionTimeout;
}