<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<tm:Module name='DESIGNATION' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationAddForm.js'></script>
           <!-- Right Pannel Starts Here -->
            <div class='content-right-panel'>
                <h2>Designation (Add Module)</h2>
                <b>
                    <span class='error'>
                        <jsp:getProperty name='errorBean' property='error'/>
                    </span>
                </b>
                <form method='post' action='/styletwo/AddDesignation.jsp' onsubmit='return validateForm(this)'>
                    Designation: &nbsp;
                    <input type='text' id='title' name='title' maxlength='36' size='36' value='${designationBean.title}'>
		    <tm:UniqueId />
		    <input type='hidden' id='formId' name='formId' value='${uniqueId}' >
                    <span id='titleErrorSection' class='error'></span><br>
                    <table>
                        <tr>
                            <td>
                                <button type='submit'>Add</button>
                </form>
                            </td>
                <td>
                    <form action='/styletwo/Designations.jsp' onclick='return cancelAddition(this)'>
                        <button type='submit'>Cancel</button>
                    </form>
                </td>
                </tr>
                </table>

            </div> <!-- Right Pannel Ends Here -->
<jsp:include page='/MasterPageBottomSection.jsp' />
