package traffic.domain;

public class TrafficDTO {
   private int Date;
   private String Ampm;
   private String Day;
   private int Total;
   private int Death;
   private int InjuryHigh;
   private int InjuryLow;
   private String City;
   private String Province;
   private String Accident;
   private String Law;
   private String Road;
   private String Target1;
   private String Target2;
public TrafficDTO() {
   super();
}
public TrafficDTO(int date, String ampm, String day, int total, int death, int injuryHigh, int injuryLow, String city,
      String province, String accident, String law, String road, String target1, String target2) {
   super();
   Date = date;
   Ampm = ampm;
   Day = day;
   Total = total;
   Death = death;
   InjuryHigh = injuryHigh;
   InjuryLow = injuryLow;
   City = city;
   Province = province;
   Accident = accident;
   Law = law;
   Road = road;
   Target1 = target1;
   Target2 = target2;
}
@Override
public String toString() {
   StringBuilder builder = new StringBuilder();
   builder.append("TrafficDTO [Date=");
   builder.append(Date);
   builder.append(", Ampm=");
   builder.append(Ampm);
   builder.append(", Day=");
   builder.append(Day);
   builder.append(", Total=");
   builder.append(Total);
   builder.append(", Death=");
   builder.append(Death);
   builder.append(", InjuryHigh=");
   builder.append(InjuryHigh);
   builder.append(", InjuryLow=");
   builder.append(InjuryLow);
   builder.append(", City=");
   builder.append(City);
   builder.append(", Province=");
   builder.append(Province);
   builder.append(", Accident=");
   builder.append(Accident);
   builder.append(", Law=");
   builder.append(Law);
   builder.append(", Road=");
   builder.append(Road);
   builder.append(", Target1=");
   builder.append(Target1);
   builder.append(", Target2=");
   builder.append(Target2);
   builder.append("]");
   return builder.toString();
}
public int getDate() {
   return Date;
}
public void setDate(int date) {
   Date = date;
}
public String getAmpm() {
   return Ampm;
}
public void setAmpm(String ampm) {
   Ampm = ampm;
}
public String getDay() {
   return Day;
}
public void setDay(String day) {
   Day = day;
}
public int getTotal() {
   return Total;
}
public void setTotal(int total) {
   Total = total;
}
public int getDeath() {
   return Death;
}
public void setDeath(int death) {
   Death = death;
}
public int getInjuryHigh() {
   return InjuryHigh;
}
public void setInjuryHigh(int injuryHigh) {
   InjuryHigh = injuryHigh;
}
public int getInjuryLow() {
   return InjuryLow;
}
public void setInjuryLow(int injuryLow) {
   InjuryLow = injuryLow;
}
public String getCity() {
   return City;
}
public void setCity(String city) {
   City = city;
}
public String getProvince() {
   return Province;
}
public void setProvince(String province) {
   Province = province;
}
public String getAccident() {
   return Accident;
}
public void setAccident(String accident) {
   Accident = accident;
}
public String getLaw() {
   return Law;
}
public void setLaw(String law) {
   Law = law;
}
public String getRoad() {
   return Road;
}
public void setRoad(String road) {
   Road = road;
}
public String getTarget1() {
   return Target1;
}
public void setTarget1(String target1) {
   Target1 = target1;
}
public String getTarget2() {
   return Target2;
}
public void setTarget2(String target2) {
   Target2 = target2;
}

   
  
}
 