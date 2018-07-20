package step01;
/*1. Parent 2 상속 받기
 *2. int no2 선언 및 초기화(값 대입)
 *3. printAll() 메소드 재정의
 *4. 다형성이 적용된 객체를 메인에서 생성
 *5. printAll() 호출
 *6. Child2만의 no2 값을 100으로 수정
 *7. no2 값만 출력 
 */
public class Child2 extends Parent2{

	int no2 = 5; //초기화 자체가 값 주는 것임.

	public void printAll() {
		super.printAll();
		System.out.println(no2);
		
	}
	
	public static void main(String[] args) {
		
		Parent2 p = new Child2(); //다형성 적용된 객체
		Child2 c2 = (Child2)p;
		//p.printAll(); //참고용
	
		c2.no2 = 100;
		c2.printAll(); //또는 System.out.printIn(c.no2);
		System.out.println(p.no1); //10
		p.no1 = 1000; 
		System.out.println(c2.no1); //1000. 같은 것을 참조하기 때문에 변함
	}

}

class Parent2{ //클래스 개별생성
	int no1 = 10;
	void printAll() {
		System.out.println(no1);
		
	}
}