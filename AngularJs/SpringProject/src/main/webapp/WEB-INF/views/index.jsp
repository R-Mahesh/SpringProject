<%@include file="./header.jsp" %>
<c:if test="${userPage}">
<%@include file="user.jsp" %>
</c:if>
<c:if test="${homePage}">
<%@include file="home.jsp"%>

</c:if>
<c:if test="${successPage}">
<%@include file="success.jsp"%>

</c:if>
<c:if test="${productPage}">
<%@include file="products.jsp" %>
</c:if>

<c:if test="${registerPage}">
<%@include file="register.jsp" %>
</c:if>
<c:if test="${AdminPage}">
<%@include file="Admin.jsp" %>
</c:if>
<c:if test="${loginPage}">
<%@include file="login.jsp" %>
</c:if>


  <c:if test="${productDisplay}">
<%@include file="products.jsp" %>
</c:if>
<c:if test="${productsForm}">
<%@include file="productsForm.jsp" %>
</c:if>
<c:if test="${categoryPage}">
<%@include file="category.jsp" %>
</c:if>
<%@include file="./footer.jsp" %>