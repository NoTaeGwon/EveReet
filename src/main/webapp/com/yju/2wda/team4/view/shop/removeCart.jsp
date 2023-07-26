<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@	page import="EveReet.model.shop.ShopDTO"%>
<%@ page import="EveReet.model.shop.ShopDAO"%>
<%

	//삭제할 상품 id
	int id = Integer.parseInt(request.getParameter("cartId")) ; 
	
	// 상품 데이터 접근 클래스의 인스턴스 생성
	
	
	// 해당 id 값을 이용해서 상품상세정보를 얻어오는 코드
	ShopDTO shopDTO = new ShopDAO().getShop(id);
	
	ArrayList<ShopDTO> cartList = (ArrayList<ShopDTO>)session.getAttribute("cartList");
	ShopDTO tmpDto = new ShopDTO();
	for(int i = 0; i< cartList.size(); i++) {
		shopDTO = cartList.get(i);
		if(tmpDto.getProdnum() == id) {
			cartList.remove(shopDTO);
		}
	}
	
	response.sendRedirect("/EveReet/com/yju/2wda/team4/view/shop/shop_cart.jsp");
%>