package traffic.view;

import java.util.Scanner;

import traffic.controller.TrafficController;
import traffic.domain.TrafficDTO;

public class TrafficStartView {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		String areaInput;
		
		System.out.println("***모두 출력 ***");
		TrafficController.all();
		
		/*System.out.println("***데이터 추가 ***");
		TrafficDTO accident1 = new TrafficDTO(2018070615, "주간", "금", 1,1,1,1,"서울","강남구","수업중","중도퇴실","로드","선생님","학생");
		TrafficController.accidentInsert(accident1); */
		
		
		
		/*System.out.println("***데이터 수정***");
		int date = 2017010104;
		String area3 = "독도";
		TrafficController.areaChange(date, area3); */

		/*System.out.println("***데이터 삭제***");
		System.out.println("데이터를 삭제할 지역을 입력하세요 ex)서울");
		areaInput = scanner.nextLine();
		TrafficController.areaDelete(areaInput);
		
		
		System.out.println("***지역으로 검색***");
		System.out.println("검색할 지역을 입력하세요 ex)전남");
		areaInput = scanner.nextLine();
		TrafficController.areaSearch(areaInput); */
		
		
		/*System.out.println("***최대 ??? 지역***");
		TrafficController.findMax("Total");
		TrafficController.findMax("Death");
		TrafficController.findMax("InjuryHigh");
		TrafficController.findMax("InjuryLow");*/
		
	}
}
/*System.out.println("***데이터 수정***");
System.out.println("수정할 데이터의 날짜데이터를 입력해주세요 ex)2017010104");
int date = Integer.parseInt(scanner.nextLine());
	if(date !=0) {
System.out.println("해당 데이터의 지역 항목을 어느 내용으로 바꾸고 싶은가요?");
String area3 = scanner.nextLine();
//String area3 = "독도";
TrafficController.areaChange(date, area3);
	}
}
}*/