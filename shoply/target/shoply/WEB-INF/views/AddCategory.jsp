<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<div class="container">
		<div class="row">
			<div class="form-horizontal">
				
				<form:form action="${pageContext.request.contextPath}/admin/addNewCategory" commandName="category" method="post" >

					<%-- <div class="form-group">
						<label class="col-md-4 control-label" for="pid">PID</label>
						<div class="col-md-6">
							<form:input path="pid" class="form-control" />
						</div>
					</div> --%>

					<div class="form-group">
						<label class="col-md-4 control-label" for="categoryName">Category Name</label>
						<div class="col-md-6">
							<form:input path="categoryName" class="form-control" />
						</div>
					</div>	
					<div class="form-group">
						<label class="col-md-4 control-label" for="categoryType">Category Type</label>
						<div class="col-md-6">
							<form:input path="categoryType" class="form-control" />
						</div>
					</div>		
					<div class="form-group">
						<label class="col-md-4 control-label" for="categoryDescription">Category Description</label>
						<div class="col-md-6">
							<form:input path="categoryDescription" class="form-control" />
						</div>
					</div>						
							
			<div class="form-group">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<div class="col-md-4">
							<button  id="submit" name="submit" class="btn btn-primary">Add Category</button>
						</div>
						</div>						
							
				</form:form>
			</div>
		</div>
	</div>
	<%@include file="Footer.jsp" %>