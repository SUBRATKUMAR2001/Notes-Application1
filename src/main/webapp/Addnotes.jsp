<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="component/BootStrapCss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="component/HomeNavbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">ADD NOTES HERE</p>
						
						
						<form action="addnotes" method="post">
							<div class="mb-3">
								<label class="form-label">TITLE</label> <input
									name="title" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">DESCRIPTION</label> 
								<textarea rows="10" cols="46" class="form-control" name="description"></textarea>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">ADD NOTES</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>