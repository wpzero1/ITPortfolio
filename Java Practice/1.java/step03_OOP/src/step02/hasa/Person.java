package step02.hasa;

public class Person {
	Car myCar = new Car(); //��ü ����
	String name = "������"; //�̸� ��ü
	
	//getter setter ������
	public Car getMyCar() {
		return myCar;
	}
	public void setMyCar(Car myCar) {
		this.myCar = myCar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
