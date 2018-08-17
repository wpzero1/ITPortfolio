package step01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fail")
public class FailView extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글로 무효합니다 출력
		//한글 인코딩, 응답 포맷 설정
		response.setContentType("text/html;charset=utf-8");
		//출력
	PrintWriter out = response.getWriter(); //new로 하면 서버 콘솔창, response로 받으면 브라우저 상에 나온다
	out.println("무효");
	out.println(request.getAttribute("newData"));
	}

}
