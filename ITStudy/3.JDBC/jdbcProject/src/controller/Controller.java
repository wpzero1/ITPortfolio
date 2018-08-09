package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.AccomDAO;
import model.BookMarkDAO;
import model.FoodDAO;
import model.domain.AccomDTO;
import model.domain.BookMarkDTO;
import model.domain.FoodDTO;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	private Controller() {}
	
	public static Controller getInstance() {
		return instance;
	}
	
	//숙소리스트 모두 출력
	public void getAll() {
		try {
			ArrayList<AccomDTO> datas = AccomDAO.getAll();
			if(datas.size() != 0) {
				EndView.printAll(datas);
			}else {
				EndView.succMsg("검색한 데이터 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");
		}
	}
	
	//지역명 입력->숙소 추천
	public void getAccom(String station) {
		try {
			ArrayList<AccomDTO> datas = AccomDAO.getAccom(station);
			if(datas != null) {
				EndView.printAll(datas);
			}else {
				EndView.errorMsg("지역번호를 다시 입력해 주세요. (1~10)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");
		}
	}
	
	
	//숙소 추가
	public void insertAccom(AccomDTO newAccom) {
		try {
			if(AccomDAO.insert(newAccom)){
				EndView.succMsg("새로운 숙소정보 저장 성공");
			}else {
				EndView.errorMsg("실패");
			}
		} catch (SQLException e) {
			EndView.errorMsg("명동역, 동대문역, 회현역, 광화문역, 충무로역, 종로3가역, 이촌역, 이태원역, 홍대입구역, 강남역 중에서만 입력 가능합니다." );
		}
	}
	
	
	//숙소 삭제
	public void delete(int deptno) {
		try {
			if(AccomDAO.delete(deptno)){
				EndView.succMsg("숙소 정보 삭제 성공");
			}else {
				EndView.errorMsg("해당 번호가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("해당 정보를 삭제할 수 없습니다.");
		} 
	}
	
	
	
	public void getFoodAll() {
	      try {
	         ArrayList<FoodDTO> datas = FoodDAO.getFoodAll();
	         if(datas.size() != 0) {
	            EndView.printFoodAll(datas);
	         }else {
	            EndView.succMsg("검색한 데이터 없습니다.");
	         }
	      } catch (Exception e) {
	         EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");
	      }
	   }
	   //지역명 입력-> 맛집 추천
	      public void getFood(String foodstation) {
	         try {
	            ArrayList<FoodDTO> datas = FoodDAO.getFood(foodstation);
	            if(datas != null) {
	               EndView.printFoodAll(datas);
	            }else {
	               EndView.errorMsg("지역번호를 다시 입력해 주세요. (1~10)");
	            }
	         } catch (Exception e) {
	            EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");
	         }
	      }
	      
	      
	      //맛집 추가
	      public void insertFood(FoodDTO newFood) {
	         try {
	            if(FoodDAO.insert(newFood)){
	               EndView.succMsg("새로운 맛집정보 저장 성공");
	            }else {
	               
	            }
	         } catch (SQLException e) {
	            EndView.errorMsg("명동역, 동대문역, 회현역, 광화문역, 충무로역, 종로3가역, 이촌역, 이태원역, 홍대입구역, 강남역 중에서만 입력 가능합니다." );
	         }
	      }
	      
	      
	      //맛집 삭제
	      public void deleteFood(int deptno) {
	         try {
	            if(FoodDAO.deleteFood(deptno)){
	               EndView.succMsg("맛집 정보 삭제 성공");
	            }else {
	               EndView.errorMsg("해당 번호가 없습니다.");
	            }
	         } catch (SQLException e) {
	            EndView.errorMsg("해당 정보를 삭제할 수 없습니다.");
	         } 
	      }
	
	
	
	
	
	//북마크 조회
	public void getBookMark() {
		try {
			ArrayList<BookMarkDTO> datas = BookMarkDAO.getAll();
			if(datas.size() != 0) {
				EndView.printBookAll(datas);
			}else {
				EndView.succMsg("검색한 데이터 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("죄송합니다. 잠시후에 재 요청 바랍니다.");
		}
	}
	
	//북마크 추가
	public void insertBookMark(BookMarkDTO newAccom) {
		try {
			if(BookMarkDAO.insert(newAccom)){
				EndView.succMsg("북마크 저장 성공");
			}else {
				
			}
		} catch (SQLException e) {
			EndView.errorMsg("명동역, 동대문역, 회현역, 광화문역, 충무로역, 종로3가역, 이촌역, 이태원역, 홍대입구역, 강남역 중에서만 입력 가능합니다." );
		}
	}
	
	//북마크 삭제
	public void deleteBookMark(int index) {
		try {
			if(BookMarkDAO.delete(index)){
				EndView.succMsg("북마크 삭제 성공");
			}else {
				EndView.errorMsg("해당 번호가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("해당 정보를 삭제할 수 없습니다.");
		} 
	}
}
