<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina di Login con Struts2</title>
</head>
<body>
<s:actionerror/>
<s:form action="login.action" method="get">
	<s:textfield name="username" size="20" label="User"></s:textfield><br>
	<s:password name="password" size="20" label="Password"></s:password>
	<s:submit method="execute" label="Invia"></s:submit>
</s:form>

</body>
</html>