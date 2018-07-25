package view;

import controller.ElectronicsController;
import model.dto.NoteBook;


public class StartView {

	public static void main(String[] args) {
		//모든 전자제품 검색
		System.out.println("***** 모든 제품 검색 *****");
		ElectronicsController.getAllElectronics();
		
		//노트북 특정 제품 존재유무 확인
		System.out.println("\n***** 특정 제품 저장 존재 유무 확인 *****");
		ElectronicsController.existElectorincs("noteBook", "NT900X4D-A68S");
		
		//새로운 제품 저장 및 확인
		System.out.println("\n***** 새로운 제품 등록 및 등록된 제품 정보 확인 *****");
		ElectronicsController.insertElectronics("noteBook", new NoteBook("TK", "LG xnote", 1300, "Window 8") );
		ElectronicsController.getElectronics("noteBook", "TK");
		
		//수정
		System.out.println("\n***** 기존 제품 가격 수정 및 수정된 제품 정보 확인*****");
		ElectronicsController.updateElectronics("noteBook", "TK", 2000);
		ElectronicsController.getElectronics("noteBook", "TK");
		
		//삭제
		System.out.println("\n***** 기존 제품 삭제 및 삭제 유무 확인 *****");
		ElectronicsController.deleteElectonics("noteBook", "TK");
		ElectronicsController.getElectronics("noteBook", "TK");
	}

}
