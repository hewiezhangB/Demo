<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
<head>
<title>后台管理员登陆--云工厂</title>
<link rel="stylesheet" href="<%=path%>/admin/resources/css/reset.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="<%=path%>/admin/resources/css/style.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="<%=path%>/admin/resources/css/invalid.css"
	type="text/css" media="screen" />
</head>
<body id="login">
	<div id="login-wrapper" class="png_bg" align="center">
		<div id="login-top">
			<h1>管理员登陆</h1>
			<a href=""><img id="logo"
				src="<%=path%>/admin/resources/images/logo.png"
				alt="Simpla Admin logo" /> </a>
		</div>
		<div id="login-content">
			<form action="<%=path%>/SysAdminLoginServlet" method="post">
				<div class="notification" align="center">
					<div>云起点网上书城后台登陆</div>
				</div>
				<p>
					<label>用户名：</label> <input name="name" class="text-input"
						type="text" />
				</p>
				<div class="clear"></div>
				<p>
					<label>密码：</label> <input name="pwd" class="text-input"
						type="password" />
				</p>
				<div class="clear"></div>
				<p id="remember-password">
					<input type="checkbox" /> 记住密码
				</p>
				<%
					if(request.getAttribute("message") != null){%>
					<p align="center">
					<font color="red">用户名或密码错误！</font>
					</p>	
				<%}%>
				<div class="clear"></div>
				<p>
					<input class="button" type="submit" value="管理员登陆" />
				</p>
			</form>
		</div>
		<!-- End #login-content -->
	</div>
	<!-- End #login-wrapper -->
</body>
</html>
