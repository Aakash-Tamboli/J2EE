<jsp:useBean id="designationBean" class="com.thinking.machines.hr.beans.DesignationBean" scope="request" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HR Application</title>
    <script src='/styletwo/js/DesignationDeleteForm.js'></script>
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
                <b><a href='/styletwo/Designations.jsp'>Designations</a></b> <br>
                <a href='/styleone/employeesView'>Not Yet completed</a><br><br>
                <a href='/styleone/index.html'> Not Yet completed </a>
            </div>
            <!-- left Pannel Ends Here-->
            <!-- Right Pannel Starts Here -->
            <div class='content-right-panel'>
                <h2>Designation (Delete Module)</h2>
                <form action='/styletwo/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>
			<b>Do you Want to Delete ${designationBean.title} Designation </b><br>
			<input type='hidden' id='code' name='code' value='${designationBean.code}'>
                    <table>
                        <tr>
                            <td>
                                <button type='submit'>Yes</button>
                </form>
                            </td>
                <td>
                    <form action='/styletwo/Designations.jsp' onclick='return cancelDeletion(this)'>
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