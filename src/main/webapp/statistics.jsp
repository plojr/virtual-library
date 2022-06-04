<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<title>Statistics</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
        <div class="col py-3">
            <h3>Here you can see some statistics.</h3>
            <ul>
				<li>Total number of read books: <c:out value="${totalNumber}"></c:out></li>
				<li>Number of read books by year:
					<ul>
					<c:forEach items="${booksByYear}" var="entry">
					    <li>Year = ${entry.key}: ${entry.value} book(s)</li>
					</c:forEach>
					</ul>
				</li>
				<li>Number of read books by month and year:
					<ul>
					<c:forEach items="${booksByMonthYear}" var="entry">
					    <li>Month/Year = ${entry.key}: ${entry.value} book(s)</li>
					</c:forEach>
					</ul>
				</li>
			</ul>
        </div>
    </div>
</div>
</body>
</html>