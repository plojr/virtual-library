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
				<li>Total number of read <span style="text-decoration: underline;">books</span>: <c:out value="${totalNumber}"></c:out></li>
				<li>Number of read <span style="text-decoration: underline;">books</span> by <span style="text-decoration: underline;">year</span>:
					<ul>
					<c:forEach items="${booksByYear}" var="entry">
					    <li>Year = ${entry.key}: ${entry.value} book(s)</li>
					</c:forEach>
					</ul>
				</li>
				<li>Number of read <span style="text-decoration: underline;">books</span> by <span style="text-decoration: underline;">month</span> and <span style="text-decoration: underline;">year</span>:
					<ul>
					<c:forEach items="${booksByMonthYear}" var="entry">
					    <li>Month/Year = ${entry.key}: ${entry.value} book(s)</li>
					</c:forEach>
					</ul>
				</li>
				
				<li>Number of read <span style="text-decoration: underline;">pages</span> by <span style="text-decoration: underline;">year</span>:
					<ul>
					<c:forEach items="${pagesByYear}" var="entry">
					    <li>Year = ${entry.key}: ${entry.value} page(s)</li>
					</c:forEach>
					</ul>
				</li>
				<li>Number of read <span style="text-decoration: underline;">pages</span> by <span style="text-decoration: underline;">month</span> and <span style="text-decoration: underline;">year</span>:
					<ul>
					<c:forEach items="${pagesByMonthYear}" var="entry">
					    <li>Month/Year = ${entry.key}: ${entry.value} page(s)</li>
					</c:forEach>
					</ul>
				</li>
			</ul>
        </div>
    </div>
</div>
</body>
</html>