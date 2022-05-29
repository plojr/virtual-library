<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
 <!-- Latest compiled and minified CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="js/bootstrap.bundle.min.js"></script> 
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Books Title</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                <a href="/" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    <span class="fs-5 d-none d-sm-inline">Menu</span>
                </a>
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                    <li class="nav-item">
                        <a href="home" class="nav-link align-middle px-0">
                            <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="authors" class="nav-link px-0 align-middle">
                            <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Authors</span> </a>
                    </li>
                    <li>
                        <a href="books" class="nav-link px-0 align-middle">
                            <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Books</span></a>
                    </li>
                    <li>
                        <a href="add_books" class="nav-link px-0 align-middle">
                            <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Add books</span> </a>
                    </li>
                </ul>
            </div>
        </div>
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