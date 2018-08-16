package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Step01 extends HttpServlet {
    public Step01() {
    	System.out.println("생성자");
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()"); //쌤 ip로 접속했더니, 접속한 수만큼 doGet() 메시지가 나오더라. 근데 호출하는 곳이없는데, 어디서하지?
		//Httprequest, response 이거는 tomcat이 만들어주는 것.
		
		
		//브라우저에 한글 출력
		
		//한글 인코딩 설정
		response.setContentType("text/html;charset=utf-8"); //응답 내용물, 형태 설정
		//2byte 단위로 출력 가능한 객체 생성
		PrintWriter out = response.getWriter();
		//브라우저에 출력
		out.println("<b>서영상</b>"); //태그 사용 가능
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
	}

}
