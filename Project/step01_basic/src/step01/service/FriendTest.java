package step01.service;

import step01.domain.FriendVO;

public class FriendTest {
		// java program�� start point �ʼ� �޼ҵ� (�����ް� ���忡 �°� ����). ��ҹ��� ����
		public static void main(String [] a) {
			FriendVO p1 = new FriendVO(); // new �����ʿ� �ִ°� ������. ��ü�� �����ϰ� ���ִ� ��. ������ ���� �ȵ�
			//��ü�� ������� new�� �������� ������ �ʿ��ϴ�. �����ڰ� ȣ���� �ؾ߸� �޸𸮷� ��� ����
			
			System.out.println(p1.name + " "+ p1.cellPhone + " " + p1.age);	
			
			FriendVO p2 = new FriendVO();
			p2.name = "���ƿ�";
			p2.cellPhone = "000-1234-5678";
			p2.age = 26;
			System.out.println(p2.name + " "+ p2.cellPhone + " " + p2.age);	
			
			
			FriendVO p3 = new FriendVO();
			p3.name = "�̰���";
			p3.cellPhone = "000-9876-4321";
			p3.age = 26;
			System.out.println(p3.name + " "+ p3.cellPhone + " " + p3.age);	
		}//end of main
}//end of class
