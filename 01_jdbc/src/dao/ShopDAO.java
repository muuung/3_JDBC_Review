package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import vo.ShopMember;

public class ShopDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public ShopMember searchUser(String memberId) {
		// 변수 선언과 동시에 객체를 생성하는 것이 틀린 건 아니지만
		// ShopMember shopMember = new ShopMember()
		
		// 여기를 null로 두고
		ShopMember shopMember = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "kh_khj", "kh1234");
			
			String sql = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = '" + memberId + "'";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				// 여기서 객체를 생성해주는 이유는 불필요한 객체 생성을 줄여서 메모리를 효율적으로 사용하려고!
				shopMember = new ShopMember();
				
				shopMember.setMemberId(rs.getString("MEMBER_ID"));
				shopMember.setMemberPw(rs.getString("MEMBER_PW"));
				shopMember.setPhone(rs.getString("PHONE"));
				shopMember.setGender(rs.getString("GENDER").charAt(0));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				
				// conn.close()를 해주지 않으면
				// Connection이 계속 남아서 쌓이고 쌓이다가 DB에 접근할 수 없게 되어버림
				// DB가 멸망하지 않게 조심하자
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return shopMember;
	}
}