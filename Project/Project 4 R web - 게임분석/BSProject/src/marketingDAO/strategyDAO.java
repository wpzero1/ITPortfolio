package marketingDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class strategyDAO {

   public static String FileInput() {
      String fileinput = "";
      try {
         File file = new File("C:\\ITStudy\\0.dataSet\\NewFile_retained.csv");
         // FileReader filereader = new FileReader(file);
         BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "EUC-KR"));
         String line = "";
         String[] line_arr = null;

         int total_count = 0;
         int f_cnt[] = { 0, 0, 0, 0 };
         int n_cnt[] = { 0, 0, 0, 0 };
         int g_cnt[] = { 0, 0, 0, 0 };
         int organic = 0;

         line = bufReader.readLine();
         while ((line = bufReader.readLine()) != null) {
            // System.out.println(line);
            total_count++;
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
             //System.out.println(g_cnt[0]+"="+g_cnt[1]+"="+g_cnt[2]+"="+g_cnt[3]);

         }

         
         fileinput = "{type: \"Facebook\", percent: " + f_cnt[0]*100 / total_count
               + ", color: \"#ff9e01\", subs: [{type: \"facebook_banner\", percent:" + f_cnt[1]*100 / total_count
               + "}, {type: \"facebook_article\", percent:" + f_cnt[2] *100/ total_count
               + "}, { type: \"facebook_video\", percent:" + f_cnt[3] *100/ total_count
               + "}]}, { type: \"Naver\", percent: " + n_cnt[0]*100 / total_count
               + ", color: \"#b0de09\", subs: [{ type: \"naver_search\", percent: " + n_cnt[1] *100/ total_count
               + "}, {type: \"naver_banner\", percent:" + n_cnt[2] *100/ total_count
               + "}, {type: \"naver_video\",  percent:" + n_cnt[3] *100/ total_count
               + "}]},{ type: \"Google\", percent:" + g_cnt[0] *100/ total_count
               + ", color: \"##fc2020\", subs: [{  type: \"google_banner\", percent:" + g_cnt[1] *100/ total_count
               + " }, { type:\"google_video\", percent:" + g_cnt[2] *100/ total_count
               + "  }, {type: \"google_search\", percent: " + g_cnt[3] *100/ total_count
               + "}]},{type: \"Organic\", percent:" + organic*100 / total_count + ",color: \"#3420fc\"}";

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
   
   
   
   
   
   


//   public static void main(String[] args) throws IOException {
//      System.out.println(FileInput());
//
//   }

}