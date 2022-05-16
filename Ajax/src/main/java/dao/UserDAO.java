package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	
	
	//conn 객체 생성
	
	private Connection conn;
	
	//구문객체 생성
	private PreparedStatement pstmt;
	//결과 담을 ResultSet
	private ResultSet rs;
	
	
	
	//생성자 생성
	
	public UserDAO() {
		//매핑된 
	try {
		
		//접속 db정보 변수에 담아놓기
		String dbURL="jdbc:mysql://localhost:3306/testDB";
		String dbID= "java";//연습용이라 간단하게 지음
		String dbPassword = "java";
		Class.forName("com.mysql.jdbc.Driver");//드라이버 검색
	}catch (Exception e) {
		System.out.println(e);
		
	}
	
	
	
	
}
	
}
