<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
			<div style="float: right">
				<input type="text" name="search"/>
				<button type="button" class="btn btn-secondary">검색</button>
			</div>

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
					
					<c:forEach var="dto" items="${list }"  varStatus="status">
					
						<tr>
						
							<!-- 게시글 번호 역순 카운팅 -->
							<td>
								${fn:length(list) - status.index }
							</td>
							<td>
								<a href="contentForm?board_idx=${dto.board_idx}">${dto.board_title }</a>
							</td>
							<td>
								${dto.board_name }
							</td>
							<td>
								<c:set var="dateVar" value="${dto.board_date }"/>
								<fmt:formatDate value="${dateVar }" pattern="yyyy-MM-dd"/>
							</td>
							<td>
								${dto.board_hit }
							</td>
						</tr>
						
					</c:forEach>

				</tbody>
			</table>
			
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#"><</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">></a></li>
					</ul>
				</nav>

			
			<c:if test = "${not empty authUser }">
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<a href="/writeForm" class="btn btn-dark">작성</a>
				</div>
			</c:if>
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
