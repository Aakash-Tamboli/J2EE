<jsp:useBean id='errorBean' class='com.thinking.machines.hr.beans.ErrorBean' scope='request' />
<jsp:useBean id='administratorBean' class='com.thinking.machines.hr.beans.AdministratorBean' scope='request' />
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
<div class='login'>
<h6 class='error'>${errorBean.error}</h6>
<form action='/styletwo/Login.jsp' method='POST'>
Name: &emsp;
<input type='text' id='username' name='username' value='${administratorBean.username}'> <br> <br>
Password: &emsp;
<input type='text' id='password' name='password' value='${administratorBean.password}'> <br> <br>
<button type='submit'>Login</button>
</form>
</div><!-- Main Container ends here -->
<!-- Content-Section Ends Here -->
<!-- Footer Start Here-->
<div class='footer'>&copy Thinking Machines 2023</div><!-- Footer Ends Here -->
</body>
</html>

