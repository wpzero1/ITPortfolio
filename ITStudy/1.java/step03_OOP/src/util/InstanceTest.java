package util;

public class InstanceTest {

	public static void main(String[] args) {
		//중간단계를 확인할 수 있는 코드를 짜보자
		D d = new D(); //메소드 호출
		System.out.println(d.c.b.a.no);
		/* d = D 객체
		 * d.c = C객체
		 * d.c.b = B객체
		 * d.c.b.a = A객체
		 * d.c.b.a.no = 
		 * 
		 * CustomerModel의 new CustomerDTO 를 본다면, 이 클래스 구조가 없으면 데이터를 만들수가 없다.
		 * 여기서는 객체 생성없이 호출해야한다.
		 * 멤버로 보유하고 있다면(물고물고 물리는 관계임) 참조를 통해서 객체 내의 변수를 불러올 수 있다
		 */
	}

}
class A{
	int no = 20;
	A(){ //생성자 : 메소드인데, 클래스 이름과 같으면 생성자라고 부른다. 사실 A() {}은 안만들어도 자동적으로 만들어진다.
		//super(); - 이것도 안만들어도 자동으로 만들어짐.
		System.out.println("A"); //중간단계 확인해보는거다. 이걸 쓰려면 생성자가 필요함
			}
	}
class B{
	A a = new A();
	B(){
		System.out.println("B");
		
	}
	}
class C{
	C(){
		System.out.println("C");
	}
	B b = new B(); //A 객체 만들어지고, B객체 만들어짐
}
class D{
	D(){
		System.out.println("D");
	}
	C c = new C(); // A,B,C,D 차례로 만들어짐
}

