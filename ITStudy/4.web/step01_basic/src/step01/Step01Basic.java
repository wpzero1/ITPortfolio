package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Step01Basic extends HttpServlet {
	//재정의 - get방식 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		process(request, response);
	}
	//재정의 - post방식 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		process(request, response);
	
	}
	
	//사용자 정의 - process
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩 설정
		response.setContentType("text/html;charset=utf-8");
		//2byte 출력 가능한 객체 생성
		PrintWriter out = response.getWriter();
		
		//client가 html form에 입력한 데이터를 획득 - id/pw
		//<input type="text" name="id" placeholder="id입력">
		String id = request.getParameter("id");
		
		//<input type="password" name="pw" placeholder="pw입력">
		String pw = request.getParameter("pw");
		System.out.println(id + " " + pw);
		
		//비교 로직
		if(id !=null && id.equals("master")) {
		//출력 - 글자색 파란색
		out.println("<font color='blue'>안녕하세요 master님</font>");
	} else {
		out.println("<font color='red'>너 누구야? <br> 돈받으러 왔는데 모 그런거까지 알아야되니?</font>");
	}
	}
}
