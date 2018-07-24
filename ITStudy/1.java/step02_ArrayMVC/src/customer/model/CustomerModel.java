/* test 데이터 표현, DTO 객체들 저장, 수정, 삭제, 검색 (모든 검색인지, id로 검색인지 등등) 의 핵심 로직을 보유
 * 지금은 배열을 써야한다(리사이징 불가한)
 *  1. 각 기능은 개별 메소드로 구현
 *  2. 개별 메소드에서 하나의 데이터를 공유 (따라서 로컬변수를 멤버변수로 선언해줘야 중괄호 밖 동일 클래스에서 사용가능)
 *  3. 데이터를 배열 활용 : DTO 객체들 CRUD
 */

package customer.model;

import customer.domain.CustomerDTO;

public class CustomerModel {
	//5개의 메모리가 있는 배열 생성 (index 0~4, length 변수)
	static CustomerDTO[] all = new CustomerDTO[5];
	//all은 일반 인스턴스 변수. 객체 만들어야 쓸 수 있음 (그래서 static을 여기서도 넣음)
	//DB가 없기 때문에 byte code가 메모리에 로딩될 때 무조건 자동실행되는 블록
	// 임시 test 데이터 초기화에 적합
	static {
		all[0] = new CustomerDTO("tester", "이상록", "11", 26, "vip");
		all[1] = new CustomerDTO("ldh", "이동훈", "55", 27, "vip");
		all[2] = new CustomerDTO("admin", "박창윤", "22", 28, "vvip");
		all[3] = new CustomerDTO("master", "김경남", "33", 28, "vvip");

	}
	//조건없이 모든 검색
	public static CustomerDTO[] getAll() {
		return all;
	}

		
	//삭제
	/* id로 해당 고객 삭제하기(배열의 해당 index에 null 대입)
	 * 1. 필요한 데이터 : id
	 * 2. 반환 타입 : boolean 
	 * 
	 */
	
	public static boolean deleteOne(String id) { //신입이 아닌 경력자 티가 나는 코드다
		for(int i=0; i<all.length;i++) {
			if(all[i] != null && all[i].getId().equals(id)) { // [i]는 배열, all[i]는 DTO, all[i].getId()까지는 문자열
				all[i] = null;
				return true;
			}
		}
		return false;
	}
	
	
	//수정
	
	public static boolean updateOne(String id) { //string은 ==이 아니라 equals로 비교해야함
		//변수를 2개 지정해서 할 수도 있다. (String id, String grade)
		int index = -1; //값 없음을 의미
		CustomerDTO one = null; //초기화
		
		for(int i=0; i<all.length; i++) {
			one = all[i]; //계속 써주기 힘들어서 변수를 지정했다.
			if(one != null && one.getId().equals(id)) { 
				index = i; 
				one.setGrade("vvvip");
				return true;	
			}
		}
		return false;
	}
		
	//가입
	/* [1] 구현 관점에만
	 * 1. 경우의 수 1 - 마지막 배열 영역에 단순 저장 (all[4] = DTO 객체 변수
	 * 2. 경우의 수 2 - null일 수도 있는 즉 delete로 삭제한 메모리 영역에 있다면 해당 index에 저장 (루핑 돌려서 null인게 입증되면 대입)
	 *
	 * [2] 호출 관점
	 * 1. null이 존재할 경우 해당 위치에 새로운 CustomerDTO 저장
	 * 2. null이 없네? 이 경우 호출하는 쪽은 상황을 모른다.
	 *   - 반환 값이 5 (배열의 전체 크기)인 경우 데이터 저장 실패
	 *   - 반환 값이 5가 아닌 경우 데이터 저장 성공
	 */
	
	public static int addOne(CustomerDTO one) { //파라메터는 포괄적으로 정보를 포함하는 DTO여야한다.
		int index = all.length; //5, 0~4 -> 이걸 하는 이유는, 엔드유저인 사용자가 데이터가 제대로 들어갔는지 아닌지를 확인하기 위함
		
		for(int i=0; i<all.length; i++) {
			if(all[i] == null) { // ==은 값 비교하는 것. null이라면, 그 i 배열에 저장.
				all[i] = one; //CustomerDTO에 저장됨
				index = i; // 5인 index 변수값을 저장시킨 배열의 index 값으로 대입
				break;	//비어있는 인덱스가 있었다면 거기에 정보가 채워지고 break되고 밑에 return으로 감.
			}
		}
		return index; //5 또는 저장된 배열의 index 값이 반환
	}
	

	/* id 값으로 해당 고객의 모든 정보 반환
	 * 1. parameter - String id
	 * 2. 반환타입 - CustomerDTO
	 * 
	 * 값비교시 필요한 API - equals()
	 * 비교 - 조건식
	 * 배열에는 여러개의 DTO 객체들 - 반복
	 * 
	 * 데이터가 존재하면 해당 DTO 객체 반환
	 * 해당 데이터가 미 존재시, null 반환
	 */
	
	public static CustomerDTO getOne(String id) {
		CustomerDTO dto = null; //dto를 반환하려면 이게 필요하고, null값으로 초기화시켜야함.
		for(int i=0; i < all.length; i++) {
				dto = all[i];
				System.out.println(i); //i 값이 어떻게 흘러가는지 확인해보려고 넣었음.
				if(dto != null && dto.getId().equals(id)) { //앞쪽은 배열안의 id, 뒤는 getOne에서 얻은 id. 이 두개 값을 비교한다.
					//dto != null 이게 null 값인지 검증을 해야함  && : and 연산자 
					//여기서 문제는, tester2 (즉 없는 데이터)를 넣는다면 값은 마지막 값이 나오는데, null 값이 나오게 어떻게 할까
					break; //반복문 종료하는 제어문장
				} else {
					dto = null;
				}		
			}
	
		return dto;
		// return null;
	}
	


public static void main(String [] args) {
	 System.out.println(getOne("tester3"));  //값이 존재하지 않는 것 프린트. null이 나와야한다.
	
  }

}
