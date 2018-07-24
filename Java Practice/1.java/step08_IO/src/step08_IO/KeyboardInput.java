/*학습내용
 * 1. 실시간 키보드로 입력한 데이터를 실시간 콘솔창에 출력
 * 2. 구현 방법
 * 		키보드 입력(System.in) -> 엔터 -> 콘솔에 출력(System.out)
 * 		1) 실시간 : 반복문
 * 		2) read/write 메소드
 * 		3) 데이터 존재 여부 검증
 * 			- String 데이터 존재 여부 검증
 * 			- 비교 값은 null
 * 			- readLine() : Line 단위로 read
 * 3. IO의 실행 performance를 고려한 필터 API들 존재
 * 		1) 속도를 향상
 * 			BufferedReader / BufferedWriter (한줄씩)
 * 			시스템 실제 하드웨어 장비 버퍼 메모리 사용
 * 			사용 후에 코드로 자원 반환 필수
 * 		2) 옵션
 * 4. 절대적인 주의사항
 * 		- 출력 API는 반드시 자원 반환 전에 데이터를 메모리가 보유한 상태로 목적지에 출력을 안할 수도 있음
 * 		왜? 버퍼 메모리 크기만큼 데이터가 쓰여있지 않으면 버퍼 메모리에 데이터를 보유하고 있게 된다.
 * 		단, 버퍼 사이즈 만큼 데이터가 쓰여있다면 자동 출력(autoflush),
 * 		따라서 데이터 손실 방지를 위한 auto flush 기능의 메소드 코딩
 */

package step08_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class KeyboardInput {

	/*
	//step01 키보드로 읽어들인 데이터 콘솔 창에 출력
	public static void main(String[] args) {
		BufferedReader in //input 의미하는 변수를 in이라고 자주 써서 만들어줌
		= new BufferedReader(new InputStreamReader(System.in)); //키보드로 1byte로 받아들이는걸 2바이트 단위로 받아들이는 상황으로 만들어주는 것
		// BufferedReader 한 라인씩 불러옴
		try {
			String data = in.readLine();  //데이터 입출력은 항상 불안정해서 항상 try catch 처리(예외) 해줘야함
			while(data != null) { //조건문을 넣어야하지. 그리고 업데이트가 필요함(또 읽어야지)
				System.out.println(data); //콘솔창에 입력하고 엔터치면 돌아감
				data = in.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();  //사용했던 시스템 자원 반환. 근데 예외처리
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
*/
	
	/*//step02 : 키보드 -> data.txt 파일로 출력
	public static void main(String[] args) {
		
		//read 객체
		BufferedReader in
		= new BufferedReader(new InputStreamReader(System.in));
		
		//data.txt 파일에 2byte로 출력
		BufferedWriter out = null; //try 블록 밖에서 변수 선언
		
		try {
			out = new BufferedWriter(new FileWriter("data.txt")); //여기다가 해야함. out으로 선언하면 안돼? 자원반환이 안된다고 한다.
			//즉 close가 안된다고. 왜? 예외가 발생할 수 있다고 한다.
			
			String data = in.readLine();  //데이터 입출력은 항상 불안정해서 항상 try catch 처리(예외) 해줘야함
			while(data != null) { //조건문을 넣어야하지. 그리고 업데이트가 필요함(또 읽어야지)
				out.write(data);
				out.newLine(); //새로운 라인 추가(엔터키 반영). 그리고 마지막꺼 칠 때 엔터 2번 치기
				data = in.readLine();
				out.flush(); //데이터 손실 방지를 위해서 목적지에 데이터 출력 보장
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();  //사용했던 시스템 자원 반환. 근데 예외처리
				out.close(); //out에서 추가해야함
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	*/
	
	//step03 - File로 부터 read해서 출력

	//split 메소드를 이용해서, data에 있는 정보들을 나눠서 개수를 확인해봐라
	
	public static void main(String[] args) {
			
			//read 객체
			//BufferedReader in
			//= new BufferedReader(new FileReader("data.txt")); //data.txt에서 정보를 가져와야하는데, 문제는 예외처리 해야함. try블록으로
			
			BufferedReader in = null;
			BufferedWriter out = null;
						
			try {
				in = new BufferedReader(new FileReader("data.txt"));
				out = new BufferedWriter(new FileWriter("newData.txt")); //새로운 newdata.txt에 출력
				
				String data = in.readLine();  //데이터 입출력은 항상 불안정해서 항상 try catch 처리(예외) 해줘야함
				while(data != null) { //조건문을 넣어야하지. 그리고 업데이트가 필요함(또 읽어야지)
					out.write(data);
					out.newLine(); //새로운 라인 추가(엔터키 반영). 그리고 마지막꺼 칠 때 엔터 2번 치기
					
					System.out.println(data); //콘솔창 출력
					
					data = in.readLine();
					out.flush(); //데이터 손실 방지를 위해서 목적지에 데이터 출력 보장
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();  //사용했던 시스템 자원 반환. 근데 예외처리
					out.close(); //out에서 추가해야함
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
}
