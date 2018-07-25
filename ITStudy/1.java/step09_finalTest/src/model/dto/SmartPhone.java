package model.dto;

public class SmartPhone extends Electronics{
	//네트워크
	private String network;//	Wi-Fi, 블루투스 4.0

	public SmartPhone() {}
	
	public SmartPhone(String modelNum, String modelName, int price, String network) {
		super(modelNum, modelName, price);
		this.network = network;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String newwork) {
		this.network = newwork;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmartPhone 정보 :");
		builder.append(" 모델번호 =");
		builder.append(getModelNum());
		builder.append(", 모델명 = ");
		builder.append(getModelName());
		builder.append(", 가격 = ");
		builder.append(getPrice());
		builder.append(", 네트워크 = ");
		builder.append(network);
		return builder.toString();
	}
}
