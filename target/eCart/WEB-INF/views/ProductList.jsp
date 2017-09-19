<%@ include file="Header.jsp" %>


<div class="text-center" style="color:black;"><h3><b>LIST OF PRODUCTS</b></h3>
</div>
<table class="table table-striped">

<thead>
<tr><th>Product ID</th>
<th>Product Name</th>
<th>Price</th>
<th>Description</th>
<th>Category</th>
<th>Quantity</th>
</tr>
</thead>

<tbody>
<c:forEach items="${product}" var="p" >
<tr> 
<td>${p.productId}</td>
<td>${p.productName}</td>
<td>${p.productPrice}</td>
<td>${p.productDescription }</td>
<td>${p.productCategory}</td>
<td>${p.productQuantity }</td>
<td>
<c:url var="url" value="/all/product/viewproduct/${p.productId }"></c:url>					
<a href="${url }"><span class="glyphicon glyphicon-info-sign"></span></a></td>

<%-- <td>${p.category.categoryName}</td> --%>
<%-- <td>${p.productQuantity}</td> --%>
</tr>
</c:forEach>
</tbody>
</table>

<%@ include file="Footer.jsp" %>