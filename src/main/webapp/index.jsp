<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>EveReet - Main</title>
</head>
<body>
<%@ include file="/header.jsp" %>

<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="5000">
      <img src="/EveReet/com/yju/2wda/team4/images/index/obey_index(수정).JPG" class="d-block w-100" alt="..."/>
    </div>
    <div class="carousel-item" data-bs-interval="5000">
      <img src="/EveReet/com/yju/2wda/team4/images/index/stussy_index(수정).JPG" class="d-block w-100" alt="..."/>
    </div>
    <div class="carousel-item" data-bs-interval="5000">
      <img src="/EveReet/com/yju/2wda/team4/images/index/supreme_index(수정).JPG" class="d-block w-100" alt="..."/>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
<%@ include file="/footer.jsp" %>





</body>
</html>