<! DOCTYPE HTML>
<html>
	<head>
		<title> Access Removal System </title>
	<style type='text/css'>
		body{
		background-color:white
		}
		</style>
	</head>
	<body>
		<%@include file = "Header.jsp" %>
		<center>
			<div id="search" style="text-align: right; margin-bottom:5em;">
				<a class="one" href="http://finder.canlab.ibm.com:9080/vivisimo/cgi-bin/query-meta?v%3Asources=DB2CQ&v%3Aproject=wellspring&query=">Still have some work on wellspring? Go to wellspring search</a>
			</div>
			<div><h3>Please Login with your IBM credentials<h3></div>
			<form action="LoginServlet" method="POST">
				<div id="sudeep" style="margin-top:1em">
					<label style="display: inline-block; width: 130px; text-align:right;margin-top:1em"><b>IBM Intranet ID:</b></label>
						<input type="email" name="IBM Intranet ID" autofocus required><br>
					<label style="display: inline-block; width:130px; text-align:right;margin-top:1em"><b>Password:</b></label>     
						<input type="password" name="Password" required>
				</div>
				<div style="margin-top:2em; width:270px ">
				<button style="float:left; width:100" type="submit" >Submit</button>
				<button style="float:right; width:130" type="submit">Forgot Password</button>
				</div>
			</form>
		</center>

	</body>
</html>
