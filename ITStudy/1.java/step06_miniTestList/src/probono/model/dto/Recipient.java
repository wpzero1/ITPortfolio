package probono.model.dto;

public class Recipient extends People {
	private String receiveContent;

	public Recipient() {}
	
	public Recipient(String receiveContent) {
		super();
		this.receiveContent = receiveContent;
	}
	
	public Recipient(String id, String name, String password, String receiveContent) {
		super(id, name, password);
		this.receiveContent = receiveContent;
	}

	//?
		
	
	public String getReceiveContent() {
		return receiveContent;
	}

	public void setReceiveContent(String receiveContent) {
		this.receiveContent = receiveContent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 제공받는 대상자가 제공받는 서비스 : ");
		builder.append(receiveContent);
		builder.append("]");
		return builder.toString();
	}
}
