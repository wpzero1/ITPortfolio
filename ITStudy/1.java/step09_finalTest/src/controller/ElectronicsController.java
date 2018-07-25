package controller;

import java.util.HashMap;

import view.FailView;
import view.SuccessView;
import exception.DuplicateException;
import exception.InexistentException;
import model.ElectronicsServiceImpl;
import model.dto.Electronics;

public class ElectronicsController {
	private static ElectronicsServiceImpl electroService = ElectronicsServiceImpl.getInstance(); //효율성을 위해 instance 객체를 생성
	
	//특정 제품 존재 유무 체크 로직
	public static void existElectronics(String kind, String modelNum){
		if(electroService.existElectronics(kind, modelNum)){
			SuccessView.successMessage(kind +"품목 " + modelNum + "에 해당하는 제품은 존재합니다");
		}else{
			FailView.errorMessage("해당 제품은 미 존재합니다.");
		}
	}
	
	//품복 구분없이 모든 제품 검색 로직
	public static void getAllElectronics(){
		HashMap allProduct = electroService.getElectronicsList(); //변수선언해서 한번밖에 안쓰니까 그냥 바로 밑에
		//SuccessView.allProductPrint(allProduct);	
		SuccessView.allProductPrint( electroService.getElectronicsList()); //한줄로 표현	
	}
	
	//품목별 모든 제품 검색
	public static void getKindElectronics(String kind){
		try {
			HashMap kindProduct = electroService.getKindElectronics(kind);
			SuccessView.allProductPrint(kindProduct);
		} catch (InexistentException e) { //미존재하는 데이터에 대한 예외 메소드
			FailView.errorMessage("요청하신 품목에 해당하는 제품들이 미 존재합니다.");
			e.printStackTrace();
		}
	}

	
	//특정 제품 검색
	public static void getElectronics(String kind, String modelNum){
		try {
			SuccessView.productPrint(electroService.getElectronics(kind, modelNum));
		} catch (InexistentException e) {
			//e.printStackTrace();
			FailView.errorMessage("해당 제품이 미 존재합니다.");
		}
	}
	
	//제품 저장
	public static void insertElectronics(String kind, Electronics product){
		try {
			electroService.insertElectronics(kind, product);
		} catch (DuplicateException e) { //이미 존재하는지 여부에 대한 예외 메소드
			//e.printStackTrace();
			FailView.errorMessage("이미 존재하는 품번입니다.");
		}
		SuccessView.successMessage(kind + "품목에 " + product.getModelNum() + "번호 제품을 새롭게 저장하였습니다.");
	}
	
	//제품 수정
	public static void updateElectronics(String kind, String modelNum, int newPrice){
		try {
			electroService.updateElectronics(kind, modelNum, newPrice);
		} catch (InexistentException e) {
			e.printStackTrace();
			FailView.errorMessage("미 존재하는 제품으로 수정 불가입니다.");
		}
		SuccessView.successMessage(kind + "품목의 " + modelNum + "번호 제품의 가격을 수정했습니다.");
	}
	
	//제품 삭제
	public static void deleteElectonics(String kind, String modelNum){
		try {
			electroService.deleteElectronics(kind, modelNum);
		} catch (InexistentException e) {
			e.printStackTrace();
			FailView.errorMessage("미 존재하는 제품으로 삭제 불가입니다.");
		}
		SuccessView.successMessage(kind + "품목의 " + modelNum + "번호 제품을 삭제했습니다.");
	}
}