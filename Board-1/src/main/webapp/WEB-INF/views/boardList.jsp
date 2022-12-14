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
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">등록일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="dto" items="${list }">
					
						<tr>
							<td>${dto.board_idx }</td>
							<td>
								<a href="contentForm?board_idx=${dto.board_idx}">${dto.board_title }</a>
							</td>
							<td>${dto.board_name }</td>
							<td>
								<c:set var="dateVar" value="${dto.board_date }"/>
								<fmt:formatDate value="${dateVar }" pattern="yyyy-MM-dd"/>
							</td>
							<td>${dto.board_hit }</td>
						</tr>
						
					</c:forEach>

				</tbody>
			</table>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<a href="/writeForm" class="btn btn-dark">Write</a>
			</div>
		</div>
	</main>

	<!-- footer  -->
	<%@include file ="comm/footer.jsp"%>

	
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
	</script>

</body>
</html>
