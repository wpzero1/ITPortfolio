
package marketingDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import marketing.marketingDTO;
import sun.security.util.Length;

public class marketingDAO {
   static ArrayList<marketingDTO> facebook = new ArrayList<>();
   static ArrayList<marketingDTO> google = new ArrayList<>();
   static ArrayList<marketingDTO> naver = new ArrayList<>();
   float Value[] = { 1, 1, 1, 1 };

   public static void datasave() throws IOException {
      File file = new File("C:\\ITStudy\\4.web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BSProject\\upload\\Facebook.csv");
      FileReader filereader = new FileReader(file);
      BufferedReader br = new BufferedReader(filereader);
      String[] data = null;
      String line = null;
      line = br.readLine();
      while ((line = br.readLine()) != null) {
         System.out.println(line);
         data = line.split(",");
         System.out.println(data[1]);
         // marketingDTO tmp=new marketingDTO();
         facebook.add(new marketingDTO(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),
               Integer.parseInt(data[3]), Integer.parseInt(data[4])));
      }
      br.close();

      br = new BufferedReader(new FileReader("C:\\ITStudy\\4.web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BSProject\\upload\\Google.csv"));
      data = null;
      line = null;
      line = br.readLine();
      while ((line = br.readLine()) != null) {
         data = line.split(",");
         System.out.println(line);
         google.add(new marketingDTO(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),
               Integer.parseInt(data[3]), Integer.parseInt(data[4])));
      }
      br.close();

      br = new BufferedReader(new FileReader("C:\\ITStudy\\4.web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BSProject\\upload\\Naver.csv"));
      data = null;
      line = null;
      line = br.readLine();
      while ((line = br.readLine()) != null) {
         data = line.split(",");
         System.out.println(line);
         naver.add(new marketingDTO(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),
               Integer.parseInt(data[3]), Integer.parseInt(data[4])));
      }
      br.close();
   }

   public static float CPC(ArrayList<marketingDTO> platform, String ad_Name) {
      float cpc = 0;
      for (int i = 0; i < platform.size(); i++) {
         if (platform.get(i).getAd_Name().equals(ad_Name)) {
            cpc = platform.get(i).getCost() / platform.get(i).getClick();
         }
      }
      return cpc;
   }

   public static float CPI(ArrayList<marketingDTO> platform, String ad_Name) {
      float cpi = 0;
      for (int i = 0; i < platform.size(); i++) {
         if (platform.get(i).getAd_Name().equals(ad_Name)) {
            cpi = platform.get(i).getCost() / platform.get(i).getInstall();
         }
      }
      return cpi;
   }

   public static float CPM(ArrayList<marketingDTO> platform, String ad_Name) {
      float cpm = 0;
      for (int i = 0; i < platform.size(); i++) {
         if (platform.get(i).getAd_Name().equals(ad_Name)) {
            cpm = (float) platform.get(i).getCost() / (float) platform.get(i).getReach();
         }
      }

      return cpm;
   }

   public static float total_face(String column) throws IOException {
	   datasave();
      float total = 0;
      if (column.equals("Install")) {
         for (int i = 0; i < facebook.size(); i++) {
            total = total + facebook.get(i).getInstall();
         }
      } else if (column.equals("Cost")) {
         for (int i = 0; i < facebook.size(); i++) {
            total = total + facebook.get(i).getCost();
         }
      } else if (column.equals("Click")) {
         for (int i = 0; i < facebook.size(); i++) {
            total = total + facebook.get(i).getClick();
         }
      } else if (column.equals("Reach")) {
         for (int i = 0; i < facebook.size(); i++) {
            total = total + facebook.get(i).getReach();
         }
      }

      return total;
   }

   public static float total_google(String column) throws IOException {
	   datasave();
      float total = 0;
      if (column.equals("Install")) {
         for (int i = 0; i < google.size(); i++) {
            total = total + google.get(i).getInstall();
         }
      } else if (column.equals("Cost")) {
         for (int i = 0; i < google.size(); i++) {
            total = total + google.get(i).getCost();
         }
      } else if (column.equals("Click")) {
         for (int i = 0; i < google.size(); i++) {
            total = total + google.get(i).getClick();
         }
      } else if (column.equals("Reach")) {
         for (int i = 0; i < google.size(); i++) {
            total = total + google.get(i).getReach();
         }
      }

      return total;
   }

   public static float total_naver(String column) throws IOException {
	   datasave();
      float total = 0;
      if (column.equals("Install")) {
         for (int i = 0; i < naver.size(); i++) {
            total = total + naver.get(i).getInstall();
         }
      } else if (column.equals("Cost")) {
         for (int i = 0; i < naver.size(); i++) {
            total = total + naver.get(i).getCost();
         }
      } else if (column.equals("Click")) {
         for (int i = 0; i < naver.size(); i++) {
            total = total + naver.get(i).getClick();
         }
      } else if (column.equals("Reach")) {
         for (int i = 0; i < naver.size(); i++) {
            total = total + naver.get(i).getReach();
         }
      }

      return total;
   }

   public static String[] marketing_chart() throws IOException {
      datasave();
      String[] result = { "", "", "" };

      float[] facebook = { (float) (Math.round(total_face("Cost") / total_face("Click") * 100) / 100.0),
            (float) (Math.round(total_face("Cost") / total_face("Install") * 100) / 100.0),
            (float) (Math.round(total_face("Cost") / total_face("Reach") * 100) / 100.0) };

      float[] naver = { (float) (Math.round(total_naver("Cost") / total_naver("Click") * 100) / 100.0),
            (float) (Math.round(total_naver("Cost") / total_naver("Install") * 100) / 100.0),
            (float) (Math.round(total_naver("Cost") / total_naver("Reach") * 100) / 100.0) };

      float[] google = { (float) (Math.round(total_google("Cost") / total_google("Click") * 100) / 100.0),
            (float) (Math.round(total_google("Cost") / total_google("Install") * 100) / 100.0),
            (float) (Math.round(total_google("Cost") / total_google("Reach") * 100) / 100.0) };

      // String chart_data = " ['Platform', 'CPC', 'CPI', 'CPM'], " + "['Facebook', "
      // + facebook[0] + ", " + facebook[1]
      // + ", " + facebook[2] + "]," + "['Naver', " + naver[0] + ", " + naver[1] + ",
      // " + naver[2] + "],"
      // + "['Google', " + google[0] + ", " + google[1] + ", " + google[2] + "]";

       String chart_data = " ['Platform', 'Facebook', 'Naver', 'Google'], " +
             "['CPC', " + facebook[0] + ", " + naver[0]+ ", "+ google[0] +"]";
       result[0]=chart_data;
       
       chart_data =" ['Platform', 'Facebook', 'Naver', 'Google'], " +
             "['CPI', " + facebook[1] + ", " + naver[1] + ", "+ google[1] + "]";
       result[1]=chart_data;
       
       chart_data =" ['Platform', 'Facebook', 'Naver', 'Google'], " +
             "['CPM', " + facebook[2] + ", " + naver[2] + ", " + google[2] + "]";
       result[2]=chart_data;
       
       
      

      return result;
   }

   public float[] Value() throws IOException {

      float value[] = { 1, 1, 1, 1 };
      float tot_cost = total_face("Cost") + total_naver("Cost") + total_google("Cost");
      float tot_click = total_face("Click") + total_naver("Click") + total_google("Click");
      float tot_install = total_face("Install") + total_naver("Install") + total_google("Install");
      float tot_reach = total_face("Reach") + total_naver("Reach") + total_google("Reach");
      datasave();

      value[1] = (float) (Math.round((tot_cost / tot_click) * 100) / 100.00);
      value[2] = (float) (Math.round((tot_cost / tot_install) * 100) / 100.0);
      value[3] = (float) (Math.round((tot_cost / tot_reach) * 100) / 100.0);
      value[0] = value[1] + value[2] + value[3];

      return value;
   }

   // public static void main(String[] args) throws IOException {
   // marketing_chart();
   // for(int i=0; i<3; i++) {
   // System.out.println(facebook.get(i));
   // }
   //
   // }
}