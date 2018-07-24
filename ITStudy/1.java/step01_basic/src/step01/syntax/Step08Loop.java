/*학습내용
 * 1. 반복문
 * 		1) for : 반복 횟수가 명확할 때 주로 사용
 * 				조건식이 true인 경우만 실행
 * 		2) while : 무한 루프, 반복 횟수가 불명확할 때
 * 				조건식이 true인 경우만 실행
 * 		3) do~while : 반복 횟수가 불명확할 때 주로 사용, 무조건 1번 이상 실행해야될 경우.
 * 
 */

package step01.syntax;

public class Step08Loop { //(객체 생성은 필요 없다. static 쓰자)
	//for 1~5 출력	키보드의 tab과 동일한 키보드 "\t" W(원)키..

	/* 1~5까지 가변적인 데이터 보유하게 되는 변수
	 * 1 ~1 씩 증가시키는 로직
	 * 변수값이 5와 비교해서 6이라면 종료... 즉 조건식
	 * for(초기식; 조건식; 증감식){
	 * 		조건식이 true인 경우 실행되는 블록
	 * 
	 */
	public static void forTest() {
		for(int i=1; i<=5; i++) { // i= i +1; 이것과 i++ 둘은 같은 문장
			System.out.print(i +"\t"); //println은 다음 값을 다음 라인에. print는 이어서. 대신 tab 기능을 넣어준 것.
			}
	}
	
	public static void forTest2(){
		for(int i=1; i<=5; i++) {
			System.out.print("*" +"\t");
		}
	}
	//반복하는 수 만큼 데이터 적재(누적, 저장)해서 출력
	public static void forTest3(){
		char star = '*';
		String star2 = ""; //주의! ""로 쓸 것. null이라고 하면 문법오류는 없으나, null이라는 문자열을 인식해버린다. 
		for(int i=1; i<=5; i++) {
			star2 = star2+star; //*, **, ***.... 이런식으로 데이터가 적재가 된다
			System.out.println(star2 + "-"); //언제 반복했는지 알 수 있게 구분기호를 넣어주자 (같은 줄에 쓴다면)
	
		}
	}
	
	//이번엔 별 거꾸로 찍기
	public static void forTest4(){
		char star = '*';
		//다섯 라인을 실행하기 위한 반복문
		for(int lineCount=1; lineCount <=5; lineCount++) { //lineCount는 변수일뿐. 이름은 바꿔도 된다.
			//한 라인에서 별을 찍기 위한 실행 반복문
			for(int starCount=5; starCount >= lineCount; starCount--) {
				System.out.print(star);
			
			} //안쪽 for의 종료. 안쪽 for에서 조건이 false가 나오면 여길 지나서 밑으로.
			System.out.println();
			}//바깥쪽 for의 종료
		}			
	
	public static void forTest5(){ //test 3과 4를 짬뽕한 것
		char star = '*';
		String star2 = "";
		
		for(int lineCount=1; lineCount <=5; lineCount++) { 
			
			//*->**->***->****->*****
			//*->**->***->****
			//*->**->***
			//*->**
			//*
			//충분히 써보고, 이해해라.
			
			for(int starCount=5; starCount >= lineCount; starCount--) { 
				star2 = star2 + star; //수정. 이 부분이 있으면 반대로.
			}
				System.out.println(star2);
			star2="";  //이 라인이 정말 중요하다. 초기화 과정임
						} 
			//System.out.println(); 이 부분은 삭제
		
	}
	//while
	
	public static void whileTest() { //메소드 내부에 변수 선언함.
		int no = 1; //초기식
	while(no<6) { //조건식
		System.out.println(no + "\t");
		no = no + 1; //증감식 (또는 no++; 로 표현 가능). 없으면 무한루프
		}
	}
	
		//do_while
	
	public static void doWhileTest() { //메소드 내부에 변수 선언함. 낙타체로 써야해서 이렇게..중간 대문자 맞춰줌
		int no = 1; //초기식
	do{
		System.out.println(no + "\t"); //조건 검증 전 출력
		no = no + 1; //증감식
		}while(no<6); //조건 검증은 나중에
	
	}
	
	

	public static void main(String[] args) {
		
		//step01- for
		Step08Loop.forTest();
		System.out.println("\n--- 2. * 찍기"); //\n : 새로운 라인에 생성
		forTest2();
		System.out.println("\n--- 3. * 누적찍기");
		forTest3();
		System.out.println("\n--- 4. * 거꾸로찍기");
		forTest4();
		System.out.println("\n--- 5. * 거꾸로찍기2");
		forTest5();
	
		
		
		
	}

}
