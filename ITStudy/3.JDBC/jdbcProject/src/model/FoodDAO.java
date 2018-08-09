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

   //���� ��ȸ

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
         throw e;   //catch ������ throw �ؾ߸� end user���� ��Ȳ���� ����
      } finally {
         DBUtil.close(con, stmt, rs);
      }
      
      return datas;
   }

   //���� ��õ

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

   //���� �߰�

   public static boolean insert(FoodDTO newFood) throws SQLException{
      Connection con = null;
      PreparedStatement pstmt = null;
      
      try {
         con = DBUtil.getConnection();
         //������ �������� sql ���� ��ü ����
         pstmt = con.prepareStatement("insert into food values(seq_food_f_index.nextval,?,?,?,?,?)");
         //?�� �����Ͱ� ���������� ����
         pstmt.setString(1, newFood.getF_name());
         pstmt.setString(2, newFood.getF_kind());
         pstmt.setString(3, newFood.getF_tel());
         pstmt.setString(4, newFood.getF_address());
         pstmt.setString(5, newFood.getStation());
         
         //db�� ���� ����
         int result = pstmt.executeUpdate();   //insert/update/delete ���� �޼ҵ�
         if(result == 0) {
            return false;
         }
      } catch (SQLException e) {
         throw e;   //catch ������ throw �ؾ߸� end user���� ��Ȳ���� ����
      } finally {
         DBUtil.close(con, pstmt);
      }
      
      return true;
   }

   //���� ����
   public static boolean deleteFood(int index) throws SQLException{
         
         Connection con = null;
         PreparedStatement pstmt = null;   
         
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("delete from food where f_index=?");
            pstmt.setInt(1, index);
         
            
            //db�� ���� ����
            int result = pstmt.executeUpdate();   //insert/update/delete ���� �޼ҵ�
            if(result == 0) {
               return false;
            }
         } catch (Exception e) {
            e.printStackTrace();
            throw e;   //catch ������ throw �ؾ߸� end user���� ��Ȳ���� ����
         } finally {
            DBUtil.close(con, pstmt);
         }
         
         return true;
      }

}