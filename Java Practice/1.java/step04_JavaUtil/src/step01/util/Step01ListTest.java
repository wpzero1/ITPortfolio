/* 학습내용
 * 1. 주요 API
 * 		1) java.util
 * 		2) ArrayList - 동적배열과 흡사
 * 			- 첫 생성시 10개의 메모리 생성
 * 			- 11번째 데이터 넣으면 10개가 추가 생성(21, 31 등등에서도)
 * 
 * 		3) 메소드
 * 			1] 데이터 저장 : add(Object o) //모든 파라메터 저장
 * 			2] 데이터 삭제 : remove(int index) //몇번째 데이터 지워야지
 * 			3] 데이터 반환 : Object get(int index) //몇번째 데이터 결과값 주세요
 * 			4] 데이터 개수 : size() 
 * Object o = "Ee"; 
 * Object로 변환시켜서 들어가면  Object로 반환도 됨
 * 
 */

package step01.util;

import java.util.ArrayList; //java.util은 import 필수
			
public class Step01ListTest {

	public static void main(String[] args) {
		System.out.println("---제네릭 미 반영---");
		ArrayList a = new ArrayList();
		a.add(3); //new Integer(3)로 autoboxing해서 바뀔것임
		a.add("ans"); //모든 형식 나올 수 있음
		//? index 1번째 문자열 객체만이 보유한 charAt(1)
		String v = (String) a.get(1); //형변환 해야함
		System.out.println(v.charAt(1));
		//위 두줄을 한줄로 줄이면?
		System.out.println(((String)a.get(1)).charAt(1)); //a.get(1)부터 실행, String으로 형변환, 그리고 charAt(1)으로 1번째 문자열 추출
		
		
		
		//String들만 저장 가능한 동적 메모리의 배열 형태 객체 생성
		// 타입 제약 - 제네릭 : <>로 제약을 주는 것임
		System.out.println("---제네릭 적용한 list : jdk1.5부터 제시 ---");
		ArrayList<String> list = new ArrayList<String>();  //동적배열. 크기가 지정되지 않은 배열
		
		System.out.println(list.size()); //0. size라는 메소드를 통해 크기 나타냄
		//데이터 저장
		list.add("서영상"); //0번째 자동 저장
		//제네릭 구조는 형변환 없이 index 값으로 실제 생성된 타입의 객체로 반환
		System.out.println(list.get(0).charAt(0)); //list.get(0)은 string 객체다. 그냥 get(0).charAt(0)이면, get(0)은 Object라서 charAt불가
		
		list.add("김한림"); //1번째 자동 저장
		list.add("황인범"); //2번째 자동 저장
		//list.add(new Integer(3)); 문법 오류. 왜? String만 저장 가능하니까. 정수 3을 넣어도 new Integer(3)으로 자동 변환됨(Object 아래에 있기 때문에)
		System.out.println(list.size()); //3
		
		//index로 1에 저장된 데이터 반환 및 출력
		System.out.println(list.get(1));
		//데이터 삭제
		list.remove(1); //1번째 데이터 삭제
		System.out.println(list.size()); 
		System.out.println(list.get(1)); //2번째 있던 데이터가 1번째로...
		
		System.out.println(list); //전체 데이터 보여줌(배열로)
		
		
		System.out.println("--- DTO 객체 활용해 보기 ---");
		ArrayList<PeopleDTO> list2 = new ArrayList <PeopleDTO>();
		list2.add(new PeopleDTO("우현",20));
		list2.add(new PeopleDTO("현주",10));
		
		PeopleDTO one = list2.get(0);
		String name = one.getName();
		System.out.println(name);
		//위를 짧게 줄여쓰면?
		System.out.println(list2.get(0).getName());
		System.out.println(list2.get(1).getAge());
	}

}
