package step01;

public class EqualsTest {
	
	
	public static void main(String[] args) {
		//테스트 데이터
		PeopleDTO p1 = new PeopleDTO("정상만",26);
		PeopleDTO p2 = new PeopleDTO("정상만",26);
		PeopleDTO p3 = new PeopleDTO("서아영",24);

		System.out.println(p1.equals(p2)); //true
		System.out.println(p1.equals(p3)); //false
		
		//해야하는 것 : 이름 같은 사람 찾아내기
		
	}

}