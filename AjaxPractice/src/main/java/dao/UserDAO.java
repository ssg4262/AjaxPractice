package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.User;

public class UserDAO {
	
	
	
	//conn 객체 생성
	
	private Connection conn;
	
	//구문객체 생성
	private PreparedStatement pstmt;
	//결과 담을 ResultSet
	private ResultSet rs;
	
	
	
	//생성자 생성
	
	public  UserDAO() {
		//매핑된 
	try {
		
		//접속 db정보 변수에 담아놓기
		String dbURL="jdbc:mysql://localhost:3306/testdb";
		String dbID= "java";//연습용이라 간단하게 지음
		String dbPassword = "java";
		Class.forName("com.mysql.jdbc.Driver");//드라이버 검색
		conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
		
		
	}catch (Exception e) {
		System.out.println(e);
		
	}
	}
	
	//서비스로직을 생성할수 있으나 시간상 ajax json 데이터만 뽑아올거기 때문에 
	public ArrayList <User> search(String userName){
		String sql= "SELECT * FROM user WHERE userName Like ?";
		ArrayList<User> userList = new ArrayList<User>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+userName+"%");
			rs = pstmt.executeQuery();
			// 여러개이기때문에 while
			
			while (rs.next()) {
				//결과값 dto  생성자에 담기
			 User user = new User();
			 user.setUserName(rs.getString(1));
			 user.setUserAge(rs.getInt(2));
			 user.setUserGender(rs.getString(3));
			 user.setUserEmail(rs.getString(4));
			 userList.add(user);//user List  에 담기
			}
			for(int i=0; i<userList.size();i++) {
				System.out.println("dao="+userList.get(i).getUserName());
			}
			
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return userList; //결과값 반환호
	}
	
	
	
	
}
	

