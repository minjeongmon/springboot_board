<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<title>Spring Boot - Board List</title>
</head>
<body>
	<!-- header  -->
	<%@include file ="comm/header.jsp"%>
	
	<main>
	<div class="container">
		<form action="writeAction" method="post" style="width: 75%; margin: 0 auto;">
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="title" name="board_title" placeholder="제목을 입력하세요">
			</div>
			<div class="form-group">
				<label for="title">작성자</label>
				<input type="text" class="form-control" id="title" name="board_name" value="${ sessionScope.authUser.userName}" readonly>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="board_contents" rows="5" placeholder="내용을 입력하세요"></textarea>
			</div>
			
			<div class="form-group">
				<label for="addFile">파일 첨부</label>
				
			</div>
			
			
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button type="submit" class="btn btn-outline-secondary mt-3">확인</button>
				<button type="button" class="btn btn-outline-secondary mt-3" onclick="location.href='boardList'">목록</button>
			</div>
		</form>
	</div>
	</main>
	
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
