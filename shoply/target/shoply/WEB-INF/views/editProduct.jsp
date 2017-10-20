<%@include file="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<div class="container">
		<div class="row">
			<div class="form-horizontal">
				
				<form:form action="${pageContext.request.contextPath}/editProduct/${productId}" commandName="product1" 
				enctype="multipart/form-data">



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
						<label class="col-md-4 control-label" for="image">Upload Image</label>
						<div class="col-md-6">
							<form:input path="image" type="file" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<div class="col-md-4">
							<button  id="submit" name="submit" class="btn btn-primary">Edit Product</button>
						</div>
						</div>						
							
				</form:form>
			</div>
		</div>
	</div>
	<%@include file="Footer.jsp" %>