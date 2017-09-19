
 <%@include file="Header.jsp" %>
<c:if test="${not empty error }">
<div class="error">${error }
</div>
</c:if>
<h3>PRODUCT INFO</h3>
<table>
<tr><td>PRODUCT NAME</td><td> ${pd. productName }</td></tr>
<tr><td>PRODUCT PRICE</td><td> ${pd.productPrice }</td></tr>
<tr><td>Quantity</td><td>${pd.productQuantity }</td></tr>
</table>

<c:url value="/getAllProduct" var="urll"></c:url>
<a href="${urll }">Back To Product</a><br>

<%@include file="Footer.jsp" %>


