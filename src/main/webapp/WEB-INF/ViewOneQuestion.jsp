
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>One Question with Answers</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>${question.questionText}</h1>
			<p>Tags:</p>
			<ul>
				<c:forEach items="${question.tags}" var="tag">
					<li>${tag.subject}</li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<a href="/questions/new">New Question</a> | <a
				href="/questions/dashboard">Dashboard</a>
		</div>
		<br>
		<div class="col-sm-8">
			<table class="table table-striped">
				<tr class="bg-dark text-light">
					<th>Answers</th>
				</tr>
				<c:forEach items="${question.answers}" var="ans">
					<tr>
						<td>${ans.answerText}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<form:form action="/questions/addAnswer" method="post"
					modelAttribute="newAnswer">
					<form:input type="hidden" path="question" value ="${question.id}"/>
					<div class="form-group">
						<label>Add your answer::</label>
						<form:textarea path="answerText" class="form-control" />
						<form:errors path="answerText" class="text-danger" />
					</div>
					<input type="submit" value="Answer" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>