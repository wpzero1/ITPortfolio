package view;

import controller.Controller;
import model.domain.DeptDTO;

public class StartView {

	public static void main(String[] args) {
		Controller controller = Controller.getInstance(); //��ü���� �޾ƿ���. controller�� �ִ� �޼ҵ� �� �� �� �ִ� ����.
		
		//��� �˻�
		//controller.getDeptAll();
		
		//insert
		//controller.insert(new DeptDTO(60,"������","���ﵿ"));
		//controller.insert(new DeptDTO(10,"������","���ﵿ"));
		
		//��� �˻� �ٽ�
		//controller.getDeptAll();
		
		//deptno�� �˻�
		//controller.getDeptInfo(30);
		
		//�� ����
		//controller.updateLoc(30, "�λ�");
		
		//��� �˻� �ٽ�
		//controller.getDeptAll();
		
		controller.deleteDept(10);
		
		controller.getDeptAll();
	}

}