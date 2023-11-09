<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<tm:Module name='DESIGNATION' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationEditForm.js'></script>
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

            </div><!-- Right Pannel Ends Here -->
<jsp:include page='/MasterPageBottomSection.jsp' />
