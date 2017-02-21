<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Home->Travel BlogCat 管理</title>
</head>
<body>
	<!--  border: 2px solid;
    border-radius: 25px; -->
	<jsp:include page="_header.jsp"></jsp:include>
	<div class="page_container">
		<!--Latest news-->

		<p style="color: red;">${errorString}</p>
		<a href="addLocation">観光地 追加</a>
		<table border="1" cellpadding="5" cellspacing="1">
			<tr>
				<th>番号</th>
				<th>場所名</th>
				<th>駅</th>
				<th>詳細</th>
				<th>アドレス</th>
				<th>行動</th>
			</tr>
			<c:forEach var="item" items="${listLocations}">
				<tr>
					<td>${item.local_ID}</td>
					<td>${item.name}</td>
					<td>${item.station}</td>
					<td>${item.content}</td>
					<td>${item.address}</td>
					<td><a href="editLocation?local_ID=${item.local_ID}">更新</a> | <a
						href="deleteLocation?local_ID=${item.local_ID}">削除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!--Latest news-->


	<hr>
	<jsp:include page="_footer.jsp"></jsp:include>
	<!--//page_container-->
	<jsp:include page="_footer.jsp"></jsp:include>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.mobile.customized.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/camera.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/superfish.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.jcarousel.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.tweet.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/myscript.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			//Slider
			$('#camera_wrap_1').camera();

			//Featured works & latest posts
			$('#mycarousel, #mycarousel2, #newscarousel').jcarousel();
		});
	</script>
</body>
</html>