<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<title>Assign Finish Date</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
        <div class="col py-3">
            <h3>Here you can assign a finish date to a book.</h3>
            <form action="assign_finish_date" method="post">
            	<input type="hidden" name="listSize" value="<c:out value="${books.size()}"></c:out>" />
	            <table class="table table-bordered">
					<thead>
			      		<tr>
			      			<th>#</th>
					        <th>Name</th>
					        <th>Number of pages</th>
					        <th>Finish date</th>
					        <th>Authors</th>
			      		</tr>
			    	</thead>
			    	<tbody>
		            <c:forEach items="${books}" var="book" varStatus="loop">
		            	<tr>
							<td>
								<c:out value="${loop.index+1}"></c:out>
								<input type="hidden" name=<c:out value="id${loop.index}"></c:out> value="<c:out value="${book.id}"></c:out>" />
							</td>
		            		<td>
		            			<c:out value="${book.name}"></c:out>
		            			<input type="hidden" name=<c:out value="name${loop.index}"></c:out> value="<c:out value="${book.name}"></c:out>" />
		            		</td>
		            		<td>
		            			<c:out value="${book.numberOfPages}"></c:out>
		            			<input type="hidden" name=<c:out value="numberOfPages${loop.index}"></c:out> value="<c:out value="${book.numberOfPages}"></c:out>" />
							</td>
		            		<td>
		            			<c:choose>
								    <c:when test="${empty book.finishDate}">
								        <input type="date" name=<c:out value="finishDate${loop.index}"></c:out> class="form-control" id="inputFinishDate" 
								        	placeholder="Enter the date when you finish reading it">
								    </c:when>
								    <c:otherwise>
								    	<input type="date" name=<c:out value="finishDate${loop.index}"></c:out> class="form-control" id="inputFinishDate" 
								    		placeholder="Enter the date when you finish reading it" value=<c:out value="${book.finishDate}"></c:out> >
								    </c:otherwise>
								</c:choose>
		            		</td>
		            		<td><c:out value="${book.authorsString}"></c:out></td>
		            	</tr>
		            </c:forEach>
		            </tbody>
	            </table>
	            <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>