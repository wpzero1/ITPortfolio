<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%> 
<%@page import="java.util.Enumeration"%> 
<%@page import="com.oreilly.servlet.*"%> 
<%@page import="com.oreilly.servlet.multipart.*"%>

<% 
 request.setCharacterEncoding("utf-8");
    //String dir = request.getRealPath("/upload"); //실제 시스템 상의 경로를 얻어온다.
    String dir = application.getRealPath("/upload");
    out.println("경로:"+dir +"<br>");
   
    int max =10*1024*1024; // 업로드 파일의 최대 크기 지정 
   
    String filename1=""; 
    
     
    try{ 
        /* 실제 파일 업로드 담당. 
        인수 1) 폼에서 가져온 인자 값을 얻어오기 위해 request객체를 전달 
        인수 2) 업로드될 파일의 위치를 의미 
        인수 3) 최대 크기 
        인수 4) 파일 이름의 한글일 경우 문제가 되므로 처리할수 있도록 인코딩 타입지정. 
        인수 5) 인자는 똑같은 파일을 업로드할 경우 중복되지 않도록 자동으로 파일이름을 변환해주는 기능을 한다.(DefaultFileRenamePolicy)        */ 
       MultipartRequest m = new MultipartRequest(request, dir, max, "utf-8", new DefaultFileRenamePolicy()); 
         
        /*request객체의 getparameter메소드를 이용 폼에서 입력된 값을 받아온다.*/ 
     
     
     
         
        //업로드한 파일들을 Enumeration타입으로 반환한다. 
        Enumeration files=m.getFileNames();         
        String file1 =(String)files.nextElement(); 
        filename1=m.getFilesystemName(file1); //저장될 이름이다.
        out.println(filename1+"<br>");
       
        
        
        String ofile1 =  m.getOriginalFileName("file1"); //원본파일 이름이다.
        out.println(ofile1+"<br>");
      
        
    }catch(Exception e){ 
        e.printStackTrace(new PrintWriter(out)); 
    } 
%>
