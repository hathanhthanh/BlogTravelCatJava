<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Home BlogCat</title>
<%-- <link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet"> --%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

<link href="${pageContext.request.contextPath}/resources/css/prettyPhoto.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" id="camera-css"  href="${pageContext.request.contextPath}/resources/css/camera.css" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/theme.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/skins/tango/skin.css" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>


<!--page_container-->
    <div class="page_container">
        <!--slider-->
        <div id="main_slider">
            <div class="camera_wrap" id="camera_wrap_1">
                <div data-src="${pageContext.request.contextPath}/resources/img/slider/1.jpg"></div>
                <div data-src="${pageContext.request.contextPath}/resources/img/slider/2.jpg"></div>
                <div data-src="${pageContext.request.contextPath}/resources/img/slider/3.jpg"></div>
                 <div data-src="${pageContext.request.contextPath}/resources/img/slider/4.jpg"></div>
                <div data-src="${pageContext.request.contextPath}/resources/img/slider/5.jpg"></div>
                <div data-src="${pageContext.request.contextPath}/resources/img/slider/6.jpg"></div>                                        
            </div><!-- #camera_wrap_1 -->
            <div class="clear"></div>	
        </div>        
        <!--//slider-->
                       
        <!--planning-->
        <div class="wrap planning">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <a href="#">
                        	<span class="img_icon icon1"></span>
                            <span class="link_title">観光地</span>
                        	
                        </a>
                    </div>
                    <div class="span3">
                        <a href="#">
                        	<span class="img_icon icon2"></span>
                            <span class="link_title">レストラン</span>
                        </a>
                    </div>
                    <div class="span3">
                        <a href="#">
                        	<span class="img_icon icon3"></span>
                            <span class="link_title">娯楽</span>
                        </a>
                    </div>
                    <div class="span3">
                        <a href="#">
                        	<span class="img_icon icon4"></span>
                            <span class="link_title">道案内</span>
							<!-- arcu arcu. Nulla mollis feugiat dui id tincidunt. Aenean ac
							lobortis elit. -->
						</a>
                    </div>                           	
                </div>
            </div>
        </div>
        <!--//planning-->
        
        <!--Welcome-->
        <div class="wrap block">
            <div class="container welcome_block">
            	<div class="welcome_line welcome_t"></div>
            	ABCDEFDH<span>ABCDFRG &amp; ADBDJKDKKLWKWK</span>
                <div class="welcome_line welcome_b"></div>
            </div>
        </div>
        <!--//Welcome-->         
        
        <!--featured works-->
        <div class="wrap block carousel_block">
            <div class="container">
            	<h2 class="upper">おすすめTop Trips</h2>
            	<div class="row">
                    <div class="span12">
                        <ul id="mycarousel" class="jcarousel-skin-tango">
                            <li>
                            	<div class="hover_img">
                                	<a href="${pageContext.request.contextPath}/resources/img/featured_works/1.jpg" rel="prettyPhoto[portfolio1]"><img src="${pageContext.request.contextPath}/resources/img/featured_works/1.jpg" alt="" /><span class="portfolio_zoom1"></span></a>                                    
                                </div>
                            </li>
                            <li>
                            	<div class="hover_img">
                                	<a href="${pageContext.request.contextPath}/resources/img/featured_works/2.jpg" rel="prettyPhoto[portfolio1]"><img src="${pageContext.request.contextPath}/resources/img/featured_works/2.jpg" alt="" /><span class="portfolio_zoom1"></span></a>                                    
                                </div>
                            </li>
                            <li>
                                <div class="hover_img">
                                	<a href="${pageContext.request.contextPath}/resources/img/featured_works/3.jpg" rel="prettyPhoto[portfolio1]"><img src="${pageContext.request.contextPath}/resources/img/featured_works/3.jpg" alt="" /><span class="portfolio_zoom1"></span></a>                                    
                                </div>
                            </li> 
                            <li>
                                <div class="hover_img">
                                	<a href="${pageContext.request.contextPath}/resources/img/featured_works/4.jpg" rel="prettyPhoto[portfolio1]"><img src="${pageContext.request.contextPath}/resources/img/featured_works/4.jpg" alt="" /><span class="portfolio_zoom1"></span></a>                                    
                                </div>
                            </li>
                            <li>
                            	<div class="hover_img">
                                	<a href="${pageContext.request.contextPath}/resources/img/featured_works/5.jpg" rel="prettyPhoto[portfolio1]"><img src="${pageContext.request.contextPath}/resources/img/featured_works/1.jpg" alt="" /><span class="portfolio_zoom1"></span></a>                                    
                                </div>
                            </li>
                            <li>
                            	<div class="hover_img">
                                	<a href="${pageContext.request.contextPath}/resources/img/featured_works/6.jpg" rel="prettyPhoto[portfolio1]"><img src="${pageContext.request.contextPath}/resources/img/featured_works/2.jpg" alt="" /><span class="portfolio_zoom1"></span></a>                                    
                                </div>
                            </li>                                                       
                        </ul>                         
                    </div>                
                </div>                
            </div>
        </div>        
        <!--//featured works-->
        
        <!--Latest news-->
        <div class="wrap block">
        	<div class="container">
        		<div class="row news_block">
        			<div class="span6">
                    	<h2 class="title">egestas sed convallis metus!</h2>
                        <p>Vestibulum tincidunt ultricies aliquam. Donec porta mi nec tortor sagittis rhoncus. Nunc ante arcu, ornaresit gravida rutrum ut, facilisis et lacus. Aliquam mauris arcu, interdum eu fermentum tincidunt.</p>
                        <ul class="the-icons grey">
                        	<li><i class="icon-time"></i> Curabitur eu placerat massa.</li>
                            <li><i class="icon-star"></i> Integer adipiscing velit nec purus facilisis ut pharetra!</li>
                            <li><i class="icon-camera"></i> Nunc mollis, nisl vel tincidunt vestibulum, lacus libero mollis urna, eu dapibus lacus nisi et nulla.</li>
                            <li><i class="icon-qrcode"></i> Curabitur veltpat magna. Pellentesque pellentesque dapibus dictum. </li>
                            <li><i class="icon-user"></i> Nulla ut erat ut massa molestie commodo.</li>
                        </ul>
                        <p>Duis vel ligula et libero iaculis facilisis in vel justo. Duis lacinia orci ut tellus interdum dignissim. Fusce eugei scelerisque enim. Phasellus nec libero lectus. Quisque posuere mi non nibh facilisis semper. Donec lorem suscipit est sed mauris eleifend congue. Class taciti sociosqu litora torquent <a href="#" class="arrow_link">per conubia.</a></p>
                    </div> 
                    <div class="span6">
                    	<h2 class="title">Latest news</h2>
                        <ul id="newscarousel" class="jcarousel-skin-tango">
                            <li>
                            	<div class="news_date">15 apr<span>2019</span></div>
                                <div class="news_t"><a href="#">Sed massa dui, porta corper ac varius!</a></div>
                                <div class="news">Posted by <a href="#">Anna Smith</a>  /  In <a href="#">City</a><br/>Tags: <a href="#">eget</a>, <a href="#">mauris</a></div>
                                <div class="news_info">Tristique tincidunt cursus sed, ornare ncidunt eque a tristique. Phasellus porttitor mollis tortor etoq vestibulum. Quisque non lacus tortor, quis cumsan nibh. Lorem ipsum dolor sit amet, consectetur icing elit. Nullam pulvinarteses lorem sed dui euismod eget. <a href="#">Read more...</a></div>
                                <div class="clear"></div>
                            </li>
                            <li>
                            	<div class="news_date">05 apr<span>2019</span></div>
                                <div class="news_t"><a href="#">eget &amp; massa viviamu marius mas</a></div>
                                <div class="news">Posted by <a href="#">Anna Smith</a>  /  In <a href="#">City</a><br/>Tags: <a href="#">eget</a>, <a href="#">mauris</a></div>
                                <div class="news_info">Cursus sed, aliquet nec odio. Integer ornare tincidunt neque a tristique. Phasellus porttitor millis tortor etoq vestibulum. Quisque ont lacus toirtor uis accumsan nibh. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ulvinarteses em sed. <a href="#">Read more...</a></div>
                                <div class="clear"></div>
                            </li>
                            <li>
                            	<div class="news_date">15 apr<span>2019</span></div>
                                <div class="news_t"><a href="#">Sed massa dui, porta corper ac varius!</a></div>
                                <div class="news">Posted by <a href="#">Anna Smith</a>  /  In <a href="#">City</a><br/>Tags: <a href="#">eget</a>, <a href="#">mauris</a></div>
                                <div class="news_info">Tristique tincidunt cursus sed, ornare ncidunt eque a tristique. Phasellus porttitor mollis tortor etoq vestibulum. Quisque non lacus tortor, quis cumsan nibh. Lorem ipsum dolor sit amet, consectetur icing elit. Nullam pulvinarteses lorem sed dui euismod eget. <a href="#">Read more...</a></div>
                                <div class="clear"></div>
                            </li>
                            <li>
                            	<div class="news_date">05 apr<span>2019</span></div>
                                <div class="news_t"><a href="#">eget &amp; massa viviamu marius mas</a></div>
                                <div class="news">Posted by <a href="#">Anna Smith</a>  /  In <a href="#">City</a><br/>Tags: <a href="#">eget</a>, <a href="#">mauris</a></div>
                                <div class="news_info">Cursus sed, aliquet nec odio. Integer ornare tincidunt neque a tristique. Phasellus porttitor millis tortor etoq vestibulum. Quisque ont lacus toirtor uis accumsan nibh. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ulvinarteses em sed. <a href="#">Read more...</a></div>
                                <div class="clear"></div>
                            </li>
                         </ul> 
                    </div>       		
            	</div>
        	</div>
        </div>
        <!--Latest news-->
        
       
    </div>
    <!--//page_container-->
	<jsp:include page="_footer.jsp"></jsp:include>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mobile.customized.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/camera.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/superfish.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.jcarousel.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.tweet.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myscript.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){	
			//Slider
			$('#camera_wrap_1').camera();
			
			//Featured works & latest posts
			$('#mycarousel, #mycarousel2, #newscarousel').jcarousel();													
		});		
	</script>
</body>
</html>