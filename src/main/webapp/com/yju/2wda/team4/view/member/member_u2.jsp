<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="EveReet.model.member.*" %>
<%@ page import="java.util.*" %>
<%@ include file="/globalData.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EveReet - 회원정보수정(U2)</title>
</head>
<body>

<h1>EveReet - 회원정보수정(U2)</h1>
<hr>
<%
	MemberDTO member = (MemberDTO)request.getAttribute("member");
%>

<form method="post" action="./updateMemberForID.me">
	<br>ID : <input type="text" name="id" value="<%=member.getId()%>" readonly>
	<br>PASSWORD : <input type="text" name="pwd" value="<%=member.getPwd()%>" size="30">
	<br>이름 : <input type="text" name="name" value="<%=member.getName()%>" size="30">
	<br>E-mail: <input type="text" name="email" value="<%=member.getEmail()%>" size="30">
	<br>우편번호 : <input type="text" name="zip_code" value="<%=member.getZip_code()%>" size="30">
	<br>주소 : <input type="text" name="address" value="<%=member.getAddress()%>" size="30">
	<br>전화번호 : <input type="text" name="phone" value="<%=member.getPhone()%>" size="30">
	<br>회원 탈퇴 신청: 
	<select name="useyn">
		<option value=''>--종류선택--</option>
        <option value="1">가입</option>
        <option value="2">탈퇴</option>
    </select><br>
	<br>회원 가입일 : <input type="text" name="regdate" value="<%=member.getRegdate()%>" readonly>
	<br><input type="hidden" name="actionType" value="U_ID">
	<br><input type="submit" value="저장">
	
</form>


<br><a href="<%= adminViewDir %>/index.jsp">홈으로 돌아가기</a>

</body>
</html>