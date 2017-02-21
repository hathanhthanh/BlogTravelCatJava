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
		<div class="wrap block">
			<div class="container">
				<a href="createBlog"
					style="min-height: 80px; min-width: 150px; border-radius: 5px; text-align: center; font-size: 25pt; font-weight: bold; color: black !important">BlogCat
					新規</a> <br />
				<hr />
				<br />
				<div class="row news_block">
					<div class="span6">
						<h2 class="title">${lastNewBlog.title}</h2>
						<div class="hover_img">
							<a
								href="${pageContext.request.contextPath}/${lastNewBlog.getImage().getUrl()}"
								rel="prettyPhoto[portfolio1]"><img
								src="${pageContext.request.contextPath}/${lastNewBlog.getImage().getUrl()}"
								alt="" /><span class="portfolio_zoom1"></span></a>
						</div>
						<p>${lastNewBlog.getLocation().getName()}</p>
						<ul class="the-icons grey">
							<li><i class="icon-time"></i>${lastNewBlog.last_Edit}</li>
							<li><i class="icon-star"></i>${lastNewBlog.getLocation().getAddress()}
							</li>
							<li><i class="icon-camera"></i>${lastNewBlog.publish_Date}</li>
						</ul>
						<p>
							${lastNewBlog.contents} <a href="#" class="arrow_link">${lastNewBlog.title}</a>
						</p>
					</div>
					<div class="span6">
						<h2 class="title">最新 BlogCat</h2>
						<ul id="newscarousel" class="jcarousel-skin-tango">
							<c:forEach var="item" items="${listBlog}">
								<li>
									<div class="hover_img">
										<a
											href="${pageContext.request.contextPath}/${item.getImage().getUrl()}"
											rel="prettyPhoto[portfolio1]"><img
											src="${pageContext.request.contextPath}/${item.getImage().getUrl()}"
											alt="" /><span class="portfolio_zoom1"></span></a>
									</div>
									<div class="news_date">
										${item.publish_Date}<span></span>
									</div>
									<div class="news_t">
										<a href="#">${item.getLocation().getName()}</a>
									</div>
									<div class="news">
										筆者: <a href="#">${item.userName}</a> / <a href="#">${item.title}</a>
									</div>
									<div class="news_info">${item.contents}<a href="#">...</a>
									</div>
									<div class="clear"></div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--Latest news-->


		<hr>
		<!--featured works-->

		<div class="wrap block carousel_block">
			<div class="container">
				<h2 class="upper">おすすめTop Trips</h2>
				<div class="row">
					<div class="span12">
						<ul id="mycarousel" class="jcarousel-skin-tango">
							<c:forEach var="item" items="${listImage}">
								<li>
									<div class="hover_img" style="text-align: center">
										<a href="${pageContext.request.contextPath}/${item.url}"
											rel="prettyPhoto[portfolio1]"><img
											src="${pageContext.request.contextPath}/${item.url}" alt="" /><span
											class="portfolio_zoom1"></span> ${item.image_Name}</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--//featured works-->
	</div>
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