
<%@ include file="Header.jsp" %>
<%@ page isELIgnored="false" %>


<body>

<table border="0px" align="center">
		<tr>
			<th>Enter your Supplier Details</th>

		</tr>

	</table>

	<div class="container wrapper">
		<div class="container">

		
			<form:form action="${pageContext.request.contextPath}/admin/supplier/savesupplier" modelAttribute="supplier" method="post"
				enctype="multipart/form-data">


				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="SupplierName">Supplier name</label>
						</div>
						<div class="col-sm-8">
							<form:input path="SupplierName" class="form-control"
								placeholder="Supplier Name"></form:input>
						</div>
						

					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="SupplierAddress">Supplier Address</label>
						</div>
						<div class="col-sm-8">
							<form:input path="SupplierAddress" class="form-control"
								placeholder="Supplier Address"></form:input>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label for="SupplierContact">Contact No.</label>
						</div>
						<div class="col-sm-8">
							<form:input path="SupplierContact" class="form-control"
								placeholder="SupplierContact"></form:input>
						</div>
					</div>
				</div>
				<div class="button">
				<input class="btn btn-primary" type="submit"
					value="Add supplier">
				</div>
				</form:form>
				</div>
				</div>
<br>
<br>				
<%@ include file="Footer.jsp" %>