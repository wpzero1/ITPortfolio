/* Data Transfer Object = Value Object = Java Bean
 * 1. ����Ģ
 * 		- ������ �̸� ���� : DTO.java / ������VO.java / ������Bean.java / ������ (ȸ���� �꿡 ������)
 *	2. ����
 *		- ��� ���� : private
 *		- ��� �޼ҵ� : ���� �� �����Ͱ� ��ȯ, ������ �� ���� �������θ� ����. ������ ���� �޼ҵ忡�� ���� ��ȿ�� ���� ����
 *		- ������ : �⺻������, ��� ������ �ʱ�ȭ ������
 *		- toString() : ��� �����鰪 �����ؼ� ��ȯ�ϴ� �޼ҵ�
 */

  package step01;
 

public class PeopleDTO {
	private String name;
	private int age; 


		//
	
	public PeopleDTO() {} //�⺻ ������. public���� ����. ���� Ŭ���� �̸����� ����. ��ü�� �����ϴ� ����. ���⼭�� ��ȯ���� �ʾ� return����
	public PeopleDTO(String newName, int newage) { //��� ���� �ʱ�ȭ�ϴ� ������ (Ư�� �����͸� ���Ӱ� �����Ϸ��� ����)
	name = newName;
	age = newage;
	}
	public String getName() { //name �� ���� getName�̶�� �޼ҵ�. ��ҹ��� ������ ��
		return name;
	}
	public void setName(String name) { //name ���� �����ϴ� set �޼ҵ�
		this.name = name; //this�� ��Ȯ�ϰ� �̰��� ����� ��°� ��Ī. ���� name�� ���ú�����
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/* @Override
	 *  - �ּ����� �� ���� ������� ��ɾ�
	 *  - �ش� ���忡 �°� ������ ���ϸ� ���� ������ �߻�
	 *  
	 *  @��ɾ� (@�� at �̶�� �д´�)
	 *   - @Override : �� �޼ҵ�� �ݵ�� ������ �ϼ��� ��� ���(�츮�� �ٲ� ���� ����)
	 
	@Override
	public String toString() {
		return "PeopleDTO [name=" + name + ", age=" + age + "]"; //toString generate ����
		
		//�̰��� �����͸� �����ִ� DTO�� ������
		//���ú����� 4��. ()�ȿ��ִ� ������ �۾��� �� ����
		
		*/
		
		//Source���� toString, ���⼭ Code Style Builder/Buffer ����
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PeopleDTO [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
		
		//������� ������, ���������� �޸� ó�� �����ս��� �� ����
		//string�� ��� �������� StringBuilder�� ���� �������� StringBuilder ��ü�� �����Ѵ�.
		//+�� �ٿ����� toString�� ��쿡�� ���ÿ��� �õ���, ��ü�� �ʹ� ���� �����ǹ�����.
	}

	
	/* equals() ������ �ڵ� ����
	 * PeopleDTO Ÿ�� ���� ��
	 * ����� �� 1 - PeopleDTO�� ���
	 * 		����ȯ
	 * 			����ȯ �� �ش� ��ü�� ������ �� : ���ǻ���(���ڿ� ������ equals()�� ��)
	 * 			����� �� 1 - �����Ͱ� �ٸ��� false ��ȯ
	 * 			����� �� 2 - �����Ͱ� ���� true ��ȯ
	 * 	����� �� 2 - false ��ȯ 
	 * 
	 */
	public boolean equals(Object dto) {
		if(dto instanceof PeopleDTO) {
			PeopleDTO abc = (PeopleDTO)dto;
			if(getName().equals(abc.getName()) && getAge() == abc.getAge()) { //String���� ==�ϸ� �ּҰ� �񱳱� ������ equals �������
			return true;
			}
		}
		return false;
	
	}
}
