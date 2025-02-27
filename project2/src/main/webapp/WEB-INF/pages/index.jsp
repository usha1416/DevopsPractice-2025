<%@ page import="test.com.PackageInfo" %>
<!DOCTYPE html>
<html lang="en-US">
<head>
	<meta charset="UTF-8" />
	<title>file1 - Package Information</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<% 
	ServletContext ctx = getServletContext();
	PackageInfo info = PackageInfo.getInstance(ctx); 
%>

<body>
	<div class="container">
		<div>
			<div class="panel-body">
				<table cellpadding="0" cellspacing="0" class="table table-bordered">
					<thead>
						<tr><td colspan="2">Application Information</td></tr>
					</thead>
					
					<tbody>
						<tr>
							<td style="width:150px;">Title</td><td><%= info.getTitle() %></td>
						</tr>
						<tr>
							<td>Name</td><td><%= info.getName() %></td>
						</tr>
						<tr>
							<td>Version</td><td><%= info.getVersion() %></td>
						</tr>
						<tr>
							<td>Code</td><td><%= info.getCode() %></td>
						</tr>
						<tr>
							<td>URL</td><td><a href="<%= info.getURL() %>" target="_blank"><%= info.getURL() %></a></td>
						</tr>
						<tr>
							<td>Technology</td><td><%= info.getTechnology() %></td>
						</tr>
						<tr>
							<td>Vendor Name</td><td><a href="<%= info.getVendorURL() %>" target="_blank"><%= info.getVendorName() %></a></td>
						</tr>
						<tr>
							<td>Vendor ID</td><td><%= info.getVendorID() %></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>
