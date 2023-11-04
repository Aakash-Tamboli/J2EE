<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>Tesing</title>
</head>
<body>
<form method='POST' action='/practice_environment/aaa' >
<tm:UniqueId />
<input type='hidden' id='formId' name='formId' value='${uniqueId}' >
<button type='submit'>${uniqueId}</button>
</form>
</body>
</html>
