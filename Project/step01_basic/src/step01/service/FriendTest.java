package step01.service;

import step01.domain.FriendVO;

public class FriendTest {
		// java program의 start point 필수 메소드 (제공받고 스펙에 맞게 개발). 대소문자 주의
		public static void main(String [] a) {
			FriendVO p1 = new FriendVO(); // new 오른쪽에 있는건 생성자. 객체를 생성하게 해주는 것. 없으면 실행 안됨
			//객체를 만들려면 new와 생성자의 조합이 필요하다. 생성자가 호출을 해야만 메모리로 사용 가능
			
			System.out.println(p1.name + " "+ p1.cellPhone + " " + p1.age);	
			
			FriendVO p2 = new FriendVO();
			p2.name = "서아영";
			p2.cellPhone = "000-1234-5678";
			p2.age = 26;
			System.out.println(p2.name + " "+ p2.cellPhone + " " + p2.age);	
			
			
			FriendVO p3 = new FriendVO();
			p3.name = "이경준";
			p3.cellPhone = "000-9876-4321";
			p3.age = 26;
			System.out.println(p3.name + " "+ p3.cellPhone + " " + p3.age);	
		}//end of main
}//end of class
