package EveReet.model.admin;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class AdminDAO {
	private PreparedStatement pstmt = null;
	private Connection con = null;

	Context init = null; // 컨텍스트 객체 변수
	DataSource ds = null;

	ResultSet rs = null; // 쿼리결과 셋 객체 변수

	public AdminDAO() {
		super();
		dbConnect();
	}

	public void dbConnect() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc_mariadbEv");
			con = ds.getConnection();

			System.out.println("DB연결 성공!!");
		} catch (Exception e) {
			System.out.println("DB연결 실패!!");
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결 해제 메소드
	public void disConnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 쿼리결과 셋 객체 해제 부분 추가
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// admin 로그인
	public AdminDTO login(AdminDTO admin) {
		String sql = "SELECT * FROM employee WHERE id = ? AND pwd = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getId());
			pstmt.setString(2, admin.getPwd());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				admin.setName(rs.getString("name"));
				admin.setEmail(rs.getString("email"));
				admin.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return admin;
	}
}
