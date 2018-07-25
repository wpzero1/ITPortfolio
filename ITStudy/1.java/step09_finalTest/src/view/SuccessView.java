package view;

import java.util.HashMap;
import java.util.Iterator;

import model.dto.Electronics;

public class SuccessView {
	public static void allProductPrint(HashMap all){
		Iterator allProduct = all.keySet().iterator(); //데이터들을 순번 상관없이 받아서 쓰는 Iterator 사용, keySet 메소드로 키값을 하나씩 불러옴
		String key = null; //초기값을 null로 줌
		while(allProduct.hasNext()){ //allProduct에 오는 다음 배열에 데이터가 있는지 없는지를 판단
			key = (String)allProduct.next(); //데이터가 있다면 반환하는 next()를 통해 String값으로 key를 반환
			System.out.println("품목 : " + key + " - 모든 제품정보 " + all.get(key)); //출력
		}
	}
	
	public static void productPrint(Electronics product){
		System.out.println("제품 정보 - " + product);
	}
 
	public static void successMessage(String message) {
		System.out.println(message);
	}
}
