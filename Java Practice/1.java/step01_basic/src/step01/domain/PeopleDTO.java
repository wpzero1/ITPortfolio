/* Data Transfer Object = Value Object = Java Bean
 * 1. ����Ģ
 * 		- ������ �̸� ���� : DTO.java / ������VO.java / ������Bean.java / ������ (ȸ���� �꿡 ������)
 *	2. ����
 *		- ��� ���� : private
 *		- ��� �޼ҵ� : ���� �� �����Ͱ� ��ȯ, ������ �� ���� �������θ� ����. ������ ���� �޼ҵ忡�� ���� ��ȿ�� ���� ����
 *		- ������ : �⺻������, ��� ������ �ʱ�ȭ ������
 *		- toString() : ��� �����鰪 �����ؼ� ��ȯ�ϴ� �޼ҵ�
 */

  package step01.domain;
 

public class PeopleDTO {
	private String name;
	private int age; 

	//private : �ٸ� �������� �� �� ����. �� Ŭ���������� ���� ������ ����
	
	
	
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
	@Override
	public String toString() {
		return "PeopleDTO [name=" + name + ", age=" + age + "]"; //toString generate ����
		
		//�̰��� �����͸� �����ִ� DTO�� ������
		//���ú����� 4��. ()�ȿ��ִ� ������ �۾��� �� ����
	}
	
	
	
	
}
