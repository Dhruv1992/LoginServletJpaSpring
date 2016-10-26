<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<c:url value = "/resources/css/sidebar.css" />" />
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap-theme.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value = "/resources/css/styles.css"/>" />
<script src="<c:url value = "/resources/js/jquery-3.1.0.min.js"/>"></script>
<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value = "/resources/js/functions.js"/>"></script>

<link rel="stylesheet" href="/resources/css/sidebar.css" />
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/bootstrap-theme.min.css" />
<script src="/resources/js/jquery-3.1.0.min.js" /></script>
<script src="/resources/js/bootstrap.min.js" /></script>

</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">

		<!-- LOGO -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#naiveBar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">Welcome ${user} </a>
		</div>

		<!-- Menu -->
		<div class="collapse navbar-collapse" id="naiveBar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Contact US</a></li>

				<!-- Dropdown menu -->
				<li class="dropdown">
				<li><a href="#" class="dropdown" data-toggle="dropdown">
						Actions <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#" id="addDept">Add Department</a></li>
						<li><a id="addEmp" href="#">Add Employee</a></li>
						<li><a href="#">Settings</a></li>
					</ul></li>

			</ul>


			<!-- Right alignment -->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Logout">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid" id="empList" style="display: none">
		<form role="form" method="POST" action="insertEmpData"
			data-toggle="validator">
			<div class="col-lg-4">

				<div class="form-group">
					<div class="input-group" style="margin: 20px">
						<label> Employee FirstName </label> <input class="form-control"
							placeholder="Employee FirstName" name="emp_fname" type="text"
							autofocus required>

					</div>

					<div class="input-group" style="margin: 20px">
						<label> Employee LastName </label> <input class="form-control"
							placeholder="Employee LastName" name="emp_lname" type="text"
							autofocus required>

					</div>

					<div class="input-group" style="margin: 20px">
						<label> Employee Age </label> <input class="form-control"
							type="text" placeholder="Employee Age" name="emp_age" autofocus>

					</div>
					<div class="input-group">
						<select class="selectpicker" name="deptName" id="selectDept">

						</select>
					</div>
					<div class="form-horizontal" style="margin-top: 20px">
						<div class="left">
							<input type="submit" class="btn btn-sm" value="Save">
						</div>

						<div>
							<input id="cancelEmp" type="button" class="btn btn-sm"
								value="Cancel">
						</div>

					</div>


				</div>
			</div>
		</form>


	</div>

	<div class="text-center">${emp_response}</div>
	<div>
		<form role="form" id="fileUpload" method="POST"
			enctype="multipart/form-data">
			<label class="btn btn-default btn-file" path="file"> <input
				type="file" name="file" id="file" />
			</label>
			<div class="left">
				<input type="submit" class="btn btn-sm" value="Upload"
					style="margin-top: 20px">
			</div>
			<div class="form-horizontal">${fileMessage}</div>
		</form>


	</div>
<br/>
	

	<div id="deptList" class="container-fluid"
		style="display: none; margin-top: 20px">
		<form role="form" method="POST" action="insertDeptData">
			<div class="col-lg-4">

				<div class="form-group">
					<div class="input-group">
						<label> Department Name </label> <input class="form-control"
							placeholder="Department Name" name="dept_name" type="text"
							autofocus>

					</div>

					<div class="input-group">
						<label> Department Email </label> <input class="form-control"
							placeholder="Department Email" name="dept_email" type="text"
							autofocus>

					</div>

					<div class="form-inline" style="margin-top: 20px">
						<div class="left">
							<input type="submit" class="btn btn-sm" value="Save">
						</div>

						<div class="left">
							<input id="cancelDept" type="button" class="btn btn-sm"
								value="Cancel">
						</div>

					</div>


				</div>
			</div>
		</form>
	</div>


	<div class="text-center">${dept_response}</div>


	<div>

		<c:if test="${not empty empList}">
			<table id="empList" class="table table-bordered">
				<thead>
					<tr>
						<th>Employee FirstName</th>
						<th>Employee LastName</th>
						<th>Employee Age</th>
						<th>Department Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${empList}" var="items">
						<tr>
							<td><c:out value="${items[0]}" /></td>
							<td><c:out value="${items[1]}" /></td>
							<td><c:out value="${items[2]}" /></td>
							<td><c:out value="${items[3]}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>


	<div>

		<c:if test="${not empty SubDeptList}">
			<table id="empList" class="table table-bordered">
				<thead>
					<tr>
						<th>Department Name</th>
						<th>Subject Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${SubDeptList}" var="items">
						<tr>
							<td><c:out value="${items.deptName}" /></td>
							<td><c:out value="${items.subName}" /></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>



	<br/>
	<div class="form-group">
	<form action="getDeptSearch" method="post">
		<input type="text" name="dept_name" id="searchText" class="input-sm"
			placeholder="Search" />
		<ul id="textArea"></ul>
		<button type="submit" class="btn btn-sm">Search</button>
	</form>
	</div>
	
	
	<div class="well col-lg-6" >
		<form class="form-group" role="form">
			<h4>What's New</h4>
			<div class="form-group" style="padding: 14px;">
				<textarea class="form-control" placeholder="Update your status"></textarea>
			</div>
			<button class="btn btn-primary pull-right" type="button">Post</button>
			<ul class="list-inline">
				<li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li>
				<li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li>
				<li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li>
			</ul>
		</form>
	</div>
	
	
	<div>
		<c:if test="${not empty users}">
			<table class="table table-bordered">
				<caption>User List</caption>
				<thead>
					<tr>
						<th>Country</th>
						<th>Code1</th>
						<th>Code2</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users.restResponse.result}" var="items">
						<tr>
							<td><c:out value="${items.name}" /></td>
							<td><c:out value="${items.alpha2_code}" /></td>
							<td><c:out value="${items.alpha3_code}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

	<div>
		<c:if test="${not empty dept}">
			<table class="table table-bordered">
				<caption>Dept List</caption>
				<tbody>
					<%-- <c:forEach items="${dept}" var="items">
					
						<tr>
							<td><c:out value="${items.employee.age}"/></td>
						</tr>
						</c:forEach>
					 --%>
				</tbody>
			</table>
		</c:if>
	</div>

	<div>
		<c:if test="${not empty deptList}">
			<table class="table table-bordered">
				<caption>Department List</caption>
				<thead>
					<tr>
						<th>Department Name</th>
						<th>Department Email</th>
						<th colspan="2">Employee</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${deptList}" var="items" varStatus="iter">
						<tr>
							<td><c:out value="${items[0]}" /></td>
							<td><c:out value="${items[1]}" /></td>
							<td><c:out value="${items[2]}" /></td>
							<td><c:out value="${items[3]}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>


</body>
</html>