<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加新课程</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript">
    function checkForm(){
    	var name = document.forms[0].name.value;
    	if(name.length == 0){
    		alert("学生名字不能为空")
    		return false;
    		}
    	var grade =document.forms[0].grade.value;
    	if(grade.length ==0){
    		alert("请选择一个年级")
    		return false;
    	}
    	
    	return true;
    }
</script>
</head>
<body>
	<%
        String idStr = request.getParameter("id");
        int grade = Integer.valueOf(idStr);
	%>
  <div class="container" >
	<form action="firstCourseServlet?action=add" role="form" method="get" onSubmit="return checkForm();">
	    <div class="form-group">
	              年级:
	    	 <input type="radio" name="grade" value = "1" <%= grade==1?"checked":"" %> > 4-6
             <input type="radio" name="grade" value = "2" <%= grade==2?"checked":"" %> > 7-9
             <input type="radio" name="grade" value = "3" <%= grade==3?"checked":"" %> > 10-12
        </div>
        <div class="form-group">
          <label for="name" class="col-sm-2 control-label">课程名称:</label>
          <div class="col-sm-10">
		    <input type="text" class="form-control" name="name" id="name"/>
		  </div>
		</div>
		<div class="form-group">
		  <label for="shortName" class="col-sm-2 control-label">课程简称:</label>
		  <div class="col-sm-10">
		    <input type="text" class="form-control" name="shortName" id="shortName"/>
		  </div>
		</div>
		<div class="form-group">
		  <label for="description" class="col-sm-2 control-label">课程描述:</label>
		  <div class="col-sm-10">
		    <textarea class="form-control" rows="4" cols="25" name="description" id="description"> </textarea>
		  </div>		
		</div>
		<div class="form-group">
		<input type="submit" class="btn btn-default" value="提交" />
		</div>
	</form>
     <% 
		}
     %>
  </div>
</body>
</html>