package customer.domain;

public class CustomerDTO {
	private String id; //멤버변수 설계
	private String pw;
	private String name;
	private int age;
	private String grade;
	
	public CustomerDTO() {} // Source - Generate~~ 를 함. super() 지움
		public CustomerDTO(String id, String name, String pw, int age, String grade) {
		this.id = id;
		this.pw = pw;
		this.name = name;
				if(age>0) { //유효성 검증. 유효한 데이터를 얻겠다는 캡슐레이션 과정임
					this.age = age;
				}

		this.grade = grade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>0) { //여기서만 해준다면 위쪽 멤버변수에서는 -10이 들어가도 대입이 되니까 위에서 조건 또 넣어줘야함
		this.age = age;
		}
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}
	
	
}
