package rjava;

import java.io.IOException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;


public class rjava_con {

   public RConnection r = null;
   public REXP x = null;
   public String retStr = "";

   public rjava_con() throws RserveException, IOException {
      this.r = new RConnection();

   }

   public String returnRImg() throws REngineException, REXPMismatchException {

      String device = "jpeg";
      x = r.parseAndEval("try(" + device + "('test.jpg',quality=90))");
      //r.parseAndEval("barplot(iris$Sepal.Length) ");
      
      //라이브러리 로드
      r.parseAndEval("library(dplyr)");
      r.parseAndEval("library(NbClust)");
      
      //파일 읽어오기
      r.parseAndEval("test_activity_clst<- read.csv('C:\\\\ITStudy\\\\4.web\\\\.metadata\\\\.plugins\\\\org.eclipse.wst.server.core\\\\tmp0\\\\wtpwebapps\\\\BSProject\\\\upload\\\\test_activity_fix.csv' , sep=',' )");
      //r.parseAndEval("test_activity_clst<-test_activity_clst");
      //r.parseAndEval("plot(test_activity_clst$play_time)");
      
      //K-means 클러스터링
      r.parseAndEval("set.seed(0808)");
      r.parseAndEval("fit <- kmeans(test_activity_clst, centers=4, iter.max=10000)");
      r.parseAndEval("table(fit$cluster)");
      
      //군집  변수 추가
      r.parseAndEval("test_activity_clst$clst<- fit$cluster");
      
      //군집 라벨 부여하기
      r.parseAndEval("df<- data.frame(fit$centers)");
      r.parseAndEval("df$clst<- c(1,2,3,4)");
      r.parseAndEval("df[,'labeling']='month'");
      r.parseAndEval("df[rank(-df$whisper_chat)==1 | rank(-df$party_chat)==1 | rank(-df$guild_chat)==1 |  rank(-df$making_cnt)==1, 'labeling']='retained'");
      r.parseAndEval("df[rank(-df$cnt_enter_inzone_solo)==1 | rank(-df$cnt_enter_inzone_light)==1 | rank(-df$cnt_enter_inzone_normal)==1 | rank(-df$cnt_clear_inzone_solo)==1    | rank(-df$cnt_clear_inzone_light)==1 | rank(-df$cnt_clear_inzone_normal)==1,'labeling']='week' ");
      r.parseAndEval("df[df$play_time<0 & df$npc_exp<0 & df$cnt_enter_inzone_solo<0 & df$cnt_enter_inzone_light<0 & df$cnt_enter_inzone_normal<0   & df$cnt_clear_inzone_solo<0 & df$cnt_clear_inzone_light<0 ,'labeling']='2month'");
      
      r.parseAndEval("df_fix<-df[,21:22]");
      r.parseAndEval("test_activity_final<-merge(test_activity_clst,df_fix, by='clst')");
      r.parseAndEval("Final_Labeling<- test_activity_final[,-1]");
      
      //라벨별로 분리하기
      r.parseAndEval("week<- filter(Final_Labeling, labeling =='week')");
      r.parseAndEval("month<- filter(Final_Labeling, labeling =='month')");
      r.parseAndEval("month_2<- filter(Final_Labeling, labeling =='2month')");
      r.parseAndEval("retained<- filter(Final_Labeling, labeling =='retained')");
      
      //그래프를 그려주기 위한 라벨 스트링값 제거
      r.parseAndEval("week<-week[,-21]");
      r.parseAndEval("month<-month[,-21]");
      r.parseAndEval("month_2<-month_2[,-21]");
      r.parseAndEval("retained<-retained[,-21]");
      
      //그래프 그려줄 결과값 dataframe으로 저장
      r.parseAndEval("a<-as.data.frame(colMeans(week))");
      r.parseAndEval("b<-as.data.frame(colMeans(month))");
      r.parseAndEval("c<-as.data.frame(colMeans(month_2))");
      r.parseAndEval("d<-as.data.frame(colMeans(retained))");
      
      //파일 저장(변수 특징)
      r.parseAndEval("write.csv(a,'C:\\\\ITStudy\\\\0.dataSet\\\\NewFile_week.csv')");
      r.parseAndEval("write.csv(b,'C:\\\\ITStudy\\\\0.dataSet\\\\NewFile_month.csv')");
      r.parseAndEval("write.csv(c,'C:\\\\ITStudy\\\\0.dataSet\\\\NewFile_2month.csv')");
      r.parseAndEval("write.csv(d,'C:\\\\ITStudy\\\\0.dataSet\\\\NewFile_retained.csv')");
      
      //클러스터링된 결과
      r.parseAndEval("clustering_fit<-as.data.frame(table(fit$cluster))");
      r.parseAndEval("names(clustering_fit)<-c('clst' , 'object')");
      r.parseAndEval("clustering_result<-merge(df_fix,clustering_fit, by='clst')");
      r.parseAndEval("clustering_result<-clustering_result[,-1]");
      r.parseAndEval("write.csv(clustering_result,'C:\\\\ITStudy\\\\0.dataSet\\\\NewFile_clustering.csv',row.names=FALSE)");
      
      //차트 테스트용
      r.parseAndEval("barplot(colMeans(week))");
      
      
      //r.parseAndEval("");
      
      
      //r.parseAndEval("clust_1<- test_activity_clst[fit$cluster==1,,drop=FALSE]");
      //r.parseAndEval("clust_2<- test_activity_clst[fit$cluster==2,,drop=FALSE]");
      //r.parseAndEval("clust_3<- test_activity_clst[fit$cluster==3,,drop=FALSE]");
      //r.parseAndEval("clust_4<- test_activity_clst[fit$cluster==4,,drop=FALSE]");
      //r.parseAndEval("barplot(colMeans(clust_1))");
      

      // graphics off
      r.parseAndEval("graphics.off()");

      x = r.parseAndEval("r=readBin('test.jpg','raw',1024*1024); unlink('test.jpg'); r");

      System.out.println("good");

      return "일해라";
      //return x.asBytes();// img;
   }
}