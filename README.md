JSP/SERVLET
=====================
## 개요
이 프로젝트는 JSP/SERVLET을 공부할 목적으로 만들어진 프로젝트입니다.

## 프로젝트 구성
* Servlet 기초 예제 및 실습
* JSP 기초 예제 및 실습
* 암호화
* request / response 객체
* redirect / request dispatch의 차이
* JSP 내장 객체의 이해
* 웹 어플리케이션 scope의 이해
* JSP 동작 원리 이해
* 웹 어플리케이션 디렉토리와 URL 매핑 구조
* 페이지 흐름제어, 모듈화
* 에러페이지 작성 및 설정
* cookie / session 사용
* connection pool
* MVC pattern
* Model1 / Model2 비교
* EL, JSTL
* 리소스 번들을 이용한 다국어 처리
* 커스텀 태그
* Filter 적용
* Wrapper 사용
* Listener를 이용한 이벤트 감지, 처리
* 파일 업로드, 다운로드
* JDBC Connection

## 상세 내용
* logback 라이브러리 추가
    * sysout 로직 logger로 개선
* url 테스트(webapp 폴더 접근 url 확인)
    * WEB-INF 외부에서 접근이 안됨
    * localhost/jsp/img/james.png (O)
    * localhost/jsp/WEB-INF/james.png (X)
* jsp기초 시작
    * jsp : html코드에 java 코드를 삽입하는 형태
* jsp 선언부 실습
    * <%! %> : 선언부
    * <% %> : 스크립틀릿(자바 로직 작성 영역)
    * <%= %> : 표현식(값 표현)
    * <%-- %> : jsp 주석
* request 객체 정보 확인 
    * request 정보(ContextPath, requestURI)
    * request header 정보(웹브라우저가 작성, 사용자 환경 os, web browser)
* jsp파일 parameter 받기
    * timesTables.jsp에 파라미터 적용
* login 로직 개발(화면, 프로세스)
* login 화면 bootstrap 적용
* jsp를 이용한 파일 다운로드 응답
* 응답 위임하기
    * redirect
        * response.sendRdirect("path");
        * 요청이 두번 발생
        * 최초 요청과, 두번째 요청은 다르기 때문에 파라미터를 공유할 수 없다
        * 주소줄에는 redirect된 주소가 표시된다
    * request dispatch
        * request.getRequestDispatcher("path").forward(request, response);
        * 요청이 한번 발생
        * 주소줄에는 최초 요청한 주소가 표시된다
        * 서버내에서 위임이 이루어 지기 때문에 request, response 객체가 공유된다
        * 요청 파라미터를 공유할 수 있다
* Login 처리 프로세스 수정
    * redirect, dispatch 방식 적용
    * 로그인 성공 후 main 화면 작성
* jsp 내장객체
    * out, application, pageContext
* scope 실습
    * pageContext, request, session, application
    * scope 실습 예제
         * 두수 사이의 합 구하기 합결과 session 저장
         * 두수 사이의 곱 구하기 곱결과 session 저장
 * 사용자 리시트 화면 개발
    * userService : 임이의 가짜 값을 리턴(추후 수정 예정)
 * 로그인 프로세스 개선
    * 정상 로그인 사용자 로그인 화면 요청시 main.jsp로 이동
    * 페이지 모듈화 적용
         * jsp include 지시자 사용
         * header, left, basicLib 3개로 모듈화
* mybatis 환경설정
    * userDao - mybatis 적용
* JUnit을 이용한 단위 테스트 적용
* 사용자 페이징 리스트 개발
    * service객체에서 dao메소드를 여러개 호출 할 수도 있다.
    * 페이지네이션 링크 출력 개발 (자바코드와 html 태그가 복잡하게 섞여 있는 형태 --> jstl, el 가독성이 좋게 개선)
* error page 설정
    * jsp page 지시자에 errorPage 속성 설정
          * jsp 페이지별 에러 페이지 설정이라 실질적으로 사용하기는 힘듬
    * 예외 타입별 설정
          * web.xml에 <error-page>, <exception-type>별 설정
    * 응답 상태별 설정
          * web.xml에 <error-page>, <exception-code>별 설정
* cookie를 이용한 remember me 적용
* js.cookie.js 적용
* serverside cookie 설정
    * 쿠키조회 : Cookie[] cookies = request.getCookies();
    * 쿠키설정 : Cookie cookie = new Cokie("쿠키이름", "쿠키값");, cookie.setMaxAge(초단위);, response.addCookie(cookie);
   
* jdbc connection
    * jdbc 방식
    * datasource 방식
   
* dbcp connection pooling 개선
    * web.xml 설정 내용을 주석 처리
   
* 문자열 계산기 테스트 주도 개발
    * 정규표현식 캡쳐링, 그룹가져오기
   
## Author
* Bumhwi Kim (김범휘) : https://github.com/bumpercar93
