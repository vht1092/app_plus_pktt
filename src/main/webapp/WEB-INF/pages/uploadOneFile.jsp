<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload One File</title>
</head>
<body>
	<jsp:include page="index.jsp" />

	<h3>Upload One File:</h3>

	<!-- MyUploadForm -->
	<form:form modelAttribute="myUploadForm" method="POST" action=""
		enctype="multipart/form-data">


		<br>
		<br />
		<br />
		<form:input path="description" style="width:100px;" />
		<br />
		<br />               
        Chọn file upload: <form:input path="fileDatas" type="file" />
		<br />
		<input type="submit" value="Upload"
			style="width: 100px; float: left; background-color: blue; color: white; border-radius: 5px">
		<br>
		<br />
		<br />
		<p
			style="font-weight: bold; float: left; color: red; width: 30%; margin-left: 5px"
			behavior="alternate">${result}</p>

	</form:form>

</body>

</html>