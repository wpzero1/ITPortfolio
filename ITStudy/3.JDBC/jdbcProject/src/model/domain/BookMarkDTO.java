package model.domain;

public class BookMarkDTO {
	private int idx;
	private String kind;	//����,����
	private int num;
	private String name;
	private String foodKind;	//�ѽ�,�Ͻ�,�߽�
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
	
	public BookMarkDTO(int idx, String kind, int num, String name, String tel, String address, String station) {	//���� ������
		this.idx = idx;
		this.kind = kind;
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.station = station;
	}
	
	public BookMarkDTO(int idx, String kind, int num, String name, String foodKind, String tel,  String address, String station) {	//����������
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
	public String toString() {	//����
		StringBuilder builder = new StringBuilder();
		builder.append("����: ");
		builder.append(idx);
		builder.append("\t ����: ");
		builder.append(kind);
		builder.append("\t ���Ҹ�: ");
		builder.append(name);
		builder.append("\t ��ȭ��ȣ: ");
		builder.append(tel);
		builder.append("\t �ּ�: ");
		builder.append(address);
		builder.append("\t ����� ��: ");
		builder.append(station);
		return builder.toString();
	}
	

	public String toString2() {	//����
		StringBuilder builder = new StringBuilder();
		builder.append("����: ");
		builder.append(idx);
		builder.append("\t ����: ");
		builder.append(kind);
		builder.append("\t ���Ҹ�: ");
		builder.append(name);
		builder.append("\t ����: ");
		builder.append(foodKind);
		builder.append("\t ��ȭ��ȣ: ");
		builder.append(tel);
		builder.append("\t �ּ�: ");
		builder.append(address);
		builder.append("\t ����� ��: ");
		builder.append(station);
		return builder.toString();
	}
	
}
