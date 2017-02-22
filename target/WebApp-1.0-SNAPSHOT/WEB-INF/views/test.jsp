<%-- 
    Document   : test
    Created on : 22/02/2017, 10:29:40 AM
    Author     : bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
			${param.nombre}
		</h1>
		<h1>
			<%
				out.print(request.getAttribute("nombre"));
			%>
		</h1>
    </body>
</html>
