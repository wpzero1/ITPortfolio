package step01;

public class Parent extends Object{ //컴파일러가 알아서 추가해주는데, 상속할 것이다 라는 의미. Object가 모든 클래스의 조상격

	String name; //동일한 클래스 내에서는 사용가능하도록 오픈.
	int age;
	public Parent() {
		super(); // Object 객체가 생성
		System.out.println("부모의 기본 생성자");
	} //name, age 변수 공간이 사용 가능하게 heap 객체 내부에 생성
	//Parent 객체 생성
	
	public Parent(String name, int age) { //필드
		super();
		this.name = name;
		this.age = age;
		System.out.println("부모의 생성자");
		
	}
	
	public void printAll() {
		System.out.println(name);
		System.out.println(age);
		
	}
	
}
