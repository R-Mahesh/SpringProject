<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<body>
LogedIn Successfully
Hi Welcome
<a href="logout" class="btn btn-danger"role="button">logout</a>
<center>


 <form action="upload" method="post" enctype="multipart/form-data">
File Name: <input type="text" name="name" class="form-control" style="width:22%"/> <br/>
Select File:<input type="file" name="file"  class="btn btn-default"/><br/>  
<input type="submit" class="btn btn-danger" value="Submit"  style="width:10%" />
</form>  
</center>
 <div style="color: red">
         <%
         
	String fileNamejsp = (String) pageContext.findAttribute("fileName");
         if(fileNamejsp!=null){
String rootPath = "C:\\Users\\E Ravi\\Desktop\\eclipse work place\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\CrudTest\\resources\\images\\"+fileNamejsp+".txt";
          
            FileInputStream fileinputstream = new FileInputStream(rootPath);

            int numberBytes = fileinputstream.available();
            byte bytearray[] = new byte[numberBytes];

            fileinputstream.read(bytearray);
           String Storee="";
            for(int i = 0; i < numberBytes; i++){
                out.println((char)bytearray[i]);
                Storee += new StringBuffer().append("").append((char)bytearray[i]).toString();
            }
         //   StringTokenizer st = new StringTokenizer(Storee,"\n");
          //  while (st.hasMoreTokens()) {  
          //      out.println(st.nextToken());  
          //  }  
          String reverse = new StringBuffer(Storee).reverse().toString();
          out.println(reverse);
             //String textStr[] = Storee.split("\\n");
             
            // for(String w:textStr){  
            //	 out.println(w);  
            //	 }  
            fileinputstream.close(); 
         }
        %>
        
</div>


</body>
</html>