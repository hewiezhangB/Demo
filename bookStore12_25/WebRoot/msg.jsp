<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
  <head>
    <title>信息提示</title>
  </head>
  
  <body>
  	<div align="center" style="font-size: 18px; margin-top: 200px">
  		<%=request.getAttribute("msg")%>
  		<hr style="">
  		<a  href="<%=request.getContextPath()%>/<%=request.getAttribute("returnPath")%>" style="color: red">返回</a>
  	</div>
  </body>
</html>
