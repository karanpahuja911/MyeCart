<%@ include file="Header.jsp" %>

<div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup"><font face="Kristen ITC" size="3" color="RoyalBlue">Sign Up </font></a></li>
               <li class="tab"><a href="#login"><font face="Kristen ITC" size="3" color="RoyalBlue">Log In </font></a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1><font face="Segoe Print" size="5" color="RoyalBlue">Sign Up for Free</font></h1>
           
          <form:form action="/" method="post">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
               <font face="Segoe Print" size="6" color="Coral"> First Name</font><span class="req">*</span>
              </label>
              <textarea rows="1" maxlength="20">
             
	</textarea>
            </div>
        
            <div class="field-wrap">
              <label>
	<font face="Segoe Print" size="5" color="Coral"> Last Name </font><span class="req">*</span>
              </label>
          <textarea rows="1" maxlength="20">
             
	</textarea>
            </div>
          </div>

          <div class="field-wrap">
            <label>
           <font face="Segoe Print" size="5" color="Coral">
              Email Address</font><span class="req">*</span>
            </label>
 <textarea rows="1" maxlength="28">
             
	</textarea>
</div>
          
          <div class="field-wrap">
            <label>
            <font face="Segoe Print" size="5" color="Coral">
              Set A Password</font><span class="req">*</span>
            </label>
 <textarea rows="1" maxlength="20">
             
	</textarea>          
	</div>
          
          <button type="submit" class="button button-block"/><font face="chiller" size="7" color="RoyalBlue">Get Started</font></button>
          
          </form:form>

        </div>
        
        <div id="login">   
          <h1><font face="Segoe Print">Welcome Back!</font></h1>
          
          <form action="/" method="post">
          
            <div class="field-wrap">
            <label>
            <font face="Segoe Print" size="5" color="Coral">
              Email Address</font><span class="req">*</span>
            </label>
     <textarea rows="1" maxlength="28">
             
	</textarea>
	</div>
          
          <div class="field-wrap">
            <label>
            <font face="Segoe Print" size="5" color="Coral">
              Password</font><span class="req">*</span>
            </label>
 <textarea rows="1" maxlength="20">
             
	</textarea> </div>
          
          <p class="forgot"><a href="#"> <font face="Segoe Print" size="7" color="Coral">Forgot Password? </font></a></p>
          
          <button class="button button-block"/> <font face="Segoe Print" size="7" color="RoyalBlue">Log In</font></button>
          
          </form>

        </div>
        </div>
      </div>
      <%@ include file="Footer.jsp" %>