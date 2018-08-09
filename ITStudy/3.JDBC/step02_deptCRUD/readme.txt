학습내용

1. DAO[Data Access Object] pattern 학습
	- sql + jdbc api
	- DeptDAO.java
	- 각 기능별 메소드 구분해서 세분화 개발
		: 공통된 로직
			- driver 로딩
			- Connection 생성..
				- Connection은 절대 공유 불가
				 : 로컬 변수로 생성 및 활용 (1번 쓰고 말도록 휘발성으로 만든다)
			- 자원반환
			
2. table의 하나의 row값들을 자바 객체로 매핑
	- DeptDTO.java (이거 먼저 만들기!)
	
3. 
	