package FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileio {
   //week
   public  String FileInput(String filename) {
      String fileinput = "";
      try {
         File file = new File("C:\\ITStudy\\0.dataSet\\"+filename);
         //FileReader filereader = new FileReader(file);
         BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"EUC-KR"));
         String line = "";
         String[] line_arr=null;

         while ((line = bufReader.readLine()) != null) {
            //System.out.println(line);
            line_arr=line.split(",");

            fileinput =fileinput+ "{\"country\": \" " + line_arr[0] + "\", \"visits\" : "
                  +line_arr[1] + " ,\"color\" : \" "+line_arr[2]+" \" },";
            System.out.println("결과: "+fileinput);
         }

         bufReader.close();

      } catch (FileNotFoundException e) {
         System.out.println(e);
         return fileinput;
      } catch (IOException e) {
         System.out.println(e);
         return fileinput;
      }
      return fileinput;
   }
   
   
   
   //1행제거 파일 입출력
   public String FileInput_remove(String filename) {
      String fileinput = "";
      try {
         File file = new File("C:\\ITStudy\\0.dataSet\\"+filename);
         //FileReader filereader = new FileReader(file);
         BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"EUC-KR"));
         String line = "";
         String[] line_arr=null;
         line = bufReader.readLine();

         while ((line = bufReader.readLine()) != null) {
            //System.out.println(line);
            line_arr=line.split(",");

            fileinput =fileinput+ "{\"country\":  " + line_arr[0] + ", \"visits\" : "
                  +line_arr[1]+"  },";
            System.out.println("결과: "+fileinput);
         }

         bufReader.close();

      } catch (FileNotFoundException e) {
         System.out.println(e);
         return fileinput;
      } catch (IOException e) {
         System.out.println(e);
         return fileinput;
      }
      return fileinput;
   }
   
   
   //month
   public String FileInput_google(String filename) {
      String fileinput = "";
      try {
         File file = new File("C:\\ITStudy\\0.dataSet\\"+filename);
         FileReader filereader = new FileReader(file);
         BufferedReader bufReader = new BufferedReader(filereader);
         String line = "";
         line = bufReader.readLine();
         fileinput =fileinput+ "[ ' " + line.substring(0, line.lastIndexOf(",") - 1) + " ', '  "
               + line.substring(line.lastIndexOf(",") + 1) + " '],";

         while ((line = bufReader.readLine()) != null) {
            System.out.println(line);

            fileinput =fileinput+ "[ ' " + line.substring(1, line.lastIndexOf(",") - 1) + " ',   "
                  + line.substring(line.lastIndexOf(",") + 1) + " ],";
            System.out.println(fileinput);
         }

         bufReader.close();

      } catch (FileNotFoundException e) {
         System.out.println(e);
         return fileinput;
      } catch (IOException e) {
         System.out.println(e);
         return fileinput;
      }
      return fileinput;
   }
   
   //2month
   public String FileInput_table() {
      String fileinput = "";
      try {
         File file = new File("C:\\ITStudy\\0.dataSet\\bladeandsoul_Marketing_facebook.csv");
         //FileReader filereader = new FileReader(file);
         BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
         String line = "";
         String[] line_arr=null;

         while ((line = bufReader.readLine()) != null) {
            System.out.println(line);
            line_arr=line.split(",");
            System.out.println(line_arr[0]+"_"+line_arr[1]);
            fileinput+=line;
//            fileinput =fileinput+ "[ ' " + line.substring(0, line.lastIndexOf(",") - 1) + " '," 
//                  + line.substring(line.lastIndexOf(",") + 1) + "  ],";
            System.out.println(fileinput);
         }

         bufReader.close();

      } catch (FileNotFoundException e) {
         System.out.println(e);
         return fileinput;
      } catch (IOException e) {
         System.out.println(e);
         return fileinput;
      }
      return fileinput;
   }
   
//    public static void main(String[] args) {
//       FileInput("week.csv");
//       
//       }


}