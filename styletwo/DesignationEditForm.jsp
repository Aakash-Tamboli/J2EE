<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HR Application</title>
    <script src='/styletwo/js/DesignationEditForm.js'></script>
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
                <b><a href='/styleone/Designations.jsp'>Designations</a></b> <br>
                <a href='/styleone/employeesView'>Not Yet completed</a><br><br>
                <a href='/styleone/index.html'> Not Yet completed </a>
            </div>
            <!-- left Pannel Ends Here-->
            <!-- Right Pannel Starts Here -->
            <div class='content-right-panel'>
                <h2>Designation (Edit Module)</h2>
                <b>
                    <span class='error'>
                        <jsp:getProperty name='errorBean' property='error'/>
                    </span>
                </b>
                <form method='post' action='/styletwo/updateDesignation' onsubmit='return validateForm(this)'>
                    Designation: &nbsp;
		    <input type='hidden' id='code' name='code' value='${designationBean.code}'>
                    <input type='text' id='title' name='title' maxlength='36' size='36' value='${designationBean.title}'>
                    <span id='titleErrorSection' class='error'></span><br>
                    <table>
                        <tr>
                            <td>
                                <button type='submit'>Edit</button>
                </form>
                            </td>
                <td>
                    <form action='/styletwo/Designations.jsp' onclick='return cancelEditing(this)'>
                        <button type='submit'>Cancel</button>
                    </form>
                </td>
                </tr>
                </table>

            </div>
            <!-- Right Pannel Ends Here -->
        </div>
        <!-- Content-Section Ends Here -->
        <!-- Footer Start Here-->
        <div class='footer'>&copy Thinking Machines 2023</div>
        <!-- Footer Ends Here -->
    </div>
    <!-- Main Container ends here -->
</body>
</html>
