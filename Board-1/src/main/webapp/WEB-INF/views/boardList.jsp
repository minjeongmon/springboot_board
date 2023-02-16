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

<!-- 	<script type="text/javascript">
		$("#searchButton").on("click", function(e){
			e.preventDefault();
			let val = $("input[name='keyword']").val();
			moveForm.find("input[name='keyword']").val(val);
			moveForm.find("input[name='pageNum']").val(1);
			moveForm.submit();
		})
	
	</script> -->

	<!-- header  -->
	<%@include file ="comm/header.jsp"%>

			<div class="container" style="width: 75%; margin: 0 auto;">
						
				<form id="searchForm" method="get">
					<div style="float: right">
						<input type="text" name="keyword" placeholder="검색어를 입력하세요"/>
						<button id="searchButton" class="btn btn-secondary">검색</button>
					</div>
				</form>

			<table class="table table-hover" style="text-align: center;">
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
			
			<!--  pagination  -->
			
			<div class="center">
				<ul class="pagination justify-content-center">
					<c:if test="${pageMaker.prev }">
						<!-- 이전 페이지 -->
						<li class="page-item"><a class="page-link" href="boardList?pageNum=${pageMaker.startPage - 1 }">Previous</a></li>
					</c:if>
					
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="num">
						<li class="page-item"><a class="page-link" href="boardList?pageNum=${num }">${num }</a></li>
					</c:forEach>
					
					<c:if test="${pageMaker.next }">
						<!-- 다음 페이지 -->
						<li class="page-item"><a class="page-link" href="boardList?pageNum=${pageMaker.endPage + 1 }">Next</a></li>
					</c:if>
				</ul>
			</div>
			

			<!-- 글쓰기 버튼 -->
			<c:if test = "${not empty authUser }">
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<a href="/writeForm" class="btn btn-dark">작성</a>
				</div>
			</c:if>
		</div>
		
	<!-- footer  -->
	<%@include file ="comm/footer.jsp"%>

	
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
	</script>

</body>
</html>
