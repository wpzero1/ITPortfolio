package model.dto;


public class Electronics implements java.io.Serializable{
	// 모델번호 
	private String modelNum;
	// 모델명 
	private String modelName;	
	// 가격 
	private int price;

	public Electronics() {	}

	public Electronics(String modelNum, String modelName, int price) {
		super();
		this.modelNum = modelNum;
		this.modelName = modelName;
		this.price = price;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("전자제품 정보 [모델번호=");
		builder.append(modelNum);
		builder.append(", 모델명=");
		builder.append(modelName);
		builder.append(", 가격=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
}
