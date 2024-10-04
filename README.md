# jobadream_backend
백엔드

# FastAPI에서 SpringBoot로 마이그레이션 하는 이유
1.팀의 기술 스택 통합 :  Java 기반 기술을 이미 사용 중인 팀의 일관성을 유지

2.보안 강화 : Spring Boot의 보안 프레임워크(Sprint Security)를 활용한 안전한 인증, 인가, 암호화 기능

3.성능 최적화 : Java 기반의 빠른 처리 성능을 제공


![아키텍처_v1](https://github.com/user-attachments/assets/ad8dfc23-a6f4-472f-9ac4-927fe8e569ca)

# Spring Boot 백엔드 아키텍처 설명

## 1. 클라이언트 요청과 Apache Tomcat
클라이언트의 요청을 하면 HTTP/HTTPS 프로토콜을 통해 서버로 전달되고 내장된 Apache Tomcat은 자바 서블릿 컨테이너로, 클라이언트의 HTTP 요청을 처리하여 적절한 응답을 반환
Docker 환경에 배포된 Spring Boot 애플리케이션은 Tomcat 위에서 실행되고 클라이언트의 요청이 Tomcat에 도착하면, 해당 요청은 적절한 Controller로 전달되고 로직을 처리합니다.

## 2. Controller와 Service의 역할
- **Controller**: 클라이언트로부터 들어온 요청을 받아 적절한 서비스로 전달하는 역할. URL 패턴과 매핑되어 있어, 특정 경로로 들어온 요청이 어떤 로직에 의해 처리될지를 결정

- **Service**: 비즈니스 로직이 수행되는 핵심 레이어로 Controller에서 받은 데이터를 처리하고, Repository와 상호작용하여 데이터베이스에 접근하거나 다른 서비스를 호출. 이를 통해 실제 비즈니스 요구 사항에 따라 데이터를 변환하거나 계산하는 작업 수행

## 3. Repository와 JPA를 통한 데이터베이스 연동
- **Repository**: 데이터베이스와 직접 상호작용하는 부분으로 JPA(Java Persistence API)를 사용하여 객체와 관계형 데이터베이스 간의 매핑을 처리. SQL 쿼리를 직접 작성하지 않고도 데이터베이스에 접근하여 데이터를 조회, 수정, 삭제 가능

- **JPA**: 엔티티(Entity) 클래스를 통해 데이터베이스의 테이블과 객체를 매핑하며, 복잡한 쿼리도 쉽게 작성할 수 있게 도와줌

- **JdbcTemplate**: 필요에 따라 복잡한 SQL 쿼리를 직접 작성할 수 있으며, JPA로 처리하기 힘든 경우 JdbcTemplate을 통해 SQL을 커스터마이징하여 사용합니다.

## 4. Gradle을 통한 빌드와 의존성 관리
Gradle은 프로젝트의 빌드 및 의존성 관리를 위한 도구로, 고속 빌드 성능을 제공하며, 다양한 플러그인을 통해 확장 가능

  # Maven과 Gradle 비교
  
  ## Gradle을 선택한 이유
  - **유연성**: Gradle은 Groovy 또는 Kotlin DSL을 사용하여 매우 유연하게 빌드 스크립트를 작성할 수 있습니다. Maven에 비해 사용자 정의 작업을 처리하는 것이 이지
  - **성능**: Gradle은 빌드 시 증분 빌드를 사용하여 속도가 매우 빠릅니다. 동일한 빌드 작업을 반복할 경우 캐싱 메커니즘을 통해 빌드 시간을 줄여줌.
             (재빌드를 할 때 이전 빌드와 비교하여 다시 빌드할 필요성이 있는지 없는지 판단하여 필요한 부분만 다시 빌드하는 것)
  - **병렬 빌드 지원**: Gradle은 여러 작업을 병렬로 처리할 수 있어 대규모 프로젝트에서 더 빠른 빌드를 제공
  - **의존성 관리**: Gradle은 의존성 버전을 자동으로 해결하고, 트랜지티브 의존성 문제를 쉽게 처리 가능
  
  ## Maven과의 차이점
  - **XML vs Groovy/Kotlin DSL**: Maven은 XML 기반으로 빌드 스크립트를 작성하지만, Gradle은 더 간결하고 가독성 높은 Groovy 또는 Kotlin DSL을 사용]
  - **빌드 속도**: Gradle은 증분 빌드를 제공하여 Maven에 비해 빌드 속도가 더 빠릅니다.
  - **커스터마이징**: Gradle은 Maven보다 커스터마이징이 용이하여 복잡한 빌드 프로세스를 다루기 좋음

## 5. ECS (Elastic Container Service)와 Docker를 통한 확장성 제공
**ECS (Elastic Container Service)**는 AWS에서 제공하는 컨테이너 오케스트레이션 서비스로, Docker 컨테이너를 관리하고 배포할 수 있습니다. Docker 이미지를 기반으로 Spring Boot 애플리케이션을 배포
Auto Scaling Group을 통해 애플리케이션이 필요한 경우 자동으로 인스턴스가 확장

## 6. Rendered View와 MVC 패턴
이 애플리케이션은 MVC (Model-View-Controller) 패턴을 사용. Controller에서 비즈니스 로직을 수행한 후, 그 결과를 View에 전달하여 클라이언트에게 표시할 페이지가 렌더링

## 7. Amazon S3를 통한 정적 자원 관리
Amazon S3는 정적 파일, 이미지, CSS, JavaScript 등의 리소스를 저장하고 제공하는 데 사용됩니다. 클라이언트는 렌더링된 뷰에서 이러한 정적 리소스를 S3로부터 받아서 페이지를 완성

---

# Apache Tomcat 사용 이유
- **Java 기반 애플리케이션 지원**: Tomcat은 자바 서블릿 컨테이너로서, 자바 기반 웹 애플리케이션을 구동하는 데 최적화
- **경량화**: Tomcat은 경량 웹 서버로, 비교적 적은 리소스로 애플리케이션을 구동할 수 있어 높은 성능을 요구하지 않는 프로젝트에 적합
- **확장성**: Tomcat은 다양한 설정을 통해 서버의 동작을 커스터마이징 가능. 또한, 클러스터링 및 로드 밸런싱을 통해 확장이 용이

  - 로드밸런싱 : 처리해야 할 업무 혹은 요청을 나누어 처리하는 것
  - 클러스터링 : 여러 대의 컴퓨터를 가상의 하나의 컴퓨터처럼 사용하게 해주는 것
 
---

# Spring vs FastAPI 기능 비교

## 1. **Controller**
- **Spring**: 클라이언트의 요청을 받아 처리하고, 적절한 서비스로 연결
- **FastAPI**: Router에 해당하며, 클라이언트 요청을 받아 경로에 따라 적절한 함수에 매핑

## 2. **Service**
- **Spring**:비즈니스 로직을 수행. Controller에서 받은 요청을 처리하여 데이터베이스에 접근하거나 데이터를 가공
- **FastAPI**: FastAPI에서는 비즈니스 로직은 함수나 클래스에 작성되어 경로 핸들러에서 호출

## 3. **Repository**
- **Spring**: Repository는 JPA와 함께 데이터베이스에 접근하여 데이터를 조회하고, 수정 및 저장하는 역할
- **FastAPI**: FastAPI에서는 SQLAlchemy와 같은 ORM을 통해 데이터베이스에 접근

## 4. **Entity**
- **Spring**: Entity는 JPA에서 사용되며, 데이터베이스의 테이블과 매핑되는 클래스로 각 필드는 테이블의 컬럼에 대응됩니다.
- **FastAPI**: Pydantic 모델이나 SQLAlchemy 모델이 Entity에 해당. SQLAlchemy 모델은 테이블과 매핑되고, Pydantic 모델은 데이터 검증을 담당.

## 5. **DTO (Data Transfer Object)**
- **Spring**: 데이터 전송을 위한 객체. (주로 서비스 레이어 간에 데이터를 교환할 때 사용)
- **FastAPI**: Pydantic 모델이 DTO 역할. 데이터 검증과 직렬화를 통해 데이터를 전송

## 6. **Build Tool**
- **Spring (Gradle)**: Gradle을 사용하여 프로젝트를 빌드하고 의존성 관리
- **FastAPI**: FastAPI는 pip 또는 Poetry를 사용하여 패키지를 관리하고 빌드


 
