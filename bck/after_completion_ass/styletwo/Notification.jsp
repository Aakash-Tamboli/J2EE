<%@taglib prefix='tm' uri='/WEB-INF/mytags/tmtags.tld' %>
<tm:Authenticate />
<jsp:useBean id='messageBean' scope='request' class='com.thinking.machines.hr.beans.MessageBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
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
            </div><!-- Right Pannel Ends Here -->
<jsp:include page='/MasterPageBottomSection.jsp' />
