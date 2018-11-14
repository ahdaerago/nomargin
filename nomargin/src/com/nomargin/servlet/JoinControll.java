package com.nomargin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nomargin.dao.MemberDAO;
import com.nomargin.dto.MemberDTO;

/**
 * Servlet implementation class JoinControll
 */
@WebServlet("/JoinControll")
public class JoinControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
 		
		System.out.println("GET!!!!!!!");
		String id = "toy1853";
		String pw = "1234";
		String name = "장소희";
		String nick = "잉여킹";
		String addr = "광주광역시";
		String email = "toy1853@naver.com";
		String birth = "19951216";
		int result = 0;
		MemberDTO mDto = new MemberDTO(id, pw, name, nick, addr, email, birth);
		MemberDAO mDao = new MemberDAO();
		result = mDao.insertMember(mDto);
		if(result == 0) {
			System.out.println("등록 실패");
		}else {
			System.out.println("등록 성공");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
