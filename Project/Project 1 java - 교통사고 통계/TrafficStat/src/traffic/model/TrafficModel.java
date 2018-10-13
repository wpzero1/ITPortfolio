package traffic.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import traffic.domain.TrafficDTO;

public class TrafficModel {

	static ArrayList<TrafficDTO> dataList = new ArrayList<TrafficDTO>();
    static {
      //read 객체
      
      BufferedReader in = null;

      try {
         in = new BufferedReader(new FileReader("TrafficStat2017.csv"));
         String data = in.readLine();
      	 String[] array = data.split(",");
         while(data != null) {
         	array = data.split(",");
            dataList.add(new TrafficDTO(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3]), 
                        Integer.parseInt(array[4]), Integer.parseInt(array[5]), Integer.parseInt(array[6]), array[7], array[8], array[9], 
                        array[10], array[11], array[12],array[13]));
            data = in.readLine();
         } 
      } catch (IOException e) {
         e.printStackTrace();
      }finally {
         try {
            in.close();//사용했던 시스템 자원을 반환하기
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

	public static ArrayList<TrafficDTO> getAllDatas() {
		return dataList;
		
	}
	public static void AccidentInsert(TrafficDTO accident) {
		dataList.add(accident);
	}
	public static ArrayList  <TrafficDTO> AreaDelete(String area) {
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i).getCity().equals(area)) {
			dataList.remove(i);
			i = i - 1;
			}
		}
		return dataList;
	}
	public static ArrayList <TrafficDTO> AreaSearch(String area) {
		ArrayList <TrafficDTO> b = new ArrayList<TrafficDTO>();
		TrafficDTO a = null;
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i).getCity().equals(area)) {
				//a = dataList.get(i)
				b.add(dataList.get(i));
			}
		
		}
		return b;
	}
	public static ArrayList <TrafficDTO> AreaChange(int date, String area) {
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i).getDate() == date) {
				dataList.get(i).setCity(area);
			}
		}
		return dataList;
	}
	public static String FindMax (String category) {
		String MaxResult = null; 
		ArrayList <Integer> intArray1 = new ArrayList<Integer>();
		ArrayList <Integer> intArray2 = new ArrayList<Integer>();
		ArrayList <Integer> intArray3 = new ArrayList<Integer>();
		ArrayList <Integer> intArray4 = new ArrayList<Integer>();
		for (int i = 0; i < dataList.size(); i++) {
			intArray1.add(dataList.get(i).getTotal());
			intArray2.add(dataList.get(i).getDeath());
			intArray3.add(dataList.get(i).getInjuryHigh());
			intArray4.add(dataList.get(i).getInjuryLow());
			if (category.equals("Total") ) {
				MaxResult = "최대 총사상자 지역은 " + dataList.get(getIndexOfLargest(intArray1)).getCity() +" " +dataList.get(getIndexOfLargest(intArray1)).getProvince() + " "+ Collections.max(intArray1)+ "명 입니다.";
			}
			else if (category.equals("Death")) {
				MaxResult = "최대 사망자 지역은 " + dataList.get(getIndexOfLargest(intArray2)).getCity() +" " +dataList.get(getIndexOfLargest(intArray2)).getProvince() + " "+ Collections.max(intArray2) + "명 입니다.";
			}
			else if (category.equals("InjuryHigh")) {
				MaxResult = "최대 부상자 지역은 " + dataList.get(getIndexOfLargest(intArray3)).getCity() +" " +dataList.get(getIndexOfLargest(intArray3)).getProvince() + " "+ Collections.max(intArray3) + "명 입니다.";
			}
			else if (category.equals("InjuryLow")) {
				MaxResult = "최대 경상자 지역은 " + dataList.get(getIndexOfLargest(intArray4)).getCity() +" " +dataList.get(getIndexOfLargest(intArray4)).getProvince() + " "+ Collections.max(intArray4) + "명 입니다.";
				
			}
		}
		return "2017년 " + MaxResult;
	}
	public static int getIndexOfLargest( ArrayList<Integer> array )
	{
	  if ( array == null || array.size() == 0 ) return -1; // null or empty

	  int largest = 0;
	  for ( int i = 1; i < array.size(); i++ )
	  {
	      if ( array.get(i) > array.get(largest)) largest = i;
	  }
	  return largest; // position of the first largest found
	}
}