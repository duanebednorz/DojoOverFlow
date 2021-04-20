<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions Dashboard</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Questions Dashboard</h1>
		</div>
		<div>
			<a href="/questions/new">New Question</a> | <a
				href="/questions/dashboard">Dashboard</a>
		</div>
		<hr>
		<div class="col-sm-8">
			<table class="table table-striped">
				<tr class="bg-dark text-light">
					<th>Question</th>
					<!-- <th>Answers</th> -->
					<th>Tags</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${allQuestions}" var="ques">
					<tr>
						<td><a href="/questions/${ques.id}">${ques.questionText}</a></td>
						<td>
						<c:forEach items="${ques.tags}" var="tag">
						${tag.subject}<c:if test ="${ques.tags.indexOf(tag) !=ques.tags.size() - 1 }">, </c:if>
						</c:forEach>
						</td>
						<td>
						<a href ="/questions/delete/${ques.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>