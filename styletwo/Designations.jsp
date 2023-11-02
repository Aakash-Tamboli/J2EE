<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<!-- Right Pannel Starts Here -->
<div class='content-right-panel'>
<h2>Designations</h2>
<table border='1'>
<thead>
<tr>
<th colspan='4' style='text-align:right;padding:5px'><a href='/styletwo/DesignationAddForm.jsp'>Add New Designation</a></th>
</tr>
<tr>
<th style='width:60px;text-align:center'>S.No</th>
<th style='width:200px;text-align:center'>Designation</th>
<th style='width:100px;text-align:center'>Edit</th>
<th style='width:100px;text-align:center'>Delete</th>
</tr>
</thead>
<tbody>
<tm:Designations>
<tr>
<td style='text-align:right'>${serialNumber}</td>
<td>${designationBean.title}</td>
<td style='text-align:center'><a href='/styletwo/editDesignation?code=${designationBean.code}'>Edit</a></td>
<td style='text-align:center'><a href='/styletwo/confirmDeleteDesignation?code=${designationBean.code}'>Delete</a></td>
</tr>
</tm:Designations>
</tbody>
</table>
</div><!-- Right Pannel Ends Here -->
<jsp:include page='/MasterPageBottomSection.jsp' />
