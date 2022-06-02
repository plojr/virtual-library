<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<title>Add Book Title</title>
</head>
<script type="text/javascript">
var index = 0;
function add() {
	var author = document.createElement("input");
	author.setAttribute("type", "text");
	author.setAttribute("name", "author" + index);
	author.setAttribute("class", "form-control");
	author.setAttribute("placeholder", "Enter author's name");
	var spanvar = document.getElementById("authors");
	spanvar.appendChild(author);
	index = index + 1;
	var sizeElement = document.getElementById("numberOfAuthors");
	sizeElement.value = index;
}
</script>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
        <div class="col py-3">
            <h3>Here you can add a book.</h3>
			<form method="post" action="add_book">
			  <div class="form-group">
			    <label for="inputName">Book's name</label>
			    <input type="text" name="name" class="form-control" id="inputBook" placeholder="Enter book's name" required>
			  </div>
			  <div class="form-group">
			    <label for="inputNumberOfPages">Number of pages</label>
			    <input type="number" name="numberOfPages" class="form-control" id="inputNumberOfPages" placeholder="Enter the number of pages" required>
			  </div>
			  <div class="form-group">
			    <label for="inputFinishDate">Finish date</label>
			    <input type="date" name="finishDate" class="form-control" id="inputFinishDate" placeholder="Enter the date when you finish reading it">
			  </div>
			  <br />
			  <input type="button" name="addrows" class="btn btn-primary btn-sm" value="Add author field" aria-describedby="authorHelp" onclick="add();">
			  <small id="authorHelp" class="form-text text-muted">&lt;= Click here to add a field to enter an author's name</small>
			  <br />
			  <span id="authors"></span>
			  <input type="hidden" id="numberOfAuthors" name="numberOfAuthors" value="0"/>
			  <br />
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
    </div>
</div>
</body>
</html>