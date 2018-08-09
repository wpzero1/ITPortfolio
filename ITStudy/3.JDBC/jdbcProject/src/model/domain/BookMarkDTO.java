package model.domain;

public class BookMarkDTO {
	private int idx;
	private String kind;	//숙소,맛집
	private int num;
	private String name;
	private String foodKind;	//한식,일식,중식
	private String tel;
	private String address;
	private String station;
	
	
	
	public BookMarkDTO() {}
	public BookMarkDTO(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	public BookMarkDTO(int idx, String kind, int num) {
		super();
		this.idx = idx;
		this.kind = kind;
		this.num = num;
	}
	
	public BookMarkDTO(int idx, String kind, int num, String name, String tel, String address, String station) {	//숙소 생성자
		this.idx = idx;
		this.kind = kind;
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.station = station;
	}
	
	public BookMarkDTO(int idx, String kind, int num, String name, String foodKind, String tel,  String address, String station) {	//맛집생성자
		this.idx = idx;
		this.kind = kind;
		this.num = num;
		this.name = name;
		this.foodKind = kind;
		this.tel = tel;
		this.address = address;
		this.station = station;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodKind() {
		return foodKind;
	}
	public void setFoodKind(String foodKind) {
		this.foodKind = foodKind;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	@Override
	public String toString() {	//숙소
		StringBuilder builder = new StringBuilder();
		builder.append("순번: ");
		builder.append(idx);
		builder.append("\t 종류: ");
		builder.append(kind);
		builder.append("\t 업소명: ");
		builder.append(name);
		builder.append("\t 전화번호: ");
		builder.append(tel);
		builder.append("\t 주소: ");
		builder.append(address);
		builder.append("\t 가까운 역: ");
		builder.append(station);
		return builder.toString();
	}
	

	public String toString2() {	//맛집
		StringBuilder builder = new StringBuilder();
		builder.append("순번: ");
		builder.append(idx);
		builder.append("\t 종류: ");
		builder.append(kind);
		builder.append("\t 업소명: ");
		builder.append(name);
		builder.append("\t 업종: ");
		builder.append(foodKind);
		builder.append("\t 전화번호: ");
		builder.append(tel);
		builder.append("\t 주소: ");
		builder.append(address);
		builder.append("\t 가까운 역: ");
		builder.append(station);
		return builder.toString();
	}
	
}
