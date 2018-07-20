package step02.hasa;

public class Engine {
	String engineName = "파워엔진"; //string객체
	int cc = 100;
	public Engine() {
		super();
	}

	public String getEngineName() {
		return engineName;
	}
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}
	
	//getter setter 받아오기
	
	public int getCc() {
		return cc;
	}
	
	public int getPowerCc() {
		return cc + 1000;
	}
	
	public void setCc(int cc) {
		this.cc = cc;
	}
	
	
}
