<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value = "/resources/css/sidebar.css" />"/>
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap.min.css"/>"/>
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap-theme.min.css"/>"/>
<script src="<c:url value = "/resources/js/jquery-3.1.0.min.js"/>"></script>
<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"></script>

</head>
<body>
	
	<div class="container" style="margin-top: 40px">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> Sign in to continue</strong>
					</div>
					<div class="panel-body">
						<form role="form" action="loginUser" method="POST">
							<fieldset>
								<div class="row">
									<div class="center-block">
										<img class="img-thumbnail center-block"
											src="resources/images/assassins_creed_unity_6-wallpaper-3840x2160.jpg"
											alt="" height="150px" width="150px">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-user"></i>
												</span> <input class="form-control" placeholder="Username"
													name="loginname" type="text" autofocus>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="glyphicon glyphicon-lock"></i>
												</span> <input class="form-control" placeholder="Password"
													name="password" type="password" value="">
											</div>
										</div>
										<div class="form-group">
											<input type="submit" class="btn btn-lg btn-primary btn-block"
												value="Sign in">
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="panel-footer ">
						Don't have an account! <a href="Registration.jsp"> Sign Up Here </a>
					</div>

					<div class="panel-footer">
					 ${error}
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>