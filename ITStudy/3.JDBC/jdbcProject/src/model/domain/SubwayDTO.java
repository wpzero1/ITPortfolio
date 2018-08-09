package model.domain;

public class SubwayDTO {
	private String station;
	
	public SubwayDTO() {}
	public SubwayDTO(String station){
		this.station=station;
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
		builder.append("SubwayDTO [station=");
		builder.append(station);
		
		return builder.toString();
	}
	
}
