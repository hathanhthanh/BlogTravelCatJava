<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <meta content="initial-scale=1" name="viewport" />
    <meta name="description" />
    <meta name="keywords" /> 
    <link href="${pageContext.request.contextPath}/resources/css/login.css"
	rel="stylesheet">
    <title>Login</title>
</head>
<body>
    <div id="mysite_login">
        <div id="blur-layer"><p style="color: red">${errorString}</p></div> 
        <div class="vhr_mysite_login_container col-lg-3 col-md-4 col-sm-6 col-xs-11">
            <form action="login" role="form" class="oe_login_form" method="POST">
                <div class="form-group field-login">
                    <input name="userName" value= "${user.userName}" placeholder="Account ..." autocorrect="off" required="required" id="login" autocomplete="off" autofocus="autofocus" type="text" class="form-control" />
                </div>
                <div class="form-group field-password">
                    <input name="password" value= "${user.password}" placeholder="Password ..." required="required" id="password" type="password" class="form-control" />
                </div>
                
                <div class="clearfix oe_login_buttons">
                    <button type="submit" class="btn btn-primary">Log in</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>