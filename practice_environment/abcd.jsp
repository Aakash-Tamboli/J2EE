<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<!DOCTYPE HMTL>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>IF TAG HANDLER</title>
</head>
<body>
${module}
<hr>
${HOME}
<hr>
${DESIGNATION}
<hr>
${EMPLOYEE}
<hr>

<tm:If condition='${module == HOME}'>
<h1>${module} == ${HOME}</h1>
</tm:If>

<tm:If condition='${module == DESIGNATION}'>
<h1>${module} == ${DESIGNATION}</h1>
</tm:If>

<tm:If condition='${module == EMPLOYEE}'>
<h1>${module} == ${EMPLOYEE}</h1>
</tm:If>

</body>
</html>
