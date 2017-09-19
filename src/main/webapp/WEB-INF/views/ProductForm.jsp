<%@include file="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<div class="container">
		<div class="row">
			<div class="form-horizontal">
				
				<form:form action="${pageContext.request.contextPath}/admin/product/addNewProduct" commandName="product" >



					<div class="form-group">
						<label class="col-md-4 control-label" for="productName">Product Name</label>
						<div class="col-md-6">
							<form:input path="productName" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="productPrice">Price</label>
						<div class="col-md-6">
							<form:input path="productPrice" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="productQuantity">Quantity</label>
						<div class="col-md-6">
							<form:input path="productQuantity" class="form-control" />
						</div>
						
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="productDescription">Description</label>
						<div class="col-md-6">
							<form:input path="productDescription" class="form-control" />
						</div>
					</div>

					
					<div class="form-group">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<div class="col-md-4">
							<button  id="submit" name="submit" class="btn btn-primary">Add Product</button>
						</div>
						</div>						
							
				</form:form>
			</div>
		</div>
	</div>
	<%@include file="Footer.jsp" %>