package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import vo.User;

@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		response.getWriter().write(getJSON(userName));
		
	}
	public String getJSON(String userName) { //요청받은 유저이름 json 으로
		if(userName == null) userName = "";
		StringBuffer result = new StringBuffer("");//string 으로 하면 계속 생성되서 비효율적
		result.append("{\"resuelt\":["); // 결과에 문자열 붙이기
		UserDAO userDAO = new UserDAO();
		ArrayList<User> userList = userDAO.search(userName);//DB에서 뽑아온 데이터를 담고있는 객체
		

		// JSON 값이 여러개이기때문에 for 문 
		 for(int i = 0;i<userList.size(); i++) {
			 result.append("[{\"value \": \""+userList.get(i).getUserName()+"\"},");//문자열 더하기
			 result.append("{\"value \": \""+userList.get(i).getUserAge()+"\"},");//문자열 더하기
			 result.append("{\"value \": \""+userList.get(i).getUserGender()+"\"},");//문자열 더하기
			 result.append("{\"value \": \""+userList.get(i).getUserEmail()+"\"}],");//문자열 더하기	 	 
		 }
		result.append("]}");

		return  result.toString();
	}
	
	
	
}
