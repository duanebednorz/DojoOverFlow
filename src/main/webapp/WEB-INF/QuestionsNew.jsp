<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Questions</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>What is your question?</h1>
		</div>
		<div>
			<a href="/questions/new">New Question</a> | <a
				href="/questions/dashboard">Dashboard</a>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-4">
				<form:form action="/questions/create" method="post"
					modelAttribute="newQuestion">
					<div class="form-group">
						<label>Question:</label>
						<form:input path="questionText" class="form-control" />
						<form:errors path="questionText" class="text-danger" />
					</div>
					<div class="form-group">
						<label>Tags:</label>
						<form:input path="parsedTags" class="form-control" />
						<form:errors path="parsedTags" class="text-danger" />
					</div>
					<input type="submit" value="Submit" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>