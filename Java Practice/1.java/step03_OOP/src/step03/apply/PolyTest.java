//다형성 익숙해지기
package step03.apply; 

public class PolyTest extends Object {

	
	public PolyTest() {
		super();
		//두가지 object 메소드가 필요하다. tostring, equals
	}
	//문자열 객체 생성후 Object(최상위) 타입으로 반환
	//Object 변수 = "문자열" ; (자동 형변환과 상동)
	
	public static Object getData() {
		return "문자열"; //String 객체 생성되야 -> 반환
	}
	
	public static void main(String[] args) {
		String data = (String)getData(); //(String)을 앞에 써서 형변환시켜줘야한다. 밑에 식을 보면 data 변수는 String이어야만 하니까. 
		System.out.println(data.charAt(0));
		
		System.out.println(( (String)getData() ).charAt(0));
		//실행 순서가 (String)getData()가 먼저 되어야해서, 소괄호로 먼저 시작되는 것을 써주고 charAt 쓴다
		//getData()는 Object에 속해있고, charAt(String에서 맨 앞글자 따오는 것) API가 존재함.
		
		

	}

}
