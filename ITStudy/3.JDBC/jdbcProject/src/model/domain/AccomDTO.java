package model.domain;

public class AccomDTO{
	private int a_index;
	private String a_name;
	private String a_tel;
	private String a_address;
	private String station;
	
	public AccomDTO() {	}
	public AccomDTO(int a_index, String a_name, String a_tel, String a_address, String station) {
	
		this.a_index = a_index;
		this.a_name = a_name;
		this.a_tel = a_tel;
		this.a_address = a_address;
		this.station = station;
	}
	public AccomDTO(String a_name, String a_tel, String a_address, String station) {
		
		this.a_name = a_name;
		this.a_tel = a_tel;
		this.a_address = a_address;
		this.station = station;
	}
	
	public int getA_index() {
		return a_index;
	}
	public void setA_index(int a_index) {
		this.a_index = a_index;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_tel() {
		return a_tel;
	}
	public void setA_tel(String a_tel) {
		this.a_tel = a_tel;
	}
	public String getA_address() {
		return a_address;
	}
	public void setA_address(String a_address) {
		this.a_address = a_address;
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
		builder.append("연번: ");
		builder.append(a_index);
		builder.append("\t업소명: ");
		builder.append(a_name);
		builder.append("\t\t\t 전화번호: ");
		builder.append(a_tel);
		builder.append("\t\t 주소: ");
		builder.append(a_address);
		builder.append("\t\t 주변 지하철역: ");
		builder.append(station);
		return builder.toString();
	}
	
	
}
