/* 작품 내용
 * 1. 오늘 배운 내용에 한해서 2~3개의 메소드를 개발
 * 2. 반복, 조건 등에 대한 연습이 될 수 있는 하나의 lab 개발
 * 3. 내 짝꿍을 생각하는 마음
 */

package step01.syntax;

public class Step10MyArt {
	
	// 메소드 1
	public static String getResult(int value) {
		String retVal = "";
		
		if(value >= 90) {
			retVal = "컨디션이 매우 좋네요. 열공";
		}else if(value >=80) {
			retVal = "컨디션이 그럭저럭 좋습니다. 조금만 더 힘내세요";
		}else if(value>=70) {
			retVal = "당이 떨어지네요 사탕 한번 먹고 오세요";
		}else if(value>=60) {
			retVal = "수분이 부족합니다. 물 한번 마시고 오세요";
		}else if(value>=50) {
			retVal = "많이 피곤한가봐요. 바람 좀 쐬세요";
		}else {
			retVal = "컨디션이 매우 나쁩니다. 잠좀 자세요.";
		}	
		return retVal;
	}
		// 메소드 2
		
		public static void forTest2(){
			
			char money = '$';
			String money2 = "";
			for(int i=1; i<=10; i++) {
				for(int t=10; t >= i; t--  ) {
					money2 = money2 + money;	
				}
					System.out.println(money2);
					money2="";
			}
		}			
		public static void forTest3() {
			
		char money ='$';
		String money2 = "";
		for(int i=1; i<=10; i++) {
			money2 = money2 + money;
			System.out.println(money2);		
				}
	}
		
	public static void main(String[] args) {
		//내 컨디션 점수는? 0~100점
		System.out.println("당신의 점수로 보아하니," + getResult(70));
		System.out.println();
		
		//돈찍기
		System.out.println("돈 찍기");
		forTest2();
		forTest3();
	}
}