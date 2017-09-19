<%@ include file="Header.jsp" %>
<div class="container">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
	  <li data-target="#myCarousel" data-slide-to="3"></li>
	  <li data-target="#myCarousel" data-slide-to="4"></li>
	  
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

<div class="item active">
        <img src="resources/images/AllGad.jpg" style="width:100%;">
        <div class="carousel-caption">
          <h2>Coming Soon</h2>
          <p> New In Town</p>
        </div>
      </div>
      
      
      <div class="item ">
        <img src="resources/images/flyingfashion1.png" style="width:100%;">
        <div class="carousel-caption">
          <h3>New Arrivals</h3>
          <p>Hurry Up !</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/images/CamO.jpg" style="width:100%;">
        <div class="carousel-caption">
          <p>New Tech Viral Products!</p>
        </div>
      </div>
      
      
       <div class="item">
        <img src="resources/images/qq.jpg" style="width:100%;">
        <div class="carousel-caption">
          <p>We Wear Culture!</p>
          <h3> All New </h3> 
        </div>
      </div>
    
      <div class="item">
        <img src="resources/images/AllGad2.png" width:100%;" height="80%;">
        <div class="carousel-caption">
          <h2>Coming Soon</h2>
          <p>Stay Tuned</p>
        </div>
      </div>
	  
	  
      <div class="item">
        <img src="resources/images/AllGad.jpg" style="width:100%;">
        <div class="carousel-caption">
          <h2>Coming Soon</h2>
          <p> New In Town</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<div class="container text-center">
  <h3>eCart</h3>
  <p><em>eCart is an electronic commerce company headquartered in Bangalore, Karnataka0 It was founded in October 2007 by Sachin Bansal and Binny Bansal (no relation).
  </em></p>
  <p>eCart has launched its own product range under the name "DigiFlip" with products including tablets, USBs, and Appliances.</p>
</div>



<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">LIMITED OFFER</div>
        <div class="panel-body"><img src="resources/images/50mobiles.jpg" class="img-responsive" style="width:50%" alt="Image"></div>
        <div class="panel-footer">Buy PRODUCTS worth 20,000 get a gift card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading">Watch this DEAL</div>
        <div class="panel-body"><img src="resources/images/watches2.jpg" class="img-responsive" style="width:150%" alt="Image"></div>
        <div class="panel-footer">New in Watches</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-success">
        <div class="panel-heading">Weekend DEALS</div>
        <div class="panel-body"><img src="/resources/images/shoes2.png" class="img-responsive" style="width:100%" alt="Image"/></div>
        <div class="panel-footer"> New In Footwears</div>
      </div>
    </div>
  </div>
</div><br>
<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="resources/images/watches1.jpg" class="img-responsive" style="width:110%" alt="Image"></div>
        <div class="panel-footer">Get Merchandise 50%off</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading">Electronic DEAL</div>
        <div class="panel-body"><img src="resources/giftcard2.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Get a Gift Card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-success">
        <div class="panel-heading"> DEAL</div>
        <div class="panel-body"><img src="resources/images/giftcard4.png" class="img-responsive" style="width:70%" alt="Image"></div>
        <div class="panel-footer">Shopping worth rs.3000 get a gift card</div>
      </div>
    </div>
  </div>
</div><br><br>

<!-- Add Google Maps -->
<div id="googleMap"></div>
<script>
function myMap() {
var myCenter = new google.maps.LatLng(41.878114, -87.629798);
var mapProp = {center:myCenter, zoom:12, scrollwheel:false, draggable:false, mapTypeId:google.maps.MapTypeId.ROADMAP};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
var marker = new google.maps.Marker({position:myCenter});
marker.setMap(map);
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>


<%@ include file="Footer.jsp" %>