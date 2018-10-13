package traffic.view;

import java.util.ArrayList;

import traffic.domain.TrafficDTO;

public class TrafficEndView {

	public static void AllDatasView(ArrayList<TrafficDTO> data){
		for(int index = 0; index < data.size(); index++){			
			if(data.get(index) != null){
				System.out.println("[사건 " + (index+1) + "]\n" + data.get(index));
			}
		}
	}
	public static void AccidentView(ArrayList<TrafficDTO> data2){
			for (int i = 0; i < data2.size(); i++) {
			System.out.println("[사건 " + (i+1) + "]\n" + data2.get(i));
		}
			if (data2.size() != 0) {
			}
			else {
				System.out.println("해당 데이터가 존재하지 않아 요청하신 작업을 실패했습니다.");
			}
	}
	public static void AreaView(String data3){
			System.out.println(data3);
	}
}
