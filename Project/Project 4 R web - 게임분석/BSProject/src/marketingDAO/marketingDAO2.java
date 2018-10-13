
package marketingDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import marketing.marketingDTO;
import sun.security.util.Length;

public class marketingDAO2 {
    ArrayList<marketingDTO> facebook = new ArrayList<>();
    ArrayList<marketingDTO> google = new ArrayList<>();
    ArrayList<marketingDTO> naver = new ArrayList<>();
   
   float Value[] = { 1, 1, 1, 1 };

   public  void datasave() throws IOException {
      File file = new File(
            "C:\\ITStudy\\4.web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BSProject\\upload\\Facebook.csv");
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

      br = new BufferedReader(new FileReader(
            "C:\\ITStudy\\4.web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BSProject\\upload\\Google.csv"));
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

      br = new BufferedReader(new FileReader(
            "C:\\ITStudy\\4.web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BSProject\\upload\\Naver.csv"));
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

   
   
   

   public  float total_face(String column) throws IOException {
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

      System.out.println(total);
      return total;
   }

   public  float total_google(String column) throws IOException {
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

      System.out.println(total);
      return total;
   }

   public  float total_naver(String column) throws IOException {
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

      System.out.println(total);
      return total;
   }

   public  String[] marketing_chart() throws IOException {
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

      
      
      String chart_data = " ['Platform', 'Facebook', 'Naver', 'Google'], " + "['CPC', " + facebook[0] + ", "
            + naver[0] + ", " + google[0] + "]";
      result[0] = chart_data;

      chart_data = " ['Platform', 'Facebook', 'Naver', 'Google'], " + "['CPI', " + facebook[1] + ", " + naver[1]
            + ", " + google[1] + "]";
      result[1] = chart_data;

      chart_data = " ['Platform', 'Facebook', 'Naver', 'Google'], " + "['CPM', " + facebook[2] + ", " + naver[2]
            + ", " + google[2] + "]";
      result[2] = chart_data;

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
   
   
   
   public  int[] FileInput2() {
      int total_count[]= {0,0,0};
      try {
         File file = new File("C:\\ITStudy\\0.dataSet\\NewFile_retained.csv");
         // FileReader filereader = new FileReader(file);
         BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "EUC-KR"));
         String line = "";
         String[] line_arr=null;

         int f_cnt[] = { 0, 0, 0, 0 };
         int n_cnt[] = { 0, 0, 0, 0 };
         int g_cnt[] = { 0, 0, 0, 0 };
         int organic = 0;

         line = bufReader.readLine();
         while ((line = bufReader.readLine()) != null) {
      
            line_arr = line.split(",");

            // System.out.println(line_arr[2]);
            if (line_arr[1].equals("facebook")) {

               if (line_arr[2].equals("facebook_banner")) {
                  f_cnt[0] += 1;
                  f_cnt[1] += 1;
               } else if (line_arr[2].equals("facebook_article")) {
                  f_cnt[0] += 1;
                  f_cnt[2] += 1;
               } else if (line_arr[2].equals("facebook_video")) {
                  f_cnt[0] += 1;
                  f_cnt[3] += 1;
               }
            } else if (line_arr[1].equals("naver")) {

               if (line_arr[2].equals("naver_search")) {
                  n_cnt[0] += 1;
                  n_cnt[1] += 1;
               } else if (line_arr[2].equals("naver_banner")) {
                  n_cnt[0] += 1;
                  n_cnt[2] += 1;
               } else if (line_arr[2].equals("naver_video")) {
                  n_cnt[0] += 1;
                  n_cnt[3] += 1;
               }
            } else if (line_arr[1].equals("google")) {

               if (line_arr[2].equals("google_banner")) {
                  g_cnt[0] += 1;
                  g_cnt[1] += 1;
               } else if (line_arr[2].equals("google_video")) {
                  g_cnt[0] += 1;
                  g_cnt[2] += 1;
               } else if (line_arr[2].equals("google_search")) {
                  g_cnt[0] += 1;
                  g_cnt[3] += 1;
               }
            } else {
               organic++;
            }
         }
         total_count[0]=f_cnt[0];
         total_count[1]=g_cnt[0];
         total_count[2]=n_cnt[0];
         
         bufReader.close();

      } catch (FileNotFoundException e) {
         System.out.println(e);
         return total_count;
      } catch (IOException e) {
         System.out.println(e);
         return total_count;
      }
      return total_count;
   }
   
   
   public  int[] FileInput3() throws IOException {
      datasave();
      int result[]= {0,0,0,0,0,0};
      int people=0;
      try {
         File file = new File("C:\\ITStudy\\0.dataSet\\NewFile_retained.csv");
         // FileReader filereader = new FileReader(file);
         BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "EUC-KR"));
         String line = "";

         line = bufReader.readLine();
         while ((line = bufReader.readLine()) != null) {
            people++;
            
         }
      
         bufReader.close();

      } catch (FileNotFoundException e) {
         System.out.println(e);
         return result;
      } catch (IOException e) {
         System.out.println(e);
         return result;
      }
      
      //잔존 고객수(임의값) 
      result[0]=5;
      //실제  잔존수
      result[1]=people*100/1000;
      //목표 설치수(임의)
      result[2]=1200;
      //설치수
      result[3]=(int) (total_face("Install")+total_google("Install")+total_naver("Install"));
      result[3]=result[3]*100/result[2];
      //목표 CPI
      result[4]=1000;
      //실제 CPI
      result[5]=(int) (total_face("Cost")+total_google("Cost")+total_naver("Cost"))/result[3];
      result[5]=result[5]*100/result[4];
      
      System.out.println(result[3]+"="+result[5]+"="+result[3]);
      return result;
   }

    public  void main(String[] args) throws IOException {
    
      
    }
}