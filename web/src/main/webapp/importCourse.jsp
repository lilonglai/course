<%@page import="com.kevin.aeas.excel.ReadStudentCourse"%>
<%@page import="java.io.FileOutputStream"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<% 
    //String serverName = request.getServerName();
    //String realPath = request.getRealPath(serverName);
    String tempPath = "c:/btm/aeas" + "/" + "input";
    String contentType = request.getContentType();
    String boundary=null;
    String endBoundary = null;
    String encoding = request.getCharacterEncoding();
    System.out.println(encoding);
    if(contentType.indexOf("multipart/form-data") >= 0){
    	int index = contentType.indexOf("boundary=");
    	boundary = "--" + contentType.substring(index+9);
    	endBoundary = boundary + "--";
    }
    
    ServletInputStream input = request.getInputStream();
    
    byte[] buf = new byte[64*1024];
    int pos =0;
    String strBuf=null;
    String filename = null;
    String componentName;
    while ((pos = input.readLine(buf, 0, buf.length)) !=-1){
    	
    	strBuf = new String(buf, 0, pos);    	
    	if(strBuf.startsWith(boundary)){
    		System.out.println("begin");
    	}
    	
    	pos = input.readLine(buf, 0, buf.length);
    	strBuf = new String(buf, 0, pos, "UTF-8");
    	if(strBuf.indexOf("name") != -1){
    		int beginIndex = strBuf.indexOf("name") + 6;
    		int endIndex =strBuf.indexOf("\"", beginIndex);
    		componentName = strBuf.substring(beginIndex, endIndex);
    		System.out.println(componentName);
    	}
    	if(strBuf.indexOf("filename") != -1){
    		int beginIndex = strBuf.indexOf("filename") + 10;
    		int endIndex =strBuf.indexOf("\"", beginIndex);
    		filename = strBuf.substring(beginIndex, endIndex);
    		System.out.println(filename);
    	}
    	
    	FileOutputStream outputStream =new FileOutputStream(tempPath + "/" + filename);
    	
    	//content type
    	pos = input.readLine(buf, 0, buf.length);
    	strBuf = new String(buf, 0, pos);
    	System.out.print(strBuf);
    	
    	///r/n
    	pos = input.readLine(buf, 0, buf.length);
    	strBuf = new String(buf, 0, pos);
    	
    	while ((pos = input.readLine(buf, 0, buf.length)) !=-1){
    		strBuf = new String(buf, 0, pos);
        	if(strBuf.startsWith(endBoundary)){
        		System.out.println("end");
        		outputStream.close();
        		break;
        	}
        	
        	outputStream.write(buf, 0, pos);
        	//System.out.print(strBuf);

    	}
    	
    	ReadStudentCourse readStudentCourse = new ReadStudentCourse(tempPath + "/" + filename);
    	readStudentCourse.importCourse();
    	
    	response.sendRedirect("student.jsp");
    }
%>
</body>
</html>