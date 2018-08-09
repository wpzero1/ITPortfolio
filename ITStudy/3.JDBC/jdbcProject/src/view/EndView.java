package view;

import java.util.ArrayList;

import model.domain.AccomDTO;
import model.domain.BookMarkDTO;
import model.domain.FoodDTO;

public class EndView {
	public static void printAll(ArrayList<AccomDTO> datas) {
		//jdk1.5���� �߰��� �ݺ���
		
		for(AccomDTO dto:datas) {
			System.out.println(dto.toString());
		}
		System.out.println("\n\n");
	}
	
	public static void printBookAll(ArrayList<BookMarkDTO> datas) {
		//jdk1.5���� �߰��� �ݺ���
		
		for(BookMarkDTO dto:datas) {
			System.out.println(dto.toString());
		}
		System.out.println("\n\n");
	}
	
	public static void succMsg(String msg) {
		System.out.println("���� ����: "+msg);
	}

	public static void errorMsg(String msg) {
		System.out.println("������ ����: "+msg);
	}

	public static void printAll(AccomDTO datas) {
		System.out.println(datas.toString());
	}
	
	public static void printFoodAll(ArrayList<FoodDTO> datas) {
	      for(FoodDTO dto:datas) {
	         System.out.println(dto.toString());
	      }
	      System.out.println("\n\n");
	   }   
	   
	 public static void printAll(FoodDTO datas) {
	    System.out.println(datas.toString());
	 }
}

