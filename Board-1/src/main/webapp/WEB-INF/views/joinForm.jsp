<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">
	<title>Spring Boot - Join Page</title>
	<!-- Jquery 사용 -->
	<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  	crossorigin="anonymous"></script>
	
</head>
<body class="text-center">

	<!-- header  / c:import로 사용 할 수 있음 -->
	<%@include file ="comm/header.jsp"%>
	<%-- <c:import url="/comm/hearder.jsp"/> --%>
	

	<div class= "container">
			<form id="joinForm" method="post">
			<h1 class="h4 mb-4 fw-normal"> Join us (｡•̀ᴗ-)✧ </h1>
				<div class="form-floating">
					<input type="text" class="form-control" id="userId" name="userId">
					<label for="floatingInput">아이디를 입력하세요</label>
				</div>

				<div class="form-floating">
					<input type="text" class="form-control" id="userName" name="userName">
					<label for="floatingInput">이름을 입력하세요</label>

				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="userPwd" name="userPwd">
					<label for="floatingInput">비밀번호를 입력하세요</label>
				</div>
				<div class="form-floating">
					<input type="text" class="form-control" id="userEmail" name="userEmail">
					<label for="floatingInput">이메일을 입력하세요</label>
				</div>

				<button class="w-100 btn btn-lg btn-secondary" id="joinButton" type="button">JOIN</button>
			</form>
	</div>
	
	
	<!-- Jquery로 회원가입 유효성 체크 validation 사용 하고 싶은데 잘 모르겠음 -->
	<script>
	
	$(document).ready(function(){
		$("#joinButton").click(function(){
			$("#joinForm").attr("action", "/join");
			$("#joinForm").submit();
			alert("회원가입 완료")
		});
	});

	</script>

	<!-- footer / c:import 로 사용 가능  -->
	<%@include file ="comm/footer.jsp"%>
	<%-- <c:import url="/comm/footer.jsp"/> --%>
	
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	
</body>
</html>