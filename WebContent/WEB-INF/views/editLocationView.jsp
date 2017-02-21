<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <title> BlogCat Travel->更新</title>
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
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
   <div class="page_container"> 
    <h3>Travel Cat 更新</h3>
    
    <p style="color: red;">${errorString}</p>
    
    <form method="POST" action="editBlog">
       <table border="0">
          <tr>
             <td>場所名</td>
             <td>
             <input type="text" name="name" value="${location.name}" />
             <input  name="local_ID" value="${location.local_ID}" type="hidden" />
             </td>
             
          </tr>
          <tr>
             <td>詳細</td>
             <td><textarea rows="20" cols="50" name="content">${location.content}</textarea></td>
          </tr>
          <tr>
             <td>アドレス</td>
             <td><input type="text" name="address" value="${location.address}" /></td>
          </tr>
           <tr>
             <td>駅</td>
             <td><input type="text" name="station" value="${location.station}" /></td>
          </tr>
          <tr>
             <td colspan="2">                  
                 <input type="submit" value="登録する" />
                 <a href="travel">戻す</a>
             </td>
          </tr>
       </table>
    </form>
    </div>
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>