package step02.hasa; //has a ����� ��Ű��

public class Car {
	Engine engine = new Engine(); //Car�� ����� ȣ��. car��ü
	
	//engine �̸��� ��µǴ� �޼ҵ� ����
	void printEngineName() {
		System.out.println(engine.getEngineName());
	}
	//engine�� �⺻ cc
	void printCC() {
		System.out.println(engine.getCc());
	}
	
}
