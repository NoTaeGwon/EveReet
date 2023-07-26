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
<title>EveReet - 회원정보조회(R)</title>
</head>
<body>
<h1>EveReet - 회원정보조회(R)</h1>
<hr>
<h2>전체보기(부분조회,페이징기능 미포함)</h2>


<%
	MemberDTO member;
	ArrayList<MemberDTO> memberList;
	
	memberList = (ArrayList<MemberDTO>)request.getAttribute("memberList");
%>

	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>회원 탈퇴여부</th>
				<th>회원 가입일</th>
			</tr>
		</thead>		
		<tbody>
		
<%
for(int i=0; i < memberList.size(); i++) {
	member = memberList.get(i);
%>		
		<tr>
				<td><%=member.getId() %></td>
				<td><%=member.getPwd() %></td>
				<td><%=member.getName() %></td>
				<td><%=member.getEmail() %></td>
				<td><%=member.getZip_code() %></td>
				<td><%=member.getAddress() %></td>
				<td><%=member.getPhone() %></td>
				<td><%=member.getUseyn() %></td>
				<td><%=member.getRegdate() %></td>
		</tr>
<%
	}
%>

		</tbody>
	</table>

<br><a href="<%= adminViewDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>