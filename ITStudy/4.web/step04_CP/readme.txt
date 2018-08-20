학습 내용

1. DB시스템의 동시 접속자 수 제어 기술
2. 필요한 실습 환경
	1) RDBMS
		- orcale
			: customer table - id/pw/name
	2) Java개발
	3) Server
	
3. 설정 정보의 부연 설명
	1) context.xml (아파치 탐캣 홈페이지의 jndi data sourse api에서 가져옴)
		1. <Resource name="jdbc/myoracle" 설정된 자원의 별칭
		2.	  auth="Container" 이 자원의 관리자는 Contatiner
			  
        3.     type="javax.sql.DataSource" 자바 소스와 이 설정의 중간 메니저
              소스에서 DataSource를 받아서 Connection을 제공 받게됨
              
              이 위에 3개 항목이 context.xml에 있는데,(긁어온거) web.xml에도 포함된다.(web.xml configuration에서 긁어옴)
              
        4.    driverClassName="oracle.jdbc.OracleDriver" 접속하고자 하는 DB의 driver명
        5.    url="jdbc:oracle:thin:@127.0.0.1:1521:xe" 접속하고는 DB의 url
              username="SCOTT"
              password="TIGER"
              
              maxTotal="20" 동시 접속자 수(Connection 최대개수)
              
              maxIdle="10" 접속자가 없더라도 대기하는 유휴 개수
              
              maxWaitMillis="-1" / > 데이터가 존재하지 않거나 무시하겠다. 20개 사용되는 시점에 초과되는 인원이 접속을 요할때, 대기시간 무한대로.
              clinet가 알아서 재접속 하겠지
              
              String readLine()
              int Reada()