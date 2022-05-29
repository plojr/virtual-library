<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="header.jsp" />
<title>Authors Title</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
        <div class="col py-3">
            <h3>Here you can see the list of authors by name.</h3>
            <table class="table table-bordered">
				<thead>
		      		<tr>
				        <th>Name</th>
		      		</tr>
		    	</thead>
		    	<tbody>
	            <c:forEach items="${authors}" var="author">
	            	<tr><td><c:out value="${author.name}"></c:out></td></tr>
	            </c:forEach>
	            </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>