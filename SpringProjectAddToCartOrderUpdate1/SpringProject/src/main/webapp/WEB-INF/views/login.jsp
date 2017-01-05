<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div style="text-align: center; padding: 30px;border: 1px solid green;width: 500px;">
	<form method="post" action="login">
		<table>
		 <tr>
                     <td colspan="2" style="color: red">${message}</td>
                  </tr>
		
			<tr>

				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>PassWord</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>