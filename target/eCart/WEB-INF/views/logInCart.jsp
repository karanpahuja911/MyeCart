<%@ include file="Header.jsp"%>
<style>
form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 10px 18px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: red;
	padding: 12px 18px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 6px 13px;
	background-color: Tomato;
}

.imgcontainer {
	text-align: center;
	margin: 6px 0 6px 0;
}

img.avatar {
	width: 15%;
	border-radius: 30%;
}

.container {
	padding: 4px;
}

span.psw {
	float: right;
	padding-top: 1px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 150px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>

<h3>Login In Here</h3>

<div class="imgcontainer">
	<img src="<c:url value="/resources/images/avatars1.gif"/>" alt="Avatar"
		class="avatar">
</div>

<!--j_spring_security_check"-->
<div class="container">
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<form name="loginForm"
		action="<c:url value="/j_spring_security_check"/>" method="post">

		<label><b>username</b></label> <input type="text"
			placeholder="Enter Username" name="form-username" required> <label><b>Password</b></label>
		<input type="password" placeholder="Enter Password"
			name="form-password" required>

		<button type="submit">
			<b>Login </b>
		</button>

	</form>
	<input type="checkbox" checked="checked"> Remember me


	<div class="container" style="background-color: #f1f1f1">
		<button type="button" class="cancelbtn">Cancel</button>
		<span class="psw">Forgot <a href="#">password?</a></span>
	</div>
</div>
<%@ include file="Footer.jsp"%>