/* 학습내용
 *  1. 객체간에 멤버로 사용(포함)되는 관계를 "has a" 관계
 *  2. 발음
 *  	has a [해즈어, 해저]
 *  	포함관계.
 *  3. 참고
 *  	- 상속은 is a[이즈어, 이저] 로 표현
 *  	- 즉 속성(데이터)들이 동일한 경우에만 상속 권장
 *  	예시 : 직원 클래스와 고객 클래스 간에는 상속 비추
 */

package step02.hasa;

public class HasATest {

	public static void main(String[] args) {
		//String engineName -> Engine -> Car -> Person & String 해서 총 5개의 객체가 생성된다
		/* 두사람의 객체, 즉 개별 Person 객체 생성
		 * ? 엔진이름, cc, Person의 이름을 다 수정하고 출력하는 방법
		 * 
		 */
		Person p1 = new Person();
			
		p1.myCar.engine.engineName = "불스원샷"; //p1.myCar.engine.setEngineName("불스원샷"); 가능. 데이터 주는건 set
		p1.name = "유재석";
		p1.myCar.engine.cc = 500;
		
		System.out.println(p1.myCar.engine.engineName); //(p1.myCar.engine.getEngineName()); 가능. 데이터 출력(받는건) get
		System.out.println(p1.name);
		System.out.println(p1.myCar.engine.cc);
		
		/* 해석
		 * p1 - Person 객체
		 * p1.myCar - Car 객체
		 * p1.myCar.engine - Engine 객체
		 * p1.myCar.engine.setEngineName() - Engine객체의 메소드
		 */
		
		Person p2 = new Person();
		p2.myCar.engine.setEngineName("싸구려엔진");
		p2.name = "조세호";
		p2.myCar.engine.setCc(5);
		
		System.out.println(p2.myCar.engine.getEngineName() + "을 사용중인 " + p2.name + " 씨의 엔진용량은 " + p2.myCar.engine.getCc() + "입니다");
		System.out.println(p2.myCar.engine.getEngineName());
		System.out.println(p2.name);
		System.out.println(p2.myCar.engine.getCc());
		
	}

}
