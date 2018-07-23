/* 학습내용
 * 1. java.util.Set AIP 학습
 * 2. Set 특징
 * 		1) 중복 데이터 불허 (고유한 데이터만 저장)
 * 		2) 저장하는 문법은 쉽다, 단 데이터 하나하나 반환할 경우 Iterator API 활용해야함
 * 		3) 데이터 저장 순서에 대한 관리는 불가
 * 
 */

package step01.util;

import java.util.HashSet;
import java.util.Iterator;

public class Step02SetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); //하위 버전 고려해서 다 써줘
		//제네릭을 썼는데...
		
		set.add("a");
		set.add("a");
		set.add("d"	);
		set.add("b"	);
		set.add("e"	);
		set.add("c"	);
		
		
		System.out.println(set.toString()); //[a, b, c, d, e] 중복은 안됨
		
		//순서에 대한 보장은 안함. 입력을 오름차순으로 안해도 결과가 오름차순으로 나옴...
		/* Set 내부에 있는 데이터들을 하낳나씩 반환받아 사용하기
		 * 1. Iterator
		 * 		- 모든 데이터들을 정해진 순번 없이 열거해서 하나씩 사용가능하게 해주는 API
		 * 		- 데이터 존재 확인 가능 - hasNext()
		 * 		- 존재할 경우 반환하는 기능 - next()
		 * 2. 개발 로직을 말로 해보기 (의사 코드)
		 * 		1단계 - HashSet 객체의 데이터들을 Iterator로 변환
		 * 		2단계 - Iterator에서 데이터 존재 여부 확인
		 * 				반복문 필요
		 * 					for ? while? do~while?
		 * 
		 * 		3단계 - 존재할 경우
		 * 					데이터 반환
		 * 				- 미존재할 경우
		 * 					종료
		 * 
		 */
		
		Iterator all = set.iterator(); //set이라는 애가 iterator에 존재함. import도 해야함.  위에꺼 선택. Iterator라는 타입의 all로 받아주는 객체 만들기
		String data = null;
		while(all.hasNext()) {
			//data = all.next(); 얘는 안됨. 현재는 안됨. 아래 제네릭 반영한다면 가능하다.
			//퍼포먼스 측면에서 while안에서 변수 변경
			data = (String)all.next(); //얘는 됨. 형변환 했으니까
			System.out.println(data);
			
		}
		//제네릭 반영 후 형변환 없이 객체들 (element) 활용
		Iterator <String> all2 = set.iterator();
		String data2 = null;
		while(all2.hasNext()) {
			data2 = all2.next();
			System.out.println(data2);
		}
	}

}
