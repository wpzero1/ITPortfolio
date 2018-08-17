package step01.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/succ")
public class SuccessView extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			/*client 시스템에 저장된 쿠키 객체 획득 및 출력
			 * 쿠키 객체 획득 메소드
			 * 1. 요청 객체
			 * 		Cookie[] get Cookies()
			 * 2. Cookie 객체가 제공
			 * 		String getName() - key 반환 (별칭부터 뽑고 비교)
			 * 		String getValue() - value 반환
			 * 
			 */
			Cookie [] all = request.getCookies(); //쿠키 배열 다 가져옴
			for(int i=0; i < all.length; i++) { //인덱스가 필요함. 다 돌려야해
				if(all[i].getName().equals("data1")) { //쿠키 얻은 값들 중에서 name을 뽑은 것과 data1과 비교함
					System.out.println(all[i].getValue()); //비교한 값 중에 참인 것은 value값을 출력
				}
			}
			out.println("유효~~~<br>");
			out.println(request.getAttribute("newData"));
	
	}

}
