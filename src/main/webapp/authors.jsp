<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="header.jsp" />
<title>Authors</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
        <div class="col py-3">
            <h3>Here you can see the list of authors by name.</h3>
            <table class="table">
				<thead>
		      		<tr class="d-flex">
		      			<th class="col-sm-2">Name</th>
		      		</tr>
		    	</thead>
		    	<tbody>
	            <c:forEach items="${authors}" var="author">
	            	<tr class="d-flex"><td class="col-sm-2"><c:out value="${author.name}"></c:out></td></tr>
	            </c:forEach>
	            </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>