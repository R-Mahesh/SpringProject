<%@include file="./header.jsp" %>
<c:if test="${homePage}">
<%@include file="home.jsp"%>
</c:if>
<c:if test="${registerPage}">
<%@include file="register.jsp" %>
</c:if>
<c:if test="${loginPage}">
<%@include file="login.jsp" %>
</c:if>
<c:if test="${userPage}">
<%@include file="user.jsp" %>
</c:if>
 <%-- <c:if test="${WaterHeater}">
<%@include file="WaterHeater.jsp" %>
</c:if>
  --%>
  <c:if test="${productDisplay}">
<%@include file="productDisplay.jsp" %>
</c:if>

<%@include file="./footer.jsp" %>