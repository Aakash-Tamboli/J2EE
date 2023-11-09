<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- Main Container Start here-->
<div class='main-container'>
<!-- Header Starts Here-->
<div class='header'>
<img src='/styletwo/images/tm.png' class='logo'>
<div class='brand-name'>
Thinking Machines
</div>
</div>
<!-- Header Ends Here-->
<!-- Content-Section Starts here-->
<div class='content'>

<!-- Left Pannel Starts Here -->
<div class='content-left-panel'>

<tm:If condition='${module == DESIGNATION}'>
<b>Designations</b><br>
</tm:If>

<tm:If condition='${module != DESIGNATION}'>
<a href='/styletwo/Designations.jsp'>Designations</a>
</tm:If>

<tm:If condition='${module==EMPLOYEES}'>
<br>
<b>Employees</b>
</tm:If>

<tm:If condition='${module!=EMPLOYEE}'>
<br>
<a href='/styletwo/Employees.jsp'>Employees</a>
</tm:If>

<tm:If condition='${module!=HOME}'>
<br>
<a href='/styletwo/index.jsp'>Home</a>
</tm:If>


</div>
<!-- left Pannel Ends Here--> 
