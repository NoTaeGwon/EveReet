package EveReet.model.shop;

import java.util.ArrayList;
import java.sql.*;
import javax.sql.*;

import EveReet.model.shop.ShopDTO;

import javax.naming.*;

public class ShopDAO {
	// private final static String driverName = "org.mariadb.jdbc.Driver";
	// private final static String url =
	// "jdbc:mariadb://localhost:3307/ntg90_mall_db";
	// private final static String user = "root";
	// private final static String psw = "ntg0926";

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

	public ShopDAO() {
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

	// 주 키 b_id의 레코드를 반환해주는 메소드 - R
	public ShopDTO getShop(int prodnum) {
//			dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		String SQL = "select * from product where prodnum = ?";
		ShopDTO shop = new ShopDTO();

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, prodnum);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			shop.setProdnum(rs.getInt("prodnum"));
			shop.setName(rs.getString("name"));
			shop.setKind(rs.getString("kind"));
			shop.setBrand(rs.getString("brand"));
			shop.setPrice1(rs.getInt("price1"));
			shop.setPrice2(rs.getInt("price2"));
			shop.setPrice3(rs.getInt("price3"));
			shop.setContent(rs.getString("content"));
			shop.setImage(rs.getString("image"));
			shop.setDetail_image(rs.getString("detail_image"));
			shop.setThumb_image(rs.getString("thumb_image"));
			shop.setUseyn(rs.getString("useyn"));
			shop.setLike(rs.getInt("like"));
			shop.setRegdate(rs.getString("regdate"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return shop;
	}

	// 게시판의 모든 레코드를 반환 메서드 - R
	public ArrayList<ShopDTO> getShopList() {
		// dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		ArrayList<ShopDTO> list = new ArrayList<ShopDTO>();

		String SQL = "select * from product";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopDTO shop = new ShopDTO();
				shop.setProdnum(rs.getInt("prodnum"));
				shop.setName(rs.getString("name"));
				shop.setKind(rs.getString("kind"));
				shop.setBrand(rs.getString("brand"));
				shop.setPrice1(rs.getInt("price1"));
				shop.setPrice2(rs.getInt("price2"));
				shop.setPrice3(rs.getInt("price3"));
				shop.setContent(rs.getString("content"));
				shop.setImage(rs.getString("image"));
				shop.setUseyn(rs.getString("useyn"));
				shop.setLike(rs.getInt("like"));
				shop.setRegdate(rs.getString("regdate"));
				list.add(shop);
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
	public ArrayList<ShopDTO> getShopListForPage(ShopPageInfoVO bpiVO) {
//		dbConnect(); // DAO객체 생성시에 dbConnect() 실행		
		ArrayList<ShopDTO> list = new ArrayList<ShopDTO>();

		String SQL = "select * from product ORDER BY prodnum limit ?, ?";
		String SQL2 = "select count(*) from product";

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
			pstmt.setInt(2, bpiVO.getLimitCnt());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopDTO shop = new ShopDTO();
				shop.setProdnum(rs.getInt("prodnum"));
				shop.setName(rs.getString("name"));
				shop.setKind(rs.getString("kind"));
				shop.setBrand(rs.getString("brand"));
				shop.setPrice1(rs.getInt("price1"));
				shop.setPrice2(rs.getInt("price2"));
				shop.setPrice3(rs.getInt("price3"));
				shop.setContent(rs.getString("content"));
				shop.setImage(rs.getString("image"));
				shop.setDetail_image(rs.getString("detail_image"));
				shop.setUseyn(rs.getString("useyn"));
				shop.setLike(rs.getInt("like"));
				shop.setRegdate(rs.getString("regdate"));
				list.add(shop);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// category를 적으면 그에 맞는 코드를 반환해주는 메소드 - R 준비중!!!!!
	/*
	 * public ShopDTO getCode_categorycode(String code_categoryname) { String SQL =
	 * "select * from code_category where code_categoryname = ?"; ShopDTO beer = new
	 * ShopDTO();
	 * 
	 * try {
	 * 
	 * pstmt = con.prepareStatement(SQL); pstmt.setString(1, code_categoryname);
	 * ResultSet rs = pstmt.executeQuery(); rs.next();
	 * beer.setCode_categoryname(rs.getString("code_categoryname"));
	 * beer.setCode_categorycode(rs.getString("code_categorycode")); //
	 * System.out.println(rs.getString("code_categoryname")); //
	 * System.out.println(rs.getString("code_categorycode")); //
	 * System.out.println(beer.getCode_categorycode()); rs.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } finally { // disConnect(); } return
	 * beer; }
	 * 
	 * // country를 적으면 그에 맞는 코드를 반환해주는 메소드 - R public ShopDTO
	 * getCode_countrycode(String code_countryname) { String SQL =
	 * "select * from code_country where code_countryname = ?"; ShopDTO shop = new
	 * ShopDTO();
	 * 
	 * try { pstmt = con.prepareStatement(SQL); pstmt.setString(1,
	 * code_countryname); System.out.println(pstmt +
	 * "<---- getCode_countrycode SQL"); ResultSet rs = pstmt.executeQuery();
	 * rs.next(); beer.setCode_countryname(rs.getString("code_countryname"));
	 * beer.setCode_countrycode(rs.getString("code_countrycode")); rs.close(); }
	 * catch (SQLException e) { e.printStackTrace(); } finally { // disConnect(); }
	 * return shop; }
	 * 
	 * // 0000을 생성하는 메소드 public String getCode_lastName(String category, String
	 * country) { String maxCode = ""; String c = category + country; String code
	 * =""; String SQL =
	 * "select max(b_code) from beer where b_code like ? order by b_code desc";
	 * 
	 * try { pstmt = con.prepareStatement(SQL); pstmt.setString(1,"BE" + c + "%");
	 * ResultSet rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { maxCode = rs.getString(1); } String tem =
	 * maxCode.substring(10); int temp = Integer.parseInt(tem) + 1; code =
	 * maxCode.substring(0, 10) + String.valueOf(temp); System.out.println(code +
	 * "<-- code"); } catch (SQLException e) { e.printStackTrace(); } finally { //
	 * disConnect(); } return code; }
	 */

	// 게시물 등록 메소드 - C
	public boolean insertShop(ShopDTO shop) {
		boolean success = false;
//		dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		String sql = "insert into product(name, kind, brand, ";
		sql += "price1, price2, content, image, detail_image, thumb_image) ";
		sql += "values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, shop.getName());
			pstmt.setString(2, shop.getKind());
			pstmt.setString(3, shop.getBrand());
			pstmt.setInt(4, shop.getPrice1());
			pstmt.setInt(5, shop.getPrice2());
			pstmt.setString(6, shop.getContent());
			pstmt.setString(7, shop.getImage());
			pstmt.setString(8, shop.getDetail_image());
			pstmt.setString(9, shop.getThumb_image());
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
	public boolean updateShop(ShopDTO shop) {
		boolean success = false;
//		dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		String sql = "UPDATE product SET name = ?, kind = ?, brand = ?,  ";
		sql += "price1 = ?, price2 = ?, content = ?, image = ?, detail_image = ?, useyn = ? ";
		sql += "WHERE prodnum = ?";

		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 BeerVO 객체를 이용해 사용자가 수정한 값을 가져와 SQL문 완성
			pstmt.setString(1, shop.getName());
			pstmt.setString(2, shop.getKind());
			pstmt.setString(3, shop.getBrand());
			pstmt.setInt(4, shop.getPrice1());
			pstmt.setInt(5, shop.getPrice2());
			pstmt.setString(6, shop.getContent());
			pstmt.setString(7, shop.getImage());
			pstmt.setString(8, shop.getDetail_image());
			pstmt.setString(9, shop.getUseyn());
			pstmt.setInt(10, shop.getProdnum());

			System.out.println(pstmt + " <--- update sql");
			int rowUdt = pstmt.executeUpdate();
			// System.out.println(rowUdt);
			if (rowUdt == 1)
				success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		} finally {
			disConnect();
		}
		return success;
	}

	// 게시물 삭제를 위한 메서드 - D
	public boolean deleteShop(int prodnum) {
		boolean success = false;
//		dbConnect(); // DAO객체 생성시에 dbConnect() 실행
		String sql = "delete from product where prodnum = ?";
		try {
			pstmt = con.prepareStatement(sql);
			// 인자로 받은 주 키인 id 값을 이용해 삭제
			pstmt.setInt(1, prodnum);
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
	
	// 전체 상품을 보여주는 메서드 - AllProduct
	public ArrayList<ShopDTO> getAllShopList() {
		ArrayList<ShopDTO> list = new ArrayList<ShopDTO>();
		
		String SQL = "select * from product";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopDTO shop = new ShopDTO();
				shop.setProdnum(rs.getInt("prodnum"));
				shop.setName(rs.getString("name"));
				shop.setKind(rs.getString("kind"));
				shop.setBrand(rs.getString("brand"));
				shop.setPrice1(rs.getInt("price1"));
				shop.setPrice2(rs.getInt("price2"));
				shop.setPrice3(rs.getInt("price3"));
				shop.setContent(rs.getString("content"));
				shop.setImage(rs.getString("image"));
				shop.setDetail_image(rs.getString("detail_image"));
				shop.setThumb_image(rs.getString("thumb_image"));
				shop.setUseyn(rs.getString("useyn"));
				shop.setLike(rs.getInt("like"));
				shop.setRegdate(rs.getString("regdate"));
				list.add(shop);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public ShopDTO getProdnumDetail(ShopDTO shopDTO) {
		String SQL = "SELECT * FROM product WHERE prodnum=" + shopDTO.getProdnum();
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				shopDTO.setProdnum(rs.getInt("prodnum"));
				shopDTO.setName(rs.getString("name"));
				shopDTO.setKind(rs.getString("kind"));
				shopDTO.setBrand(rs.getString("brand"));
				shopDTO.setPrice1(rs.getInt("price1"));
				shopDTO.setPrice2(rs.getInt("price2"));
				shopDTO.setPrice3(rs.getInt("price3"));
				shopDTO.setContent(rs.getString("content"));
				shopDTO.setImage(rs.getString("image"));
				shopDTO.setDetail_image(rs.getString("detail_image"));
				shopDTO.setThumb_image(rs.getString("thumb_image"));
				shopDTO.setUseyn(rs.getString("useyn"));
				shopDTO.setLike(rs.getInt("like"));
				shopDTO.setRegdate(rs.getString("regdate"));
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return shopDTO;
		
		
		
	}



	/*
	 * // 게시판의 현재 페이지 레코드를 변환 메서드 - R4S 준비중!!!!! public ArrayList<ShopDTO>
	 * getShopListForOption(ShopPageInfoVO bpiVO, String kind) { // dbConnect();
	 * ArrayList<ShopDTO> list = new ArrayList<ShopDTO>(); String SQL, SQL2; if
	 * (kind == null) kind = "none"; if (kind.equals("에일")) { SQL =
	 * "select * from beer WHERE b_category = '라거' ORDER BY b_id limit ?, ?"; SQL2 =
	 * "select count(*) from beer WHERE b_category = '라거' ORDER BY b_id" ; } else if
	 * (kind.equals("에일")) { SQL =
	 * "select * from beer WHERE b_category = '에일' ORDER BY b_id limit ?, ?"; SQL2 =
	 * "select count(*) from beer WHERE b_category = '에일' ORDER BY b_id" ; } else {
	 * SQL = "select * from beer ORDER BY b_id limit ?, ?"; SQL2 =
	 * "select count(*) from beer"; } ResultSet rs;
	 * 
	 * try { pstmt = con.prepareStatement(SQL2);
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { bpiVO.setRecordCnt(rs.getInt(1)); } } catch (Exception e)
	 * { e.printStackTrace(); }
	 * 
	 * bpiVO.adjPageInfo(); try { pstmt = con.prepareStatement(SQL);
	 * 
	 * pstmt.setInt(1, bpiVO.getStartRecord()); pstmt.setInt(2,
	 * bpiVO.getLimitCnt());
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { ShopDTO beer = new ShopDTO();
	 * beer.setB_id(rs.getInt("b_id")); beer.setB_code(rs.getString("b_code"));
	 * beer.setB_category(rs.getString("b_category"));
	 * beer.setB_name(rs.getString("b_name"));
	 * beer.setB_country(rs.getString("b_country"));
	 * beer.setB_price(rs.getInt("b_price"));
	 * beer.setB_alcohol(rs.getString("b_alcohol"));
	 * beer.setB_content(rs.getString("b_content"));
	 * beer.setB_like(rs.getInt("b_like"));
	 * beer.setB_dislike(rs.getInt("b_dislike"));
	 * beer.setB_image(rs.getString("b_image")); list.add(beer); } rs.close(); }
	 * catch (SQLException e) { e.printStackTrace(); } finally { disConnect(); }
	 * return list; }
	 */

}
