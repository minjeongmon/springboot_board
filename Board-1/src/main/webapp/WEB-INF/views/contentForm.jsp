<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<div class="container" style="width: 75%; margin: 0 auto;">
		<form action="updateAction" method="post">
			<div class="form-group">
				<label for="title">글번호</label>
				<input type="text" class="form-control" id="title" name="board_idx" value="${dto.board_idx }" readonly>
			</div>
			<div class="form-group">
				<label for="title">조회수</label>
				<input type="text" class="form-control" id="title" name="board_hit" value="${dto.board_hit }" readonly>
			</div>
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="title" name="board_title" value="${dto.board_title }">
			</div>
			<div class="form-group">
				<label for="title">작성자</label>
				<input type="text" class="form-control" id="title" name="board_name" value="${dto.board_name }">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="board_contents" rows="5">${dto.board_title }</textarea>
			</div>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button type="submit" class="btn btn-outline-secondary mt-3">수정</button>
				<a type="button" class="btn btn-outline-secondary mt-3" href="deleteAction?board_idx=${dto.board_idx }">삭제</a>
				<a type="button" class="btn btn-outline-secondary mt-3" href="boardList">목록</a>
			</div>
		</form>
		<!-- 댓글 노출 & 작성 -->
		<div style = "margin-top: 30px; margin-bottom: 30px">
		<table class="table table-striped" style="text-align: center;">
			<thead>
				<tr>
					<th scope="col">작성자</th>
					<th scope="col">내용</th>
					<th scope="col">날짜</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="reply_dto" items="${reply_list }">
				
					<tr>
						<td>${reply_dto.reply_name }</td>
						<td>${reply_dto.reply_contents }</td>
						<td>
							<c:set var="dateVar" value="${reply_dto.reply_date }"/>
							<fmt:formatDate value="${dateVar }" pattern="yyyy-MM-dd"/>
						
						</td>
						<td> 
						<a type="button" class="btn btn-secondary btn-sm" href="deleteReplyAction?reply_idx=${reply_dto.reply_idx }&board_idx=${ dto.board_idx }">삭제</a>
						</td>
					</tr>
				
				</c:forEach>
				
			</tbody>
		</table>
		</div>
		
		<form action="replyWrite" method="post">
			<div class="mb-3">
				<input type="hidden" name="reply_board_idx" value="${dto.board_idx }">
				<label for="exampleFormControlInput1" class="form-label">작성자</label>
				<input type="text" class="form-control" id="exampleFormControlInput1" name="reply_name">
			
				<label for="exampleFormControlTextarea1" class="form-label">댓글</label>
				<input type="text" class="form-control" id="exampleFormControlInput1" name="reply_contents">
			</div>
			<div class="d-grid gap-1 d-md-flex justify-content-md-end">
				<button type="submit" class="btn btn-outline-secondary mt-3 btn-sm">확인</button>
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
