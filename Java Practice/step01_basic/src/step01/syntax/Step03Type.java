package step01.syntax;

import step01.domain.FriendVO;

public class Step03Type {

	//FriendVO ��ȯ �޼ҵ�
	FriendVO getInstance() { //�̰� ���� ctrl shift O�ϸ� ����Ʈ �ڵ����� ��
		return new FriendVO(); //�ٷ� ��ü �����ϴ� ��ȯ
	}
	//FriendVO �� �޼ҵ� parameter(�Ұ�ȣ)�� �ݿ��ϴ� �޼ҵ�
	void m(FriendVO v) { //a.m(FriendVO ��ü) �޼ҵ带 �����´ٴ� ��� .  FriendVO ��ü�� 1����
		System.out.println(2 + "" + v.name); //Ȳ�ι�
		v.name = "�տ���"; //�̰ŷ� ������ �ٲ�
		
	}
	/*
	void m() {} //a.m();
	void m(int i) {} //a.m(2);
	void m(String i) {} //a.m(String "wew");
	*/
	
	public static void main(String[] args) {
		Step03Type s = new Step03Type();
		FriendVO v = s.getInstance(); //��ġ���� 0x�� ����
		System.out.println(1+ "" + v.name);
		s.m(v); //0x �޼ҵ� ȣ������
		System.out.println(3+ "" + v.name); //�� ���� ���� ��µɱ�?
		
	}
	
	}

