package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSuccessView extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 출력을 위한 응답 객체의 속성 추가
		 * 세션 객체 획득
		 * 이름 데이터를 세션으로부터 획득 -> 사용
		 * 버튼
		 * 
		 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		out.println(session.getAttribute("name"));
		out.println("<br>");
		out.println("<button onclick='location.href=\"cont?command=logout\"'>로그아웃</button>");
		//cont에 매핑되어있는, command logout으로 재요청.  html 문법이라 어렵다... " " 안에 ' ' 따옴표가 들어가고, 이 안에 " "를 또 쓰려면 \" \" 이런식으로 쓴다.
		//"cont?command=logout\" 이건 location.href의 값인데 따옴표 처리 해줘야한다고....
	}

}
//<button onclick='cont?command=logout'>로그아웃</button>  쌍따옴표, 따옴표 조심. 따옴표 안에 또 따옴표라서 이렇게 씀
