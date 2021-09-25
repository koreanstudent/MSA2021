# MSA
 MultiModule MSA Spring-Boot PROJECT 

## Version
- JDK >= 11
- springBootVersion = '2.5.1'
- springCloudVersion = '2020.0.3'
- [Gradle](https://gradle.org/install/)
- Docker

## Spring Security
    - 로그인 과정
        1. AuthenticationFilter.java -> attemptAuthentication() 호출
        2. UsernamePasswordAuthenticationToken 호출
        3. userDetailsService.java -> loadUserByUsername() 호출
        4. userRepository.java -> findByLoginId() 호출
        5. AuthenticationFilter.java -> successfulAuthentication() 호출
        6. successfulAuthentication() -> jwt 세팅
    - JWT(JSON Web Token) 장점
        1. 클라이언트 독립적인 서비스
        2. CDN (중간에 캐쉬 서버를 놓을 수 있는데 캐쉬 서버와도 인증처리가능)
        3. No Cookie-Session(사이트간 요청 위조)
        4. 지속적인 토큰 저장

## Spring Cloud Config ( 외부 설정 파일)
    - spring cloud config 사용 이유?
        1. 첫째, 마이크로서비스의 어떠한 설정(환경변수값, Spring cloud 설정 등)이 변경되었을때 서버 재시작 없이 동적으로 적용하기 위해서입니다.
        2. 둘째, 마이크로서비스가 배포될때 제반 설정값들을 배포 대상 환경(개발계, 검증계, 운영계 등)에 맞게 적용하기 위함입니다.
        3. 셋째, 마이크로서비스를 Stateless하게 개발하기 위해서입니다. Stateless하게 만들어야 스케일링(마이크로서비스 인스턴스 서버 - 즉, 컨테이너의 증감)과 부담없는 재시작이 가능하기 때문입니다.
    - bootstrap.yml -> application.yml (실행 우선순위)

## Spring Boot Actuator 
    - Application 상태, 모니터링
    - Metric 수집을 위한 Http End point 제공
## Microservice 모니터링
    - Micrometer
        - https://micrometer.io/
        - JVM기반의 애플리케이션의 Metrics 제공
        - Spring Framework 5, Spring Boot 2부터 Spring의 Metrics 처리 
        - Prometheus등의 다양한 모니터링 시스템 지원
        - 로깅 관련된 시스템에서는 SLF4J가 있다면 모니터링(metric) 시스템에서는 Micrometer가 있는 것
        - Timer
          - 짧은 지연 시간, 이벤트의 사용 빈도를 측정
          - 시계열로 이벤트의 시간, 호출 빈도 등을 제공
          - @Timed 제공
    
    - Prometheus
        - https://prometheus.io/
        - Metrics를 수집하고 모니터링 및 알람에 사용되는 오픈소스 애플리케이션
        - 시계열 DB에 Metrics 저장 -> 조회 가능(Query)

    - Grafana
        - https://grafana.com/
        - 데이터 시각화, 모니터링 및 분석을 위한 오픈소스 애플리케이션
        - 시계열 데이터를 시각화하기 위한 대시보드 제공
