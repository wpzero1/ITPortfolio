package traffic.view;

import java.util.ArrayList;

import traffic.domain.TrafficDTO;

public class TrafficEndView {

	public static void AllDatasView(ArrayList<TrafficDTO> data){
		for(int index = 0; index < data.size(); index++){			
			if(data.get(index) != null){
				System.out.println("[��� " + (index+1) + "]\n" + data.get(index));
			}
		}
	}
	public static void AccidentView(ArrayList<TrafficDTO> data2){
			for (int i = 0; i < data2.size(); i++) {
			System.out.println("[��� " + (i+1) + "]\n" + data2.get(i));
		}
			if (data2.size() != 0) {
			}
			else {
				System.out.println("�ش� �����Ͱ� �������� �ʾ� ��û�Ͻ� �۾��� �����߽��ϴ�.");
			}
	}
	public static void AreaView(String data3){
			System.out.println(data3);
	}
}
