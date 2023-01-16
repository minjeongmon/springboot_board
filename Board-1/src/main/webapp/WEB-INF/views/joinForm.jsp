<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
</head>
<body class="text-center">

	<!-- header  -->
	<%@include file ="comm/header.jsp"%>
	
	<div class= "container">
		<main class="form-signin">
			<form action="/join" method="post">
			<img class="mb-4" src="https://getbootstrap.com/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">Join</h1>
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
					<label for="floatingPassword">비밀번호를 입력하세요</label>
				</div>
				<div class="form-floating">
					<input type="text" class="form-control" id="userEmail" name="userEmail">
					<label for="floatingInput">이메일을 입력하세요</label>
				</div>

				<button class="w-100 btn btn-lg btn-secondary" type="submit">JOIN</button>
			</form>
		</main>
	</div>
	
	<!-- footer  -->
	<%@include file ="comm/footer.jsp"%>
	
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" 
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" 
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	-->
</body>
</html>