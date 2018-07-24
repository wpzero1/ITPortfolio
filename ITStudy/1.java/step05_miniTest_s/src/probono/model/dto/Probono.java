//���� ��� ��ο� ���� ���� ���� Ŭ����

package probono.model.dto;

public class Probono {
	private String probonoId; //��� ��� id
	private String probonoName; //��� ��� �̸�
	private String probonoPurpose; //��� ��� ����(����)
	
	public Probono() {}
		
	public Probono(String probonoId, String probonoName, String probonoPurpose) {
		super();
		this.probonoId = probonoId;
		this.probonoName = probonoName;
		this.probonoPurpose = probonoPurpose;
	}
	
	public String getProbonoId() {
		return probonoId;
	}

	public void setProbonoId(String probonoId) {
		this.probonoId = probonoId;
	}

	public String getProbonoName() {
		return probonoName;
	}

	public void setProbonoName(String probonoName) {
		this.probonoName = probonoName;
	}

	public String getProbonoPurpose() {
		return probonoPurpose;
	}

	public void setProbonoPurpose(String probonoPurpose) {
		this.probonoPurpose = probonoPurpose;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[���κ��� ���̵� : ");
		builder.append(probonoId);
		builder.append(", ���κ��� �̸� : ");
		builder.append(probonoName);
		builder.append(", ���κ��� ���� : ");
		builder.append(probonoPurpose);
		builder.append("]");
		return builder.toString();
	}
}
