<jsp:useBean id="designationBean" class="com.thinking.machines.hr.beans.DesignationBean" scope="request" />
<jsp:include  page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationDeleteForm.js'></script>       
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

            </div><!-- Right Pannel Ends Here -->
<jsp:include page='/MasterPageBottomSection.jsp' />
