package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	// Connection 생성
	public static Connection getConnection() {
		// Connection  생성 -> 메소드 만들기 함수만듬 리턴타입, 이름고민하기
		Connection con = null; // db연동할때는  Connection필요 db연결객체
//		String driver = "oracle.jdbc.OracleDriver";
//		// oracle.jdbc.OracleDriver a; // 드라이버이름을 줬을때 오류가 나지 않아야 옳은 것이다.
//		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
//		String user ="SCOTT";  // madang, hr
//		String pw="TIGER";     // madang, hr
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("C://lib//dbinfo.txt"));
			
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pw = p.getProperty("pw");
			
			// 1. JDBC Driver 설치 : ojdbc6.jar을 classpath에추가해야함 classpath인식을 할 수 있도록 지정하는것 (ojdbc6을 빌드패쓰 라이브러리에 집어넣기)
			// 2. 드라이버 로딩 : 드라이버를 메모리에 올리는 작업			
			Class.forName(driver); 
			
			// 3. DB로 연결 Connection 생성
			con = DriverManager.getConnection(url, user, pw); //db연결객체가 정보받음
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver확인 필요");  // 드라이버인식못하거나 이름틀리면 오류남
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return con;
		
	}
	
	
	// 자원 반납 -> 메소드 만들기 함수만듬
	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close(); // 생성된순서의 반대로 자원반납한다. 
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
