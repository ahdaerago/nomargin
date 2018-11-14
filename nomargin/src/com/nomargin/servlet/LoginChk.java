package com.nomargin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nomargin.dao.MemberDAO;
import com.nomargin.dto.MemberDTO;

/**
 * Servlet implementation class LoginChk
 */
@WebServlet("/LoginChk")
public class LoginChk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginChk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET!!!!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST!!!!!????");
		//9. View 단에 사원 목록 출력
		response.setContentType("text/html; charset=UTF-8"); // 안 써주면 한글 깨짐
		ArrayList<MemberDTO> list= new ArrayList<>();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDTO mDto = new MemberDTO();
		MemberDAO mDao = new MemberDAO();
		String msg = "";
		System.out.println("id"+id);
		list = mDao.loginChk(id);
		
		if(list.size() == 0) {
			msg = "회원 ID가 일치하지 않습니다.";
		}else {
			list = mDao.loginChk(id,pw);
			System.out.println(list.size());
			if(list.size() == 0) {
				msg = "비밀번호가 일치하지 않습니다.";
			}else {
				msg = id+"님 환영합니다.";
			}
			
		}
		PrintWriter writer = response.getWriter();
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<span>"+msg);
		writer.print("</span>");
	
		writer.print("</body>");
		writer.print("</html>");
		writer.close();
	}

}
