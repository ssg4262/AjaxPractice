<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Ajax 회원정보 폼</title>
<script type="text/javascript">

var request = new XMLHttpRequest();
	function searchFunction(){
		request.open("Post","./UserSearchServlet?userName=" + encodeURIComponent(document.getElementById("userName").value),true);
		request.onreadystatechange = searchProcess;
		request.send(null);
	}
	function searchProcess(){
		var table = document.getElementById("ajaxTable");
		table.innerHTML ="";
		if(request.readyState == 4 && request.status == 200){
			var object = eval('(' + request.responseText + ')');
			var result = object.result;
			for(var i =0; i < result.length;i++){
				var row= table.insertRow(0);
				for(var j = 0; j< result[i].length;j++){
					var cell = row.insertCell(j);
				cell.innerHTML= result[i][j].value;
				}
				
			
			}
		
			
				
		
		}
		window.onload = function(){
			serchFunction();
			
		}
		
	}


</script>

</head>
<body>
	<br>
	<div class="container">
		<div class="form-group row pull-right">
		<div class="col-xs-8">
		<input class="form-control" type="text" size="20" id="userName" onkeyup="searchFunction()">
		</div>
		
		
			<div class="col-xs-2">
		<button class="btn btn-primary" type="button"  onclick="searchFunction();">검색</button>
		</div>
	
	
	
	
	
	
	
		</div>

	<table class="table" style="text-align: center;">
	
	  <thead>
   <tr>
   <th style ="background-color:#fafafa; text-aling:center;">이름</th>
   <th style ="background-color:#fafafa; text-aling:center;">나이</th>
   <th style ="background-color:#fafafa; text-aling:center;">성별</th>
   <th style ="background-color:#fafafa; text-aling:center;">이메일</th>


   </tr>
  </thead>
	<tbody id="ajaxTable">
	</tbody>
	</table>


</div>



</body>

</html>