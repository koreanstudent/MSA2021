package kr.co.msa.msacatalog.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private boolean isSuccess;
    private String code;
    private String message;
    private T data;

    @JsonProperty("isSuccess")
    public boolean isSuccess() {
        return isSuccess;
    }

    @Builder
    public Result(ResultCode resultCode, T data) {
        this.isSuccess = resultCode.isSuccess();
        this.code = resultCode.name();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    // success
    public static <T> Result<T> success() {
        return (Result<T>) Result.builder()
                .resultCode(ResultCode.SUCCESS)
                .build();
    }

    // success with result data
    public static <T> Result<T> success(T data) {
        return (Result<T>) Result.builder()
                .resultCode(ResultCode.SUCCESS)
                .data(data)
                .build();
    }

    // error
    public static <T> Result<T> fail() {
        return (Result<T>) Result.builder()
                .resultCode(ResultCode.FAIL)
                .build();
    }

    // error with error data
    public static <T> Result<T> fail(T data) {
        return (Result<T>) Result.builder()
                .resultCode(ResultCode.FAIL)
                .data(data)
                .build();
    }
}
