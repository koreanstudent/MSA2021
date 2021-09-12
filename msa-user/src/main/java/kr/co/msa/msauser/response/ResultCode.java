package kr.co.msa.msauser.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {
    SUCCESS(true, "요청이 성공하였습니다."),
    FAIL(false, "요청이 실패하였습니다.");

    private final boolean isSuccess;
    private final String message;
}
