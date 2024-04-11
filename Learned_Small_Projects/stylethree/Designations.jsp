<jsp:include page='/MasterPageTopSection.jsp' />
<jsp:include page='MasterPageLeftPannelForDesignation.jsp' />
<script src='/stylethree/js/designations.js' ></script>
<!-- Right Pannel Starts Here -->
<div class='content-right-panel' id='right-panel'>
<h2 id='moduleName'>Designations (List Module)</h2>

<table border='1' id='designationsTable' >
<thead>
<tr>
<th colspan='4' style='text-align:right;padding:5px'><a href='javascript:addDesignation()'>Add New Designation</a></th>
</tr>
<tr>
<th style='width:60px;text-align:center'>S.No</th>
<th style='width:200px;text-align:center'>Designation</th>
<th style='width:100px;text-align:center'>Edit</th>
<th style='width:100px;text-align:center'>Delete</th>
</tr>
</thead>
<tbody>
<tr>
<td style='text-align:right' placeHolder='serialNumber' ></td>
<td placeHolder='designationName'>d</td>
<td placeHolder='editOption' style='text-align:center'></td>
<td placeHolder='deleteOption' style='text-align:center'></td>
</tr>

</tbody>
</table>
</div><!-- Right Pannel Ends Here -->

<jsp:include page='/MasterPageBottomSection.jsp' />
