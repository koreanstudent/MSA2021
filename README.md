# MSA
 MultiModule MSA Spring-Boot PROJECT 

## Version
- JDK >= 11
- springBootVersion = '2.5.1'
- springCloudVersion = '2020.0.3'
- [Gradle](https://gradle.org/install/)
- Docker

## SPRING SECURITY 
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
