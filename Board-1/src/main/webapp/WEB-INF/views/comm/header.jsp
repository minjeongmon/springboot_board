<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
		<a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
		<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
		</a>
		
		<ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
			<li><a href="/" class="nav-link px-2 link-secondary">Home</a></li>
			<li><a href="/boardList" class="nav-link px-2 link-dark">Board</a></li>
		</ul>
		
		<div class="col-md-3 text-end">
		
		<c:choose>
            <c:when test="${empty authUser}">
				<button type="submit" class="btn btn-secondary" onclick="location.href='/loginForm'">Login</button>
				<button type="submit" class="btn btn-secondary" onclick="location.href='/joinForm'">Sign-up</button>
            </c:when>
            <c:otherwise>
               Hello~~~~ ${ sessionScope.authUser.userName} 
               <button type="submit" class="btn btn-secondary" onclick="location.href='/logout'">Logout</button>
            </c:otherwise>
         </c:choose>
         
		</div>
	</header>
</div>