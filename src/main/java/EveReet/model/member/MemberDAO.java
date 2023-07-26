package EveReet.model.member;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class MemberDAO {
	//private final static String driverName = "org.mariadb.jdbc.Driver";
	//private final static String url = "jdbc:mariadb://localhost:3307/ntg90_mall_db";
	//private final static String user = "root";
	//private final static String psw = "ntg0926";
	
	private PreparedStatement pstmt = null;
	private Connection con = null;
	
	Context init = null; // 컨텍스트 객체 변수
	DataSource ds = null;
	
	ResultSet rs = null; // 쿼리결과 셋 객체 변수
	
	// JDBC 드라이버 로드 메소드
//	public void jdbcDriverLoad() {
//		try {
//			Class.forName(driverName);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	// 데이터베이스 연결 메소드
//	public void dbConnect() {
//		try {
//			con = DriverManager.getConnection(url, user, psw);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public MemberDAO() {
		super();
		dbConnect();
	}
	
	public void dbConnect() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc_mariadbEv");
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
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
/*	// db에 있는 code 불러옴
	public ArrayList<MemberDTO> getCdoeList() {
		// dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		String SQL = "select * from code_category";
		String SQL2 = "select count(*) from code_country";
				
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ShopDTO shop = new ShopDTO();
				shop.setCode_categoryname(rs.getString("code_categoryname"));
				shop.setCode_categorycode(rs.getString("code_categorycode"));
				shop.setCode_countryname(rs.getString("code_countryname"));
				shop.setCode_countrycode(rs.getString("code_countrycode"));
				
				list.add(shop);
			} 
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		} 
		return list; 
	} */
	
	// 주 키 id의 레코드를 반환해주는 메소드 - R
		public MemberDTO getMember(String id) {
//			dbConnect(); // DAO객체 생성시에 dbConnect() 실행
			String SQL = "select * from users where id = ?";
			MemberDTO member = new MemberDTO();
			
			try {
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZip_code(rs.getString("zip_code"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setUseyn(rs.getInt("useyn"));
				member.setRegdate(rs.getString("regdate"));
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			} 
			return member;
		}
	
	// 게시판의 모든 레코드를 반환 메서드 - R
	public ArrayList<MemberDTO> getMemberList() {
		// dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		String SQL = "select * from users";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZip_code(rs.getString("zip_code"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setUseyn(rs.getInt("useyn"));
				member.setRegdate(rs.getString("regdate"));
				list.add(member);
			} 
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		} 
		return list;
	}
	
	// 게시판의 현재 페이지 레코드를 변환 메서드 - R4
	public ArrayList<MemberDTO> getMemberListForPage(MemberPageInfoVO bpiVO) {
//		dbConnect(); // DAO객체 생성시에 dbConnect() 실행		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		String SQL = "select * from users ORDER BY id limit ?, ?";
		String SQL2 = "select count(*) from users";
		
		ResultSet rs;
		
		try {
			pstmt = con.prepareStatement(SQL2);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bpiVO.setRecordCnt(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bpiVO.adjPageInfo();
		
		try {
			pstmt = con.prepareStatement(SQL);
			
			pstmt.setInt(1, bpiVO.getStartRecord());
			pstmt.setInt(2,  bpiVO.getLimitCnt());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZip_code(rs.getString("zip_code"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setUseyn(rs.getInt("useyn"));
				member.setRegdate(rs.getString("regdate"));
				list.add(member);
			} rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return list;
	}
	
	// category를 적으면 그에 맞는 코드를 반환해주는 메소드 - R 준비중!!!!!
/*	public ShopDTO getCode_categorycode(String code_categoryname) {
		String SQL = "select * from code_category where code_categoryname = ?";
		ShopDTO beer = new ShopDTO();
		
		try {
			
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, code_categoryname);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			beer.setCode_categoryname(rs.getString("code_categoryname"));
			beer.setCode_categorycode(rs.getString("code_categorycode"));
//			System.out.println(rs.getString("code_categoryname"));
//			System.out.println(rs.getString("code_categorycode"));
//			System.out.println(beer.getCode_categorycode());
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// disConnect();
		} 
		return beer;
	}
	
	// country를 적으면 그에 맞는 코드를 반환해주는 메소드 - R
	public ShopDTO getCode_countrycode(String code_countryname) {
		String SQL = "select * from code_country where code_countryname = ?";
		ShopDTO shop = new ShopDTO();
			
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, code_countryname);
			System.out.println(pstmt + "<---- getCode_countrycode SQL");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			beer.setCode_countryname(rs.getString("code_countryname"));
			beer.setCode_countrycode(rs.getString("code_countrycode"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// disConnect();
		} 
		return shop;
	}
	
	// 0000을 생성하는 메소드
	public String getCode_lastName(String category, String country) {
		String maxCode = "";
		String c = category + country;
		String code ="";
		String SQL = "select max(b_code) from beer where b_code like ? order by b_code desc";
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,"BE" + c + "%");
			ResultSet rs = pstmt.executeQuery();
	         
	        while (rs.next()) {
	           maxCode = rs.getString(1);
	        }
	        String tem = maxCode.substring(10);
	        int temp = Integer.parseInt(tem) + 1;
	        code = maxCode.substring(0, 10) + String.valueOf(temp);
	        System.out.println(code + "<-- code");
	     } catch (SQLException e) {
	        e.printStackTrace();
	     } finally {
//	        disConnect();
	     }
	     return code;
	   } */
	
	
	// 회원 등록 메소드 - C
	public boolean insertMember(MemberDTO member) {
		boolean success = false;
//		dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		String sql = "insert into users(id, pwd, name, ";
				sql += "email, zip_code, address, phone) ";
				sql += "values(?, ?, ?, ?, ?, ?, ?) ";
		try {
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getZip_code());
			pstmt.setString(6, member.getAddress());
			pstmt.setString(7, member.getPhone());
			System.out.println(pstmt + "<--pstmt");
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	// 데이터 갱신을 위한 메서드 - U
	public boolean updateMember(MemberDTO member) {
		boolean success = false;
//		dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		String sql = "UPDATE users SET pwd = ?, name = ?, email = ?,  ";
				sql += "zip_code = ?, address = ?, phone = ?, useyn = ? ";
				sql += "WHERE id = ?";
				
		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 BeerVO 객체를 이용해 사용자가 수정한 값을 가져와 SQL문 완성
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getZip_code());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getPhone());
			pstmt.setInt(7, member.getUseyn());
			pstmt.setString(8, member.getId());
			System.out.println(pstmt + "<-- pstmt update");
			int rowUdt = pstmt.executeUpdate();
			// System.out.println(rowUdt);
			if (rowUdt == 1) success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}
	
	// 게시물 삭제를 위한 메서드 - D
	public boolean deleteMember(String id) {
		boolean success = false;
//		dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		String sql = "delete from users where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 주 키인 id 값을 이용해 삭제
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}	
		return success;
	}
	
	// member 로그인
	public MemberDTO login(MemberDTO member) {
		String sql = "SELECT * FROM users WHERE id = ? AND pwd = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZip_code(rs.getString("zip_code"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setUseyn(rs.getInt("useyn"));
				member.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}	
		return member;
	}
	

/*	   // 게시판의 현재 페이지 레코드를 변환 메서드 - R4S 준비중!!!!!
	      public ArrayList<ShopDTO> getShopListForOption(ShopPageInfoVO bpiVO, String kind) {
//	         dbConnect();
	         ArrayList<ShopDTO> list = new ArrayList<ShopDTO>();
	         String SQL, SQL2;
	         if (kind == null) kind = "none";
	         if (kind.equals("에일")) {
	            SQL = "select * from beer WHERE b_category = '라거' ORDER BY b_id limit ?, ?";
	            SQL2 = "select count(*) from beer WHERE b_category = '라거' ORDER BY b_id" ;
	         } else if (kind.equals("에일")) {
	            SQL = "select * from beer WHERE b_category = '에일' ORDER BY b_id limit ?, ?";
	            SQL2 = "select count(*) from beer WHERE b_category = '에일' ORDER BY b_id" ;
	         } else {
	            SQL = "select * from beer ORDER BY b_id limit ?, ?";
	            SQL2 = "select count(*) from beer";
	         }
	         ResultSet rs;
	         
	         try {
	            pstmt = con.prepareStatement(SQL2);
	            
	            rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	               bpiVO.setRecordCnt(rs.getInt(1));
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         
	         bpiVO.adjPageInfo();
	         try {
	            pstmt = con.prepareStatement(SQL);
	            
	            pstmt.setInt(1, bpiVO.getStartRecord());
	            pstmt.setInt(2,  bpiVO.getLimitCnt());
	            
	            rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	            	ShopDTO beer = new ShopDTO();
	               beer.setB_id(rs.getInt("b_id"));
	               beer.setB_code(rs.getString("b_code"));
	               beer.setB_category(rs.getString("b_category"));
	               beer.setB_name(rs.getString("b_name"));
	               beer.setB_country(rs.getString("b_country"));
	               beer.setB_price(rs.getInt("b_price"));
	               beer.setB_alcohol(rs.getString("b_alcohol"));
	               beer.setB_content(rs.getString("b_content"));
	               beer.setB_like(rs.getInt("b_like"));
	               beer.setB_dislike(rs.getInt("b_dislike"));
	               beer.setB_image(rs.getString("b_image"));
	               list.add(beer);
	            } rs.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         finally {
	            disConnect();
	         }
	         return list;
	      }
	*/   


}
