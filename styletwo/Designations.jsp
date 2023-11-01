<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR Application</title>
</head>
<body>
<!-- Main Container Start here-->
<div style='width:90hw;height:auto;border:1px solid black'>
<!-- Header Starts Here-->
<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>
<img src='/styletwo/images/tm.png' style='float:left;width:40px;height:40px'>
<div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>
Thinking Machines
</div>
</div>
<!-- Header Ends Here-->
<!-- Content-Section Starts here-->
<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'>
<!-- Left Pannel Starts Here -->
<div style='height:60vh;margin:5px;float:left;padding:5px;border:1px solid black'>
<b href='/styletwo/Designations.jsp'>Designations</b> <br>
<a href='/styletwo/employeesView'>Employees</a>
</div>
<!-- left Pannel Ends Here-->
<!-- Right Pannel Starts Here -->
<div style='height:60vh;margin-left:140px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;overflow:scroll;border:1px solid black'>
<h2>Designations</h2>
<table border='1'>
<thead>
<tr>
<th colspan='4' style='text-align:right;padding:5px'><a href='/styletwo/DesignationAddForm.jsp'>Add New Designation</a></th>
</tr>
<tr>
<th style='width:60px;text-align:center'>S.No</th>
<th style='width:200px;text-align:center'>Designation</th>
<th style='width:100px;text-align:center'>Edit</th>
<th style='width:100px;text-align:center'>Delete</th>
</tr>
</thead>
<tbody>
<tm:Designations>
<tr>
<td style='text-align:right'>${serialNumber}</td>
<td>${designationBean.title}</td>
<td style='text-align:center'><a href='/styletwo/editDesignation?code=${designationBean.code}'>Edit</a></td>
<td style='text-align:center'><a href='/styletwo/confirmDeleteDesignation?code=${designationBean.code}'>Delete</a></td>
</tr>
</tm:Designations>
</tbody>
</table>
</div>
<!-- Right Pannel Ends Here -->
</div>
<!-- Content-Section Ends Here -->
<!-- Footer Start Here-->
<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid black'>
&copy; Thinking Machines 2023
</div>
<!-- Footer Ends Here -->
</div>
<!-- Main Container ends here
</body>
</html>
