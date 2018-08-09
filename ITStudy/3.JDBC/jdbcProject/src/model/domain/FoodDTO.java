package model.domain;

public class FoodDTO{
   private int f_index;
   private String f_name;
   private String f_kind;
   private String f_tel;
   private String f_address;
   private String station;
   
   public FoodDTO() {}

   public FoodDTO(int f_index, String f_name, String f_kind, String f_tel, String f_address, String station) {
      this.f_index = f_index;
      this.f_name = f_name;
      this.f_kind = f_kind;
      this.f_tel = f_tel;
      this.f_address = f_address;
      this.station = station;
   }
   
   public FoodDTO(String f_name, String f_kind, String f_tel, String f_address, String station) {
      this.f_name = f_name;
      this.f_kind = f_kind;
      this.f_tel = f_tel;
      this.f_address = f_address;
      this.station = station;
   }

   public int getF_index() {
      return f_index;
   }

   public void setF_index(int f_index) {
      this.f_index = f_index;
   }

   public String getF_name() {
      return f_name;
   }

   public void setF_name(String f_name) {
      this.f_name = f_name;
   }

   public String getF_kind() {
      return f_kind;
   }

   public void setF_kind(String f_kind) {
      this.f_kind = f_kind;
   }

   public String getF_tel() {
      return f_tel;
   }

   public void setF_tel(String f_tel) {
      this.f_tel = f_tel;
   }

   public String getF_address() {
      return f_address;
   }

   public void setF_address(String f_address) {
      this.f_address = f_address;
   }

   public String getStation() {
      return station;
   }

   public void setStation(String station) {
      this.station = station;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("연번");
      builder.append(f_index);
      builder.append("\t 업소명: ");
      builder.append(f_name);
      builder.append("\t 업종: ");
      builder.append(f_kind);
      builder.append("\t\t\t 전화번호: ");
      builder.append(f_tel);
      builder.append("\t\t 주소: ");
      builder.append(f_address);
      builder.append("\t\t\t 주변 지하철역 : ");
      builder.append(station);
      return builder.toString();
   }


   
}