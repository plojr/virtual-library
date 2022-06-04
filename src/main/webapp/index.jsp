<jsp:include page="header.jsp" />
<title>Home</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
        <div class="col py-3">
            <h2>Welcome to the home of virtual library.</h2>
            <p>Here you'll be able to add books to your library and see some statistics about them.</p>
            <p>If you want to check the authors' list, click <a href="authors">here</a>.</p>
            <p>If you want to check the books' list, click <a href="books">here</a>.</p>
            <p>If you want to add a the book, click <a href="add_book">here</a>.</p>
            <p>If you finish reading a book and want to assign it a date, click <a href="assign_finish_date">here</a>.</p>
            <p>If you want to see some statistics, click <a href="statistics">here</a>.</p>
        </div>
    </div>
</div>
</body>
</html>