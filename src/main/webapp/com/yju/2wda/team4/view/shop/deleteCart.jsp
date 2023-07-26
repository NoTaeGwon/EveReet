<%@page import="EveReet.model.shop.ShopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

String id = request.getParameter("cartId");
if(id==null || id.trim().equals("")){ // 카트가 없는데 비울려고 할 때
	response.sendRedirect("/EveReet/com/yju/2wda/team4/view/shop/shop_cart.jsp");
	return;
}
// 장바구니에 등록된 모든 상품을 삭제
if (id.equals("0")) {
	session.setAttribute("cartList", null);
} else {
	ArrayList<ShopDTO> cartList = (ArrayList<ShopDTO>)session.getAttribute("cartList");
	cartList.remove(Integer.parseInt(id));
}

// cart.jsp로 되돌아가기
response.sendRedirect("/EveReet/com/yju/2wda/team4/view/shop/shop_cart.jsp");

%>