package step01;

public class Child extends Parent{ 
	String job;
	
	Child() {
		super("창윤",28); //컴파일 시에 생성자 안에 없으면 자동으로 만들어짐.
		//이 super()에 이어진 건 부모의 기본 생성자. 생성자 호출의 의미는 객체생성을 위함..
		//객체 생성 순서 : Object -> Parent(name, age) -> Child(job) 각 변수 공간이 사용가능하게 만들어짐.
		System.out.println("자식의 기본 생성자");
	
	}
	
	//재정의
	public void printAll() {
		super.printAll(); //슈퍼를 통해, 부모 내용도 다 가져옴
		//System.out.println(name);
		//System.out.println(age);
		System.out.println(job);
		
	}
	public static void main(String[] args) {
		Child c = new Child(); //부모 생성자는 안만들었는데, 부모의 기본생성자 메시지도 나온다.. 왜?
		
		//step02 - 다형성 문법 (다른사람 코드 분석하기 위해 이해 필요)
		Parent p = new Child(); //업캐스팅.
		p.name = "윤길";
		// p.job = "IT man"; //문법 오류. job 변수는 parent가 아니라 child에 있음
		//자식만의 멤버에 access를 위한 필수 문법 필요함 - 객체간의 형변환 부모와 자식 레벨을 맞춰주는데, 부모가 자식으로 맞춰줌 (다운캐스팅)
		Child c2 = (Child)p; //다른 c가 있으니 c2. 높은 레벨이 낮은 레벨로 맞춰줌. (여기선 p가 더 높은 것임)
		c2.job = "IT man";
		c2.printAll();
		
		
		
		System.out.println("-------------");
		//step01 - 상속관계의 객체 생성 학습
		System.out.println(c.name);
		c.name = "상만";
		System.out.println(c.name);
		c.printAll();
		
		
	}

}
