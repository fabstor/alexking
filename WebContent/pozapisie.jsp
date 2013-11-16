<%--
    Document   : index
    Created on : 2011-01-03, 23:46:29
    Author     : Aleksander
--%>

<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="java.lang.*"%>
<%--@ page import="javax.servlet.http.HttpServletRequest" --%>
<%@ page language="java" import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%	
	final String driver = "oracle.jdbc.driver.OracleDriver";
	final String password = "userir";
	final String dbname = "XE";
	final String username = "userir";

	String imie_aaa;
	imie_aaa = request.getParameter("addimie");

	Connection connection = null;

	try {

		Class.forName(driver);

	} catch (ClassNotFoundException e) {

		System.out.println("JDBC Driver ne marche pas");
		e.printStackTrace();
		return;

	}

	try {

		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:" + dbname, username,
				password);

	} catch (SQLException e) {

		System.out.println("Connection Failed");
		e.printStackTrace();
		return;

	}

	Statement st;
	try {
		st = connection.createStatement();
		st.executeUpdate("INSERT INTO test " + "VALUES ('" + imie_aaa + "')");	//CREATE TABLE test (test1 varchar(50));
	} catch (SQLException e) {
		e.printStackTrace();
	}
%>


<%
	session.setAttribute("poleSesji1", imie_aaa);
%>
