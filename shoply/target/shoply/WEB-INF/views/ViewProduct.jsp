

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="Header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product:</p>
        </div>

        <div class="container" ng-app = "cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${pd.productId}.jpg" />" alt="image" style="width:100%"/>
                </div>
                <div class="col-md-5">
                    <h3>${pd. productName }</h3>
                    <p><strong>Price</strong>: ${pd.productPrice}</p>
                    <p><strong>Quantity</strong>: ${pd.productQuantity}</p>
                  

                    <br/>

                  

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value = "${url}" />" class="btn btn-default">Back</a>
                        <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${pd.productId}')"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                        <a href="<spring:url value="/customer/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                   	</c:if>
                    </p>

                </div>
            </div>
        </div>
        </div>
        </div>
<script src="<c:url value="/resources/js/Controller.js" /> "></script>

<%@ include file="Footer.jsp" %>



