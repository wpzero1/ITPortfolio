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
	
	//���Ҹ���Ʈ ��� ���
	public void getAll() {
		try {
			ArrayList<AccomDTO> datas = AccomDAO.getAll();
			if(datas.size() != 0) {
				EndView.printAll(datas);
			}else {
				EndView.succMsg("�˻��� ������ �����ϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");
		}
	}
	
	//������ �Է�->���� ��õ
	public void getAccom(String station) {
		try {
			ArrayList<AccomDTO> datas = AccomDAO.getAccom(station);
			if(datas != null) {
				EndView.printAll(datas);
			}else {
				EndView.errorMsg("������ȣ�� �ٽ� �Է��� �ּ���. (1~10)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");
		}
	}
	
	
	//���� �߰�
	public void insertAccom(AccomDTO newAccom) {
		try {
			if(AccomDAO.insert(newAccom)){
				EndView.succMsg("���ο� �������� ���� ����");
			}else {
				EndView.errorMsg("����");
			}
		} catch (SQLException e) {
			EndView.errorMsg("����, ���빮��, ȸ����, ��ȭ����, �湫�ο�, ����3����, ���̿�, ���¿���, ȫ���Ա���, ������ �߿����� �Է� �����մϴ�." );
		}
	}
	
	
	//���� ����
	public void delete(int deptno) {
		try {
			if(AccomDAO.delete(deptno)){
				EndView.succMsg("���� ���� ���� ����");
			}else {
				EndView.errorMsg("�ش� ��ȣ�� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("�ش� ������ ������ �� �����ϴ�.");
		} 
	}
	
	
	
	public void getFoodAll() {
	      try {
	         ArrayList<FoodDTO> datas = FoodDAO.getFoodAll();
	         if(datas.size() != 0) {
	            EndView.printFoodAll(datas);
	         }else {
	            EndView.succMsg("�˻��� ������ �����ϴ�.");
	         }
	      } catch (Exception e) {
	         EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");
	      }
	   }
	   //������ �Է�-> ���� ��õ
	      public void getFood(String foodstation) {
	         try {
	            ArrayList<FoodDTO> datas = FoodDAO.getFood(foodstation);
	            if(datas != null) {
	               EndView.printFoodAll(datas);
	            }else {
	               EndView.errorMsg("������ȣ�� �ٽ� �Է��� �ּ���. (1~10)");
	            }
	         } catch (Exception e) {
	            EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");
	         }
	      }
	      
	      
	      //���� �߰�
	      public void insertFood(FoodDTO newFood) {
	         try {
	            if(FoodDAO.insert(newFood)){
	               EndView.succMsg("���ο� �������� ���� ����");
	            }else {
	               
	            }
	         } catch (SQLException e) {
	            EndView.errorMsg("����, ���빮��, ȸ����, ��ȭ����, �湫�ο�, ����3����, ���̿�, ���¿���, ȫ���Ա���, ������ �߿����� �Է� �����մϴ�." );
	         }
	      }
	      
	      
	      //���� ����
	      public void deleteFood(int deptno) {
	         try {
	            if(FoodDAO.deleteFood(deptno)){
	               EndView.succMsg("���� ���� ���� ����");
	            }else {
	               EndView.errorMsg("�ش� ��ȣ�� �����ϴ�.");
	            }
	         } catch (SQLException e) {
	            EndView.errorMsg("�ش� ������ ������ �� �����ϴ�.");
	         } 
	      }
	
	
	
	
	
	//�ϸ�ũ ��ȸ
	public void getBookMark() {
		try {
			ArrayList<BookMarkDTO> datas = BookMarkDAO.getAll();
			if(datas.size() != 0) {
				EndView.printBookAll(datas);
			}else {
				EndView.succMsg("�˻��� ������ �����ϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.errorMsg("�˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�.");
		}
	}
	
	//�ϸ�ũ �߰�
	public void insertBookMark(BookMarkDTO newAccom) {
		try {
			if(BookMarkDAO.insert(newAccom)){
				EndView.succMsg("�ϸ�ũ ���� ����");
			}else {
				
			}
		} catch (SQLException e) {
			EndView.errorMsg("����, ���빮��, ȸ����, ��ȭ����, �湫�ο�, ����3����, ���̿�, ���¿���, ȫ���Ա���, ������ �߿����� �Է� �����մϴ�." );
		}
	}
	
	//�ϸ�ũ ����
	public void deleteBookMark(int index) {
		try {
			if(BookMarkDAO.delete(index)){
				EndView.succMsg("�ϸ�ũ ���� ����");
			}else {
				EndView.errorMsg("�ش� ��ȣ�� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("�ش� ������ ������ �� �����ϴ�.");
		} 
	}
}
