<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>Tesing</title>
</head>
<body>
<table>
<thead>
<tr>
<td>S.No</td>
<td>Designation</td>
</tr>
</thead>
<tbody>
<tm:Designations>
<tr>
<td>${serialNumber}</td>
<td>${designationBean.title}</td>
<tr>
</tm:Designations>
</tbody>
</table>
</body>
</html>
