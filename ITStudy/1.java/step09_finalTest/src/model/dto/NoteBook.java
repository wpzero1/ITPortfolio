package model.dto;

public class NoteBook extends Electronics{
	
	//메인보드
	private String os;

	public NoteBook() {
		super();
	}

	public NoteBook(String modelNum, String modelName, int price, String os) {
		super(modelNum, modelName, price);
		this.os = os;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NodeBook 정보 :");
		builder.append(" 모델번호 = ");
		builder.append(getModelNum());
		builder.append(", 모델명 = ");
		builder.append(getModelName());
		builder.append(", 가격 = ");
		builder.append(getPrice());
		builder.append(", 운영체제 = ");
		builder.append(os);
		return builder.toString();
	}
}
