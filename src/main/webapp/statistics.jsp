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
			</ul>
        </div>
    </div>
</div>
</body>
</html>