package view;

import java.util.ArrayList;

import model.domain.DeptDTO;

public class EndView {

	public static void printAll(ArrayList<DeptDTO> datas) { //<> ���׸��� ���� �־ ����ȯ�� �ʿ����. �Ⱦ��ٸ� �ؿ� Object dto�� ���Ե�
		//jdk1.5���� �߰��� �ݺ��� for(   :   ){}
		for(DeptDTO dto : datas) { //�̷��� size�� intŸ�� �ʱ�ȭ�� �ʿ����. ������ datas�� dto���� �־��ִ� ���ι��.
			System.out.println(dto.toString()); //toString ������ �� ���� ȣ����. ���ٷ� ��
		}
	}
	public static void printAll(DeptDTO datas) { 
			System.out.println(datas.toString()); 
		}
	
	public static void succMsg(String msg) {
		System.out.println("���� ���� : " + msg);
	}

	public static void errorMsg(String msg) {
		System.out.println("������ ���� : " + msg);
	}

}