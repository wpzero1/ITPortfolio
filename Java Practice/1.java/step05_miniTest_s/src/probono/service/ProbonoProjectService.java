/*1. 서버 내부에 이 객체 수를 하나만 절대적으로 보장하는 구조
 *2. Singleton Design Pattern(싱글톤 디자인 패턴)
 *		1) 객체 수는 무조건 하나
 *		2) 개발 구조
 *			1] 생성자는 외부 클래스에게 은닉
 *			    private 생성자([..]){[..]}
 *			2] 동일한 클래스 내에서 생성자 호출
 *				객체 생성
 *			3] 생성된 객체를 외부 클래스에서 사용하게 하려면?
 *				생성된 객체의 주소값 반환
 *				이 기능의 메소드는 public
 *				이 메소드 호출 시점은 외부 클래스에서 객체 생성없이 호출 따라서 메소드는 static(어디에서도 호출 가능해야함)
 */

package probono.service;

import probono.model.dto.Activist;
import probono.model.dto.People;
import probono.model.dto.ProbonoProject;
import probono.model.dto.Recipient;

public class ProbonoProjectService {
	
	private static ProbonoProjectService instance = new ProbonoProjectService();
	
	private ProbonoProject[] projectList = new ProbonoProject[10];
	private int index;

	private ProbonoProjectService(){}
	
	public static ProbonoProjectService getInstance(){ //이게 싱글톤 디자인 패턴
		// if(instance ==null) { //이 두 줄은 생성된 객체를 외부 클래스에서 사용하게 하는 방법, 안정적이지만 퍼포먼스가 떨어진다고.
		//	instance = new ProbonoProjectService();
		return instance;
	}
	
	//모든 Project 반환
	public ProbonoProject[] getAllProjects() {
		return projectList;
	}

	//Project 검색
	public ProbonoProject getProbonoProject(String projectName) {
		ProbonoProject project = null;
		for (int i = 0; i < index; i++) {
			if (projectList[i].getProbonoProjectName().equals(projectName)) {
				project = projectList[i];
				break;
			}
		}
		return project;
	}

	//Project 추가
	public void projectInsert(ProbonoProject project) {
		projectList[index++] = project;
	}
	
	
	//??? 다형성 적용 메소드로 확장하기
	//instanceof - 객체 타입 비교 연산자 활용
	//Project 수정 - 프로젝트 명으로 재능 기부자 수정 
	// -> 경로를 잘 따라가고 파악할 것. Model 파트는 로직을 담고있다고 보면 된다. 현재 클래스. 여기선 Controller는 따로 없음
	public void projectUpdate(String projectName, People people){
		for (int i =0; i<index; i++) {
			if (projectList[i].getProbonoProjectName().equals(projectName)) {
				if(people instanceof Activist) {
					Activist a = (Activist)people;
					projectList[i].setActivist(a);
					break;
				}
				else if(people instanceof Recipient) {
					Recipient r = (Recipient)people;
					projectList[i].setReceive(r);
					
			}

		}
		}
	}
	
	
	
	 //Project 삭제 - 프로젝트명으로 해당 프로젝트 삭제
	public void projectDelete(String projectName) {
		for (int i = 0; i < index; i++) {
			if (projectList[i].getProbonoProjectName().equals(projectName)) {
				projectList[i] = null;
				break;
			}
		}
	}
	
	//Project 개수
	public int projectListSize(){
		return index;
	}
}
