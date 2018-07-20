package step01;

public class InstanceofTest {

	public static void main(String[] args) {
		//String 객체의 내용값 비교
		System.out.println("data".equals("data")); //true "data"에 .붙이면 쓸 수 있는 메소드들이 나온다.
		//Integer 객체의 내용값 비교
		
		Integer i = new Integer("3"); //객체 생성 필요함
		Integer i2 = new Integer("33");
		System.out.println(i.equals(i2)); //false
		
		System.out.println(i.equals("문자열")); //false. 타입이 달라서 다르게 나온다. equals()의 parameter가 Object
		/*java.lang.Obejct는 모든 객체 타입의 최상위
		 * 기본 타입 8가지를 제외한 모든 타입 다 수용 가능
		 * 데이터타입
		 * 	1. 기본 타입 - 정수 실수 문자 논리
		 * 2. 참조 타입 - 기본 제외한 모든 타입
		 * 
		 */
		System.out.println(i.equals("3")); //false
		System.out.println("3".equals(i)); //false. 타입이 다르면 비교 자체가 불가능하다.
		
		//사용자 정의 객체의 내용값 비교
	
		
		//Object의 자식 String, Integer, ...등 모든 것
		/* 객체 타입 비교 연산자 학습 중임
		 * 1. instanceof
		 * 2. 제약조건 : 상속 관계에서만 비교 가능
		 * 
		 */
			System.out.println("string" instanceof Object); //true - 문자열과 object의 타입 비교. 비교당할 데이터 연산자 비교하는 데이터 순.
			System.out.println("string" instanceof String); //true
			//String과 integer는 연관성이 없어서 따라서 비교 불가
			// System.out.println("string" instanceof Integer);  오류뜸
			
		System.out.println("--- 재정의"); //값 대입해서 실험하는 장소
		AA a = new AA(5);
		AA a2 = new AA(10); // AA 객체 2개 생성
		System.out.println(a.equals(a2)); //원래는 다른 객체니까 주소값 비교를 해서 false가 나옴.
														 //but, 밑에서 class AA를 만들어 재정의 하면 true. 그리고 후에는 값을 대입해서 비교가능.
	
	}

}
class AA extends Object{
	//객체의 주소값 비교했던 메소드를 내용값(변수값) 비교로 재정의
	int data; //멤버변수
	
	AA() {} //테스트를 위해 생성자를 만듬 -> 위에 재정의 파트에서 값 대입해서 실험. 같은 값이면 true, 아니면 false
	AA(int d){
		data = d;
	}
	/* AA 객체들 비교
	 * 1. AA 타입 여부 비교 (꼭 이거먼저) - instanceof
	 * 2. AA 타입이 일치된다면 AA 객체들이 보유한 멤버 변수값 비교
	 * 		Object 타입의 변수는 상속시킨 메소드만 호출이 가능
	 * 		자식만의 멤버를 호출하기 위해서는 형변환 필수
	 */
	public boolean equals(Object o) {
		if(o instanceof AA) { //o가 AA 타입인지 비교
			AA a = (AA)o; //형변환. data 멤버변수 비교해야하니까 o는 Object껄 못불러. 그래서 형변환 해야함
			
			//이 메소드를 보유한 객체의 data 변수와 parameter로 유입된 객체의 data 변수 비교
			if(data == a.data) {
					return true;
			}
		}
			return false;
	}
}