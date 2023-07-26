<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="EveReet.model.shop.*" %>
<%@ page import="java.util.*" %>
<%@ include file="/globalData.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>EveReet - 상품자료조회(R_4_S)</title>
</head>
<body>
   <h1>EveReet - 상품자료조회(R_4_S)</h1>
   <hr>
 <%
   ShopDTO shop;
   ArrayList<ShopDTO> shopList;
   ShopPageInfoVO bpiVO;
   
   bpiVO = (ShopPageInfoVO)session.getAttribute("shopPageInfoVO");
   shopList = (ArrayList<ShopDTO>)request.getAttribute("shopList");
   
   int currentPageNo = bpiVO.getCurrentPageNo();
   String kind = request.getParameter("kind");
   if (kind == null) kind = "none";
 %>
 
<h2>현재 DISPLAY RECORDS NUMBER : <%= bpiVO.getLimitCnt() %></h2>
<h2>현재 조건 : <%= kind%></h2>
<hr>
   <form method="post" action="./BeerController.be">
      <p>맥주 종류별 조회 : 
         <select name="kind">
            <option SELECTED disabled value=''>조건조회</option>
            <option value="1">상의</option>
            <option value="2">하의</option>
            <option value="3">아우터</option>
         </select>
         <input type="hidden" name="actionType" value="R4S">
         <input type="submit" value="확인">
      </p>
   </form>
<br>
      <table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>종류</th>
				<th>브랜드</th>
				<th>원가</th>
				<th>판매가</th>
				<th>이익</th>
				<th>상품 설명</th>
				<th>사진</th>
				<th>판매 유무</th>
				<th>좋아요</th>
				<ht>등록일</th>
			</tr>
		</thead>		
		<tbody>
		
<%
for(int i=0; i < shopList.size(); i++) {
	shop = shopList.get(i);
%>		
		<tr>
			<td><%=shop.getProdnum() %></td>
			<td><%=shop.getName() %></td>
			<td><%=shop.getKind() %></td>
			<td><%=shop.getBrand() %></td>
			<td><%=shop.getPrice1() %></td>
			<td><%=shop.getPrice2() %></td>
			<td><%=shop.getPrice3() %></td>
			<td><%=shop.getContent() %></td>
			<td><%=shop.getImage() %></td>
			<td><%=shop.getUseyn() %></td>
			<td><%=shop.getLike() %></td>
			<td><%=shop.getRegdate() %></td>
		</tr>
<%} %>
      </tbody>
   </table>
<a href="./BeerController.be?actionType=R4S&currentPageNo=0&kind<%=kind %>">[FIRST]</a>
   <%
      if ( currentPageNo > 0){
   %>
   <a href="./BeerController.be?actionType=R4S&currentPageNo=<%= currentPageNo - 1 %>&kind<%=kind %>">[PRE]</a>
   <%
      }else{
   %>
      [PRE]
   <%
      }

      for(int i=bpiVO.getStartPageNo(); i<bpiVO.getEndPageNo(); i++){
         if(i== currentPageNo){
   %>
         [<%=(i+1)%>]
   <%
         }else {
   %>
         <a href="./BeerController.be?actionType=R4S&currentPageNo=<%= i %>&kind<%=kind %>">[<%=i+1%>]</a>
   <%      
      }}
   %>   
   <%
      if(currentPageNo < bpiVO.getPageCnt()-1){
   %>
      <a href="./BeerController.be?actionType=R4S&currentPageNo=<%= currentPageNo + 1 %>&kind<%=kind %>">[NXT]</a>
   <%
      }else{
   %>
      [NXT]
   <%
      }
   %>
<a href="./BeerController.be?actionType=R4S&currentPageNo=<%=(bpiVO.getPageCnt()-1)%>&kind<%=kind %>">[END]</a>

<br><a href="<%= rootDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>