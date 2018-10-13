package marketing;

public class marketingDTO {
	String ad_Name;
	float install;
	float cost;
	float click;
	float reach;

	public marketingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public marketingDTO(String ad_Name, float install, float cost, float click, float reach) {
		super();
		this.ad_Name = ad_Name;
		this.install = install;
		this.cost = cost;
		this.click = click;
		this.reach = reach;
	}

	public String getAd_Name() {
		return ad_Name;
	}

	public void setAd_Name(String ad_Name) {
		this.ad_Name = ad_Name;
	}

	public float getInstall() {
		return install;
	}

	public void setInstall(float install) {
		this.install = install;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getClick() {
		return click;
	}

	public void setClick(float click) {
		this.click = click;
	}

	public float getReach() {
		return reach;
	}

	public void setReach(float reach) {
		this.reach = reach;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("marketingDTO [ad_Name=");
		builder.append(ad_Name);
		builder.append(", install=");
		builder.append(install);
		builder.append(", cost=");
		builder.append(cost);
		builder.append(", click=");
		builder.append(click);
		builder.append(", reach=");
		builder.append(reach);
		builder.append("]");
		return builder.toString();
	}

}