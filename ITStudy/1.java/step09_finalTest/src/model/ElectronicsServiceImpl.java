package model;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import exception.DuplicateException;
import exception.InexistentException;
import model.dto.Electronics;
import model.dto.NoteBook;
import model.dto.SmartPhone;


public class ElectronicsServiceImpl{
	private static ElectronicsServiceImpl instance = new ElectronicsServiceImpl();
	
	//모든 전자제품 저장 객체
	private HashMap<String, HashMap> electronicsList = new HashMap<String, HashMap>();
	
	//제품 번호로 노트북 저장 객체
	private HashMap<String, Electronics> noteBookList = new HashMap<String, Electronics>();

	//제품 번호로 스마트폰 저장 객체
	private HashMap<String, Electronics> smartPhoneList = new HashMap<String, Electronics>();
	
	//properties파일로 부터 데이터 로딩(저장)해서 HashMap객체들에 저장
	/*	1. properties 두가지
	 * 2. 노트북 / 스마트폰 경로를 개념 properties 파일로 구분
	 * 3. properties로부터 데이터를 read해서 key=value 구조로 자바객체로 변환
	 * 		- Properties API는 properties파일의 구조처럼 데이터 관리
	 * 		- key=value 구조
	 * 		- HashMap과 흡사
	 * 
	 */
	private ElectronicsServiceImpl(){
		Properties productInfo = new Properties(); //Properties 객체 생성
		try {
			//notebooinfo.properties의 내용을 보유(Properties 객체에)
		/*		   NT900X4D-A68S=NT900X4D-A68S,삼성센스,1300,Windows 8
					NT900X4D-A99S=NT900X4D-A99S,삼성센스,1700,Windows 8 */
			
			productInfo.load(new FileReader("noteBookInfo.properties")); //키값을 뽑는다
			Iterator keyAll = productInfo.stringPropertyNames().iterator(); //키셋을 불러온다. set a = productInfo.stringPropertyNames() 를 줄여서..
			
			String key = null; //변수 선언 및 초기화
			String [] productValue = null; //배열 선언 및 초기화
			
			while(keyAll.hasNext()){ //순서는 중요하지 않고 키값을 통해 데이터를 하나하나씩 확인한다
				key = (String)keyAll.next();
				System.out.println("-----" + productInfo.getProperty(key));
 				productValue = productInfo.getProperty(key).split(",");
 				//key 값으로 받아온 value값으로 구성된 productInfo 정보를 productValue라는 변수로 받고 , 기호로 구분해서 받아온다
				
				noteBookList.put(key, new NoteBook(productValue[0], productValue[1], new Integer(productValue[2]), productValue[3]));
			}			
			electronicsList.put("noteBook", noteBookList);
			//electronics HashMap에 품목명인 "noteBook"을 키값으로 하는 noteBookList를 value값으로 넣음 (hashmap 안에 hashmap 구조) 
			
			//smartPhone 데이터 로딩 
			productInfo.load(new FileReader("smartPhoneInfo.properties"));
			keyAll = productInfo.stringPropertyNames().iterator();			
			
			while(keyAll.hasNext()){
				key = (String)keyAll.next();
				
				productValue = productInfo.getProperty(key).split(",");
				smartPhoneList.put(key, new SmartPhone(productValue[0], productValue[1], 
																			Integer.parseInt(productValue[2]),
																			productValue[3]));
			}
			electronicsList.put("smartPhone", smartPhoneList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ElectronicsServiceImpl getInstance(){
		return instance;
	}
	
	//모든 전자 제품 반환
	public HashMap<String, HashMap> getElectronicsList() {
		return electronicsList;
	}
	
	//모든 노트북 or 스마트 폰 반환  
	public HashMap<String, Electronics> getKindElectronics(String kind) throws InexistentException{ //예외는 Inexistent 예외 메소드로 넘김(존재 미존재 판별)
		if(electronicsList.get(kind) == null){ //가져온 데이터가 없으면 아래를 출력, 있으면 그 데이터를 리턴
			throw new InexistentException("검색하고자 하는 품목들의 제품이 없습니다.");
		}
		return electronicsList.get(kind);
	}
	
	//특정 제품 검색 
	public Electronics getElectronics(String kind, String modelNum) throws InexistentException{
		if((Electronics) (electronicsList.get(kind).get(modelNum)) == null){
			throw new InexistentException();
		}
		return (Electronics) (electronicsList.get(kind).get(modelNum));
	}
	
	
	//제품 고유 번호로 제품 존재 유무 체크 메소드
	/* true - 존재할 경우 반환값
	 * false - 미존재할 경우 반환값	 */
	public boolean existElectronics(String kind, String modelNum){ 
		return electronicsList.get(kind).containsKey(modelNum); //굳이 product라는 변수를 만들어 줄 필요가 없어 축소함
	}
	
	/* 저장
	 * 새로운 전자 제품 저장 
	 */
	public void insertElectronics(String kind, Electronics product) throws DuplicateException{
		if(!existElectronics(kind, product.getModelNum())){
			electronicsList.get(kind).put(product.getModelNum(), product);
		}else{
			throw new DuplicateException();
		}
	}
	
	/* 수정
	 * kind, 모델로 모델 가격 수정하기 
	 */
	public void updateElectronics(String kind, String modelNum, int newPrice) throws InexistentException{
		Electronics product = getElectronics(kind, modelNum);
		if(product != null){
			product.setPrice(newPrice);
		}
	}
	
	
	/* 삭제
	 * kind, modelNum으로 제품 삭제 
	 */
	public void deleteElectronics(String kind, String modelNum) throws InexistentException{
		getKindElectronics(kind).remove(modelNum);
	}
}