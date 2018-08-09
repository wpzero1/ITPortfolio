package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.FoodDTO;
import util.DBUtil;

public class FoodDAO {

   //맛집 조회

   public static ArrayList<FoodDTO> getFoodAll() throws Exception{
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      ArrayList<FoodDTO> datas = null;
      try {
         con = DBUtil.getConnection();
         stmt = con.createStatement();
         rs = stmt.executeQuery("select * from food order by f_index");
         datas = new ArrayList<FoodDTO>();
         
         while(rs.next()) {
            datas.add(new FoodDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));   
         }
      } catch (SQLException e) {
         throw e;   //catch 내에서 throw 해야만 end user에게 상황전달 가능
      } finally {
         DBUtil.close(con, stmt, rs);
      }
      
      return datas;
   }

   //맛집 추천

   public static ArrayList<FoodDTO> getFood(String station) throws SQLException{
      Connection con = null;
      PreparedStatement pstmt = null;
      ArrayList<FoodDTO> datas = null;
      ResultSet rs = null;
      try {
         con = DBUtil.getConnection();
         datas = new ArrayList<FoodDTO>();
         pstmt = con.prepareStatement("select * from food where station=?");
         pstmt.setString(1, station);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            datas.add(new FoodDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
         }
         
         
      } catch (SQLException e) {
         throw e;
      } finally {
         DBUtil.close(con, pstmt,rs);
      }
      
      return datas;
   }

   //맛집 추가

   public static boolean insert(FoodDTO newFood) throws SQLException{
      Connection con = null;
      PreparedStatement pstmt = null;
      
      try {
         con = DBUtil.getConnection();
         //고정된 문장으로 sql 실행 객체 생성
         pstmt = con.prepareStatement("insert into food values(seq_food_f_index.nextval,?,?,?,?,?)");
         //?에 데이터값 순차적으로 셋팅
         pstmt.setString(1, newFood.getF_name());
         pstmt.setString(2, newFood.getF_kind());
         pstmt.setString(3, newFood.getF_tel());
         pstmt.setString(4, newFood.getF_address());
         pstmt.setString(5, newFood.getStation());
         
         //db에 실제 실행
         int result = pstmt.executeUpdate();   //insert/update/delete 실행 메소드
         if(result == 0) {
            return false;
         }
      } catch (SQLException e) {
         throw e;   //catch 내에서 throw 해야만 end user에게 상황전달 가능
      } finally {
         DBUtil.close(con, pstmt);
      }
      
      return true;
   }

   //맛집 삭제
   public static boolean deleteFood(int index) throws SQLException{
         
         Connection con = null;
         PreparedStatement pstmt = null;   
         
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("delete from food where f_index=?");
            pstmt.setInt(1, index);
         
            
            //db에 실제 실행
            int result = pstmt.executeUpdate();   //insert/update/delete 실행 메소드
            if(result == 0) {
               return false;
            }
         } catch (Exception e) {
            e.printStackTrace();
            throw e;   //catch 내에서 throw 해야만 end user에게 상황전달 가능
         } finally {
            DBUtil.close(con, pstmt);
         }
         
         return true;
      }

}