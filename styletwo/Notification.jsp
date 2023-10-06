<%@ taglib prefix='tm' uri='/WEB-INF/mytags/tmtags.tld' %>
    <jsp:useBean id='messageBean' scope='request' class='com.thinking.machines.hr.beans.MessageBean' />

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HR Application</title>
        <script src='/styletwo/js/DesignationAddForm.js'></script>
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
                    <b><a href='/styleone/designationsView'>Not Yet completed</a></b> <br>
                    <a href='/styleone/employeesView'>Not Yet completed</a><br><br>
                    <a href='/styleone/index.html'> Not Yet completed </a>
                </div>
                <!-- left Pannel Ends Here-->
                <!-- Right Pannel Starts Here -->
                <div class='content-right-panel'>
                    <h1>${messageBean.heading}</h1>
                    <b>
                        <h3>${messageBean.message}</h3>
                    </b>
                    <tm:If condition='${messageBean.generateButtons}'>
                        <table>
                            <tr>
                                <td>
                                    <form action='/styletwo/${messageBean.buttonOneAction}'>
                                        <button>${messageBean.buttonOneText}</button>
                                    </form>
                                </td>
                                <tm:If condition='${messageBean.generateTwoButtons}'>
                                    <td>
                                        <form action='/styletwo/${messageBean.buttonTwoAction}'>
                                            <button>${messageBean.buttonTwoText}</button>
                                        </form>
                                    </td>
                                </tm:If>
                            </tr>
                        </table>
                    </tm:If>
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