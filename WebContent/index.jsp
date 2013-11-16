<%@page import="beans.Album"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>AlexanderIsNotAKing</title>
<%-- ********** HEADER CONTENT ********** --%>
<%@ include file="globalHeadContent.jsp"%>
</head>
<body align=center>

	<%-- ********** NAVBAR ********** --%>
	<%@ include file="header.jsp"%>

	<%-- ********** WHOLE PAGE ********** --%>
	<div align=center>

		<%-- ********** CONNEXION PART ********** --%>
		<%
			if (null == session.getAttribute("idUser")) {
		%>
		<form class="form-inline" method="post" action="">
			<input type="text" class="input-small" placeholder="Email"> <input
				type="password" class="input-small" placeholder="Password">
			<button type="submit" class="btn">Sign in</button>
			<button class="btn btn-small btn-primary" type="button">Signin</button>
		</form>
		<%
			} else {
				// User IS logged in.  
			}
		%>


		<%-- ********** DROPAREA ********** --%>
		<%@ include file="UploadFile.jsp"%>
		<div id="droparea" align=center style="vertical-align: middle">
			<form action="" method="post" enctype="multipart/form-data">
				<input type="file" name="file" size="50" class="btn" /> <br /> <input
					type="submit" class="btn" value="Upload File" />
			</form>
		</div>

		<%-- ********** MY PICTURES ********** --%>
		<br> My pictures
		<div class="row" style="margin: 0 auto;">
			<div class="span4">
				<div style="align: center;">
					<img src="img/dupa.jpg" class="img-polaroid">
				</div>
				test
			</div>
			<div class="span4">
				<div style="align: center;">
					<img src="img/dupaa.jpg" class="img-polaroid">
				</div>
				test
			</div>
		</div>

		<%-- ********** SHARED ALBUMS ********** --%>
		<a href="#">Shared Albums</a>
		<div class="row" style="margin: 0 auto;">
			<%/*
				//ArrayList<Album> list = Album.getThreeLast(); // cette method deja pas existe !!!
				for (Album album : list) {
					out.println("<a class=\"span4\" href=\"#\">");
					out.println("<div style=\"align: center;\">");
					out.println("<img src=\"img/dupa.jpg\" class=\"img-polaroid\">");
					out.println("</div>" + album.getTitle());
					out.println("</a> <a class=\"span4\" href=\"#\">");
				}*/
			%>
			<a class="span4" href="#">
				<div style="align: center;">
					<img src="img/dupa.jpg" class="img-polaroid">
				</div> test
			</a> <a class="span4" href="#">
				<div style="align: center;">
					<img src="img/dupaa.jpg" class="img-polaroid">
				</div> test
			</a>
		</div>

		<%-- ********** SHARED BOOKS ********** --%>
		<a href="#">Shared books</a>
		<div class="row" style="margin: 0 auto;">
			<a class="span4" href="#">
				<div style="align: center;">
					<img src="img/dupa.jpg" class="img-polaroid">
				</div> test
			</a> <a class="span4" href="#">
				<div style="align: center;">
					<img src="img/dupaa.jpg" class="img-polaroid">
				</div> test
			</a>
		</div>


	</div>
</body>
</html>