<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<title>Books</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
        <div class="col py-3">
            <h3>Here you can see the list of books.</h3>
            <table class="table table-bordered">
				<thead>
		      		<tr>
				        <th>Name</th>
				        <th>Number of pages</th>
				        <th>Finish date</th>
				        <th>Authors</th>
		      		</tr>
		    	</thead>
		    	<tbody>
	            <c:forEach items="${books}" var="book">
	            	<tr>
	            		<td><c:out value="${book.name}"></c:out></td>
	            		<td><c:out value="${book.numberOfPages}"></c:out></td>
	            		<td>
	            			<c:choose>
							    <c:when test="${empty book.finishDate}">
							        Not read yet.
							    </c:when>
							    <c:otherwise>
							        <fmt:formatDate value="${book.finishDate}" pattern="yyyy-MM-dd"/>
							    </c:otherwise>
							</c:choose>
	            		</td>
	            		<td><c:out value="${book.authorsString}"></c:out></td>
	            	</tr>
	            </c:forEach>
	            </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>