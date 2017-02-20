<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--header-->
<div class="header">
	<div class="wrap">
		<div class="navbar navbar_ clearfix">
			<div class="container">
				<div class="row">
					<div class="span4">
						<div class="logo">
							<a href="home"><img
								src="${pageContext.request.contextPath}/resources/img/logo.png"
								alt="" />
							</a>
						</div>
					</div>
					<div class="span8">
						<div class="follow_us">
							<ul>
								<li><a href="#" class="facebook">Facebook</a>
								</li>
								<li><a href="#" class="vimeo">Line</a>
								</li>
								<li><a href="#" class="twitter">Twitter</a>
								</li>
							</ul>
						</div>
						<div class="clear"></div>
						<nav id="main_menu">
						<div class="menu_wrap">
							<ul class="nav sf-menu">
								<li class="current"><a
									href="${pageContext.request.contextPath}/">Home</a>
								</li>
								<li><a href="${pageContext.request.contextPath}/travelBlog">Travel</a>
								</li>
								<li class="sub-menu"><a href="javascript:{}">Features</a>
									<ul>
										<li><a href="scaffolding.html"><span>-</span>Scaffolding</a>
										</li>
										<li><a href="typography.html"><span>-</span>Typography</a>
										</li>
										<li><a href="shortcodes.html"><span>-</span>Shortcodes</a>
										</li>
										<li><a href="tables.html"><span>-</span>Tables</a>
										</li>
									</ul></li>
								<li class="sub-menu"><a href="javascript:{}">Portfolio</a>
									<ul>
										<li><a href="portfolio_2columns.html"><span>-</span>2
												Columns</a>
										</li>
										<li><a href="portfolio_3columns.html"><span>-</span>3
												Columns</a>
										</li>
										<li><a href="portfolio_4columns.html"><span>-</span>4
												Columns</a>
										</li>
									</ul></li>
								<li class="sub-menu"><a href="${pageContext.request.contextPath}/travelBlog">BlogCat管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/createBlog"><span>-</span>追加</a>
										</li>
										<li><a href="${pageContext.request.contextPath}/travelBlog"><span>-</span>Top BlogCat</a>
										</li>
									</ul></li>
								<!-- if logined hello username | login -->
								<c:if test="${loginedUser == null}">
									<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
								</c:if>
								<c:if test="${loginedUser != null}">
									<li><a href="${pageContext.request.contextPath}/userInfo"><b>${loginedUser.userName}</b> </a>
									</li>
								</c:if>
							</ul>
						</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--//header-->
<%-- <ul>
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/travel">TravelCat</a>
				</li>
				<li><a href="${pageContext.request.contextPath}/userInfo">BlogCat</a>
					<ul>
						<li><a href="#">Hot Location</a></li>
						<li><a href="#">Travel Information</a></li>
						<li><a href="#">Service</a></li>
					</ul></li>
				<li><a href="#">new1</a></li>
				<li><a href="#">New2</a></li>
				<li><a href="#">New3</a></li>
				<!-- if logined hello username | login -->
				<c:if test="${loginedUser == null}">
					<li><a href="/login">Login</a>
					</li>
				</c:if>
				<c:if test="${loginedUser != null}">
					<li><a href="#">Hello <b>${loginedUser.userName}</b> </a></li>
				</c:if>
			</ul> --%>
</div>

