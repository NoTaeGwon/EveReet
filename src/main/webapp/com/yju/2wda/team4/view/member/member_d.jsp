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
<title>EveReet - 회원정보삭제(D)</title>
</head>
<body>
<h1>EveReet - 회원정보삭제(D)</h1>
<hr>
<%
	MemberDTO member;
	ArrayList<MemberDTO> memberList;
	MemberPageInfoVO bpiVO;
	
	bpiVO = (MemberPageInfoVO)session.getAttribute("memberPageInfoVO");
	memberList = (ArrayList<MemberDTO>)request.getAttribute("memberList");
	
	int currentPageNo = bpiVO.getCurrentPageNo();
%>

<h2>현재 DISPLAY RECORDS NUMBER : <%= bpiVO.getLimitCnt() %></h2>
<hr>
<br>
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
				<th>삭제</th>
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
				<td><a href="./deleteMemberForID.me?id=<%=member.getId()%>">DELETE</a>
			</tr>
<%
	}
%>
		</tbody>
	</table>

<a href="./deleteMemberListDisplay.me?currentPageNo=0">[FIRST]</a>
<%
	if( currentPageNo > 0){		
%>
	<a href="./deleteMemberListDisplay.me?currentPageNo=<%=(currentPageNo-1) %>">[PRE]</a>
<%
	}else{
%>	
	[PRE]
<%
	}

	for(int i = bpiVO.getStartPageNo(); i < bpiVO.getEndPageNo(); i++) {
		
		if( i == currentPageNo ) {
%>
		[<%=(i+1) %>]
<%
		}else{
%>
			<a href="./deleteMemberListDisplay.me?currentPageNo=<%=i%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>
<%
	if( currentPageNo < bpiVO.getPageCnt() - 1) {		
%>
	<a href="./deleteMemberListDisplay.me?currentPageNo=<%=(currentPageNo+1)%>">[NXT]</a>
<%
	}else{
%>
	[NXT]	
<%
	}
%>
 	<a href="./deleteMemberListDisplay.me?currentPageNo=<%=(bpiVO.getPageCnt()-1)%>">[END]</a>

<br><a href="<%= adminViewDir %>/index.jsp">홈으로 돌아가기</a>
</body>
</html>