<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

<link
	href="${pageContext.request.contextPath}/resources/css/prettyPhoto.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" id="camera-css"
	href="${pageContext.request.contextPath}/resources/css/camera.css"
	type="text/css" media="all">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/theme.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/skins/tango/skin.css" />
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.css"
	rel="stylesheet">
<title>User Profile</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>

	<div class="page_container">
		<h3>Hello: ${user.userName}</h3>

		User Name: <b>${user.userName}</b> <br />

		<jsp:include page="_footer.jsp"></jsp:include></div>

</body>
</html>