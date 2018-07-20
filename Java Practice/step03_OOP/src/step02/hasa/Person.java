package step02.hasa;

public class Person {
	Car myCar = new Car(); //객체 생성
	String name = "서영상"; //이름 객체
	
	//getter setter 얻어오기
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
