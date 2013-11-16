<%@page import="java.sql.Timestamp"%>
<%@ page import="java.io.*"%>
<%@page import="beans.Photo"%>
<%@page import="javaxt.io.*"%>
<%
	String tomcatDirectory = "C:/tomcat/apache-tomcat-7.0.47/webapps/data/";

	//to get the content type information from JSP Request Header
	String contentType = request.getContentType();
	//here we are checking the content type is not equal to Null and as well as the passed data from mulitpart/form-data is greater than or equal to 0
	if ((contentType != null)
			&& (contentType.indexOf("multipart/form-data") >= 0)) {
		DataInputStream in = new DataInputStream(
				request.getInputStream());
		//we are taking the length of Content type data
		int formDataLength = request.getContentLength();
		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		//this loop converting the uploaded file into byte code
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead,
					formDataLength);
			totalBytesRead += byteRead;
		}

		String file = new String(dataBytes);
		//for saving the file name
		String saveFile = file
				.substring(file.indexOf("filename=\"") + 10);
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
				saveFile.indexOf("\""));
		int lastIndex = contentType.lastIndexOf("=");
		String boundary = contentType.substring(lastIndex + 1,
				contentType.length());
		int pos;
		//extracting the index of file 
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes()).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
		// creating a new file with the same name and writing the content in new file

		String[] extension = saveFile.split("\\.(?=[^\\.]+$)");
		System.out.println(""+extension.length);
		if (extension!= null && extension.length == 2 && extension[1].contains("gif") || extension[1].contains("png")
				|| extension[1].contains("jpeg") || extension[1].contains("bmp") || extension[1].contains("jpg")) {

			FileOutputStream fileOut = new FileOutputStream(
					tomcatDirectory + saveFile);
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			
			Image image = new javaxt.io.Image(tomcatDirectory + saveFile);
			java.util.HashMap<Integer, Object> exif = image.getExifTags();
			
			
			System.out.println("Camera: " + exif.get(0x0110));	
			System.out.println("Ouverture: " + exif.get(0x9202));
			System.out.println("ISO: " + exif.get(0x8827));
			System.out.println("Vitesse d'obturation: " + exif.get(0x9201));
			System.out.println("Distance focale: " + exif.get(0x920A));
			System.out.println("Resolution: " + image.getWidth()+"x"+image.getHeight());
			
			java.util.Date date= new java.util.Date(); //TODO : comment gérer les id !
			Photo photo = new Photo(7, 1, tomcatDirectory + saveFile, exif.get(0x0110).toString(),
					exif.get(0x9202).toString(), exif.get(0x920A).toString(), exif.get(0x8827).toString(),
					exif.get(0x9201).toString(), image.getWidth()+"x"+image.getHeight(), new Timestamp(date.getTime()));
			
			photo.add();
			%><Br>
			<div class="alert alert-success">
				<b>You have successfully upload the file by the name of:</b>
				<%
					out.println(saveFile);
				%></td>
			</div>
			<%
		}
		else{
			%><Br>
			<div class="alert alert-danger">
				<b>The file you just sent was not a picture (png/jpeg/gif/bmp)</b>
			</div>
			<%
		}

	}
%>