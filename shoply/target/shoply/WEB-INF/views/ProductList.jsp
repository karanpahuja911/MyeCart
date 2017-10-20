<%@ include file="Header.jsp" %>


<div class="text-center" style="color:black;"><h3><b>LIST OF PRODUCTS</b></h3>
</div>
<table class="table table-striped">

<thead>
<tr>
<th></th>
<th>Product Name</th>
<th>Price</th>
<th>Description</th>
<th>Quantity</th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>

<tbody>
<c:forEach items="${product}" var="p" >
<tr> 
<td> <img src="<c:url value="/resources/images/${p.productId}.jpg" />" alt="image" style="width:100px; height:100px;"/></td>
 
<td>${p.productName}</td>
<td>${p.productPrice}</td>
<td>${p.productDescription }</td>
<td>${p.productQuantity }</td>
<td>
<c:url var="url" value="/all/product/viewproduct/${p.productId }"></c:url>					
<a href="${url }"><span class="glyphicon glyphicon-info-sign"></span></a></td>
 <c:if test="${pageContext.request.userPrincipal.name == 'admin'}"> 
<td>
<c:url var="url" value="/admin/product/deleteproduct/${p.productId}"></c:url>					
<a href="${url }"><span class="glyphicon glyphicon-remove"></span></a></td>

<td>
<c:url var="url" value="/editform/${p.productId}"></c:url>					
<a href="${url }"><span class="glyphicon glyphicon-pencil"></span></a></td>
</c:if>

</tr>
</c:forEach>
</tbody>
</table

>

<%@ include file="Footer.jsp" %>