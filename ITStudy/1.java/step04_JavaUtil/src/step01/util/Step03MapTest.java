/*학습 내용
 * 1. 고유한 key로 value구분해서 관리 및 활용
 * 2. 주의사항
 * 		1) key는 절대 중복 불허
 * 		2) list처럼 index 자체가 미존재
 * 		3) 저장하고자 하는 제네릭(타입 제약) 가능
 * 3. 실습 단계
 * 		1) 단순 문자열 저장
 * 		2) PeopleDTO 저장
 * 		3) ProbonoProject 저장
 * 		4) ProbonoProject들이 저장된 ArrayList를 저장
 * 
 */

package step01.util;

import java.util.ArrayList;
import java.util.HashMap; //임포트 먼저! 
import java.util.Iterator;
import java.util.Set;

import probono.model.dto.Activist;
import probono.model.dto.Probono;
import probono.model.dto.ProbonoProject;
import probono.model.dto.Recipient;

public class Step03MapTest {
	
	public static void m1() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one","영상"); //저장은 put
		map.put("one","한림"); //중복된거는 가차없이 기존껄 버림
		map.put("a","영상");
		map.put("b","한림");
		map.put("c","영상");
		map.put("d","한림");
		
		
		System.out.println(map); //컴파일 직후에는 map.toString()
		System.out.println(map.get("one")); //get은 데이터 반환
		map.remove("one"); //삭제는 이렇게
		System.out.println(map.get("one")); //API 사이트 참조해서 삭제하는걸 찾아보자
		
		/* 데이터 제공자와 데이터 활용자는 다름
		 * 제공자는 HashMap반환, 단 어떠한 key가 있는지 정보 언급 없이 반환
		 * 받아서 사용하는 활용자는 현재 key를 몰라
		 * 단, API 메소드로 key 확인 가능
		 * (hint) 단, key는 set 구조로 관리 
		 */
		
		Set keys = map.keySet(); //keySet API 쓰자. 임포트
		System.out.println(keys);
		
		Iterator allKey = keys.iterator(); //하나하나 데이터 뽑으려면? //제네릭 선언하면 Iterator <String> all key = keys.iterator();
		String k = null;
		while(allKey.hasNext()) {
			k = (String) allKey.next(); //제네릭 선언하면 (String) 형변환 안해도 됨
			System.out.println(k + " " + map.get(k));
		}
	}
	
	public static void m2() {
		HashMap<String, PeopleDTO> all = new HashMap <String, PeopleDTO>();
		all.put("a", new PeopleDTO("영복", 25)); //문자열 저장이 아니라 new PeopleDTO를 넣었다
		all.put("b", new PeopleDTO("경남", 28));
		
		//경남씨 이름만 출력되게 해주세요. - b에 매핑되어있음
		
		PeopleDTO man = all.get("b");
		String name = man.getName();
		System.out.println(name);
		
		System.out.println(all.get("b").getName());
	}
		
		//ProbonoProject 객체를 ArrayList<E>에 
		
		public static void m3() {
			ArrayList<ProbonoProject> all = new ArrayList <ProbonoProject>(); //all은 ArrayList.
			//기부자
			Activist audrey = new Activist("giver", "오드리", "pw1", "미용");
			//수혜자
			Recipient receive = new Recipient("receivePeople", "나문화", "pw2", "무상컷팅희망");
			//재능 기부 내용
			Probono audreyHepbun 
				= new Probono("audreyHepbun", "오드레햅번 프로젝트", "예술가, 문화관련 프로그램 제공, 전시ㆍ관람 등 기회제공, 미용,환경 캠페인 등 문화ㆍ예술관련 분야");
			//재능 기부 프로젝트
			ProbonoProject audreyHepbunProject 
			= new ProbonoProject("오드리햅번 프로젝트", audreyHepbun, audrey, receive, "헤어미용분야");
			
			
			
			//기부자
			Activist audrey2 = new Activist("giver2", "나드리", "pw1", "피부관리");
			//수혜자
			Recipient receive2 = new Recipient("receivePeople2", "나문화", "pw2", "무상컷팅희망");
			//재능 기부 내용
			Probono audreyHepbun2 
				= new Probono("슈바이처", "슈바이처 프로젝트", "예술가, 문화관련 프로그램 제공, 전시ㆍ관람 등 기회제공, 미용,환경 캠페인 등 문화ㆍ예술관련 분야");
			//재능 기부 프로젝트
			ProbonoProject audreyHepbunProject2
			= new ProbonoProject("슈바이처 프로젝트", audreyHepbun2, audrey2, receive2, "헤어미용분야");
			
			all.add(audreyHepbunProject);
			all.add(audreyHepbunProject2);
			
			 //HashMap에서 ArrayList 반환, 	기부자 이름들 출력, 진행되는 프로젝트 이름들 출력
			 
			HashMap<String, ArrayList> allProject = new HashMap<String, ArrayList>();
			allProject.put("project1", all); //객체가 객체를 갖고있는 포함관계. 원래 ArrayList만 갖고 있는데...
						
			ArrayList datas = allProject.get("project1");
			int count = datas.size();
			ProbonoProject project3 = null;
			//ArrayList에 저장된 ProbonoProject 수 만큼 반복하면서 기부자인 Activist 반환, 기부자 객체의 getName()호출 결과 출력
				for(int i=0 ; i<count; i++) {
					project3 = (ProbonoProject)datas.get(i);
								
					System.out.println(project3.getActivist().getName());
				}
		}
				
				
				
				//ArrayList자체를 제네릭으로 받아오는 경우 -> 기존보다 간단. 형변환 필요 없음
			/*	
				HashMap<String, ArrayList<ProbonoProject>> allProject = new HashMap<>();
				allProject.put("Project1", all);
				
				ArrayList<ProbonoProject> datas = allProject.get("project1");
				int count = datas.size();
				for(int i=0 ; i<count; i++) {
							
					System.out.println(datas.get(i).getActivist().getName());
			*/
				
				
				
				
				
		
			
			//이름 호출하기
				
			/*ProbonoProject project = all.get(0);
			
			Activist person = project.getActivist();
			String name = person.getName();
			System.out.println(name);
			
			System.out.println(all.get(0).getActivist().getName()); //한줄로 줄이는 법은 우변을 잘 살펴보면 된다.
			
			ProbonoProject project2 = all.get(1);
			Activist person2 = project2.getActivist();
			String name2 = person2.getName();
			System.out.println(name2);
			
			System.out.println(all.get(1).getActivist().getName());
			*/
	
	
		
		
		
	
	public static void main(String[] args) {
		m1();
		m2();
		m3();
	}

}
