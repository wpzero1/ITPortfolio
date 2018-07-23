/*학습내용
 * 1. 조건식
 * 2. 문법
 * 		1) 조건 상황이 하나인 경우
 * 			if(조건식){} 			1번 선언
 * 		2) 조건 상황이 다수인 경우
 * 			if(조건식){ 			1번 선언
 * 				}else if(조건식2){		0~*번 선언 가능
 * 					}else{} <- 어떤 조건도 해당 안되는 경우. 이경우는 소괄호 없음			1번 선언
 * 		3) 조건 상황들이 아닌 경우도 고려해야하는 경우
 * 			if(){}else{}
 * 
 * 
 * 참고.
 * if(조건식){}
 * if(조건식){}
 * if(조건식){}
 *  각각의 if가 독립적임
 *  
 *   if(조건식){
 *    }else if(조건식2){}
 *    }else if(조건식2){}
 *    }else if(조건식2){}
 *    ...
 *    
 *    if조건식이 true라면 else if 부분은 모두 넘어가게됨
 */

package step01.syntax;

public class Step09If {
	public static char getGrade(int value) {
		char retVal = 'A'; //기본값 (returnValue라는 의미로 변수값 지정함.), char는 ' ' 로 처리
		if(value >= 90) { //로컬변수는 자기가 근접한 {} 내에서만 작동한다. 따라서 위 char retVal문장은 위에서 선언해줘야함.
			retVal = 'A';
		}else if(value >=80) {
			retVal = 'B';
		}else if(value>=70) {
			retVal = 'C';
			
		}else {
			retVal = 'F';
			
		}
		return retVal;
		
	}

		public static char getGrade2(String value) {
			char retVal = 'A'; //기본값 (returnValue라는 의미로 변수값 지정함.), char는 ' ' 로 처리
			int value2 = Integer.parseInt(value); //string 값을 int 값으로 받아주는 것.
			
			
			if(value2 >= 90) { //로컬변수는 자기가 근접한 {} 내에서만 작동한다. 따라서 위 char retVal문장은 위에서 선언해줘야함.
				retVal = 'A';
			}else if(value2 >=80) {
				retVal = 'B';
			}else if(value2>=70) {
				retVal = 'C';
				
			}else {
				retVal = 'F';
				
			}
			return retVal;
		}
		
	public static void main(String[] args) {
		System.out.println(getGrade(91));
		System.out.println(getGrade(50));
		System.out.println(getGrade2("91"));
		System.out.println(getGrade2("50"));
		
	}

}
