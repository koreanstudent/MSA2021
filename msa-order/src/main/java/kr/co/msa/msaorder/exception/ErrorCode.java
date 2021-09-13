package kr.co.msa.msaorder.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /**
     * E000 공통 오류
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E000", "승인되지 않은 요청입니다. (인증필요)"), // 401
    FORBIDDEN(HttpStatus.FORBIDDEN, "E001", "접근권한이 없습니다."), // 403
    NOT_FOUND(HttpStatus.NOT_FOUND, "E002", "요청하신 리소스가 존재하지 않습니다."), // 404
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "E003", "지원하지 않는 HTTP 메서드입니다."), // 405
    CONFLICT(HttpStatus.CONFLICT, "E004", "이미 존재하는 데이터 입니다."), // 409

    /**
     * E100 잘못된 파라미터 및 바인딩 오류 (status: 400)
     */
    BIND_ERROR(HttpStatus.BAD_REQUEST, "E100", "유효하지 않은 파라미터 입니다."),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "E101", "유효하지 않은 파라미터 입니다."),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "E102", "유효하지 않은 파라미터 입니다."), // 파라미터 형변환 불가
    INVALID_JSON_INPUT(HttpStatus.BAD_REQUEST, "E103", "유효하지 않은 JSON 포맷입니다."), // JSON 형식이 알맞지 않음
    BIND_ERROR_ENUM(HttpStatus.BAD_REQUEST, "E104", "유효하지 않은 파라미터 입니다."), // ENUM에 정의되지 않은 코드
    DATA_INTEGRITY_VIOLATION_ERROR(HttpStatus.BAD_REQUEST, "E105", "유효하지 않은 파라미터 입니다."), // 데이터무결성 제약조건 위배

    /**
     * E200 사용자 관련 코드
     */
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "E200", "사용자 정보가 없습니다."),
    CONFLICT_USER(HttpStatus.CONFLICT, "E201", "이미 존재하는 사용자 입니다."),
    NOT_FOUND_SALES_USER(HttpStatus.NOT_FOUND, "E202", "영업자 정보가 없습니다."),
    NOT_FOUND_INSTALLATION_USER(HttpStatus.NOT_FOUND, "E203", "설치자 정보가 없습니다."),
    EXISTS_USER_LOGIN_ID(HttpStatus.CONFLICT, "E204", "이미 존재하는 로그인 아이디 입니다."),
    EXISTS_USER_PHONE_NUMBER(HttpStatus.CONFLICT, "E205", "이미 존재하는 휴대폰 번호 입니다."),

    /**
     * E300 프로젝트 관련 코드
     */
    NOT_FOUND_PROJECT(HttpStatus.NOT_FOUND, "E300", "프로젝트 정보가 없습니다."),
    CONFLICT_PROJECT(HttpStatus.CONFLICT, "E301", "이미 존재하는 프로젝트 입니다."),
    DOES_NOT_MATCH_FILE_AND_TAG_SIZE(HttpStatus.CONFLICT, "E302", "첨부파일과 태그의 수는 동일해야 합니다."),
    DOES_NOT_MATCH_FILE_AND_TAG_AND_ATTACHMENTSID_SIZE(HttpStatus.CONFLICT, "E303", "첨부파일과 태그와 첨부파일 아이디의 수는 동일해야 합니다."),
    NOT_FOUND_PROJECT_ATTACHMENTS(HttpStatus.NOT_FOUND, "E304", "프로젝트 첨부파일 정보가 없습니다."),
    NOT_FOUND_PROJECT_STATISTICS(HttpStatus.NOT_FOUND, "E305", "프로젝트 통계 정보가 없습니다."),
    NOT_FOUND_PROJECT_EXTRA_PAY_SUM(HttpStatus.NOT_FOUND, "E306", "프로젝트 수당 합계를 구할 수 없습니다."),

    /**
     * E400 고객 관련 코드
     */
    NOT_FOUND_CUSTOMER(HttpStatus.NOT_FOUND, "E400", "고객 정보가 없습니다."),

    /**
     * E500 공통코드 관련 코드
     */
    NOT_FOUND_COMMON_CODE(HttpStatus.NOT_FOUND, "E500", "공통코드 정보가 없습니다."),

    /**
     * E600 이슈 관련 코드
     */
    NOT_FOUND_ISSUE(HttpStatus.NOT_FOUND, "E600", "이슈 정보가 없습니다."),

    /**
     * E10000 내부서버오류
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E10000", "정의되지 않은 오류입니다. 관리자에게 문의하세요."); // 500

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
