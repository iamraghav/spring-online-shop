$(function() {
	// Solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listProducts').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
});

// code for jQuery dataTable

var $table = $('#productListTable');

// execute the below code only where we have this table
if ($table.length) {

	var jsonUrl = '';

	if (window.categoryId == '') {
		jsonUrl = window.contextRoot + '/json/data/all/products';
	} else {
		jsonUrl = window.contextRoot + '/json/data/category/'
				+ window.categoryId + '/products';
	}

	$table.DataTable({

		lengthMenu : [ [ 3, 5, 10, -1 ], [ '3', '5', '10', 'ALL' ] ],
		pageLength : 5,
		ajax : {
			url : jsonUrl,
			dataSrc : ''
		},
		columns : [
			{
				data: 'code',
				bSortable: false,
				mRender: function(data, type,row) {
			
					return '<img class="dataTableImg" src="'+window.contextRoot+'/resources/images/'+data+'.jpg" />';
				}
			},
			{
				data : 'name'
			},
			{
				data : 'brand'
			},
			{
				data : 'unitPrice',
				mRender : function(data, type, row) {
					return '&#8377; ' + data
				}
			},
			{
				data : 'quantity'
			},
			{
				data: 'id',
				bSortable: false,
				mRender: function(data, type, row) {
				
					var str ='';
					str += '<div class="btn-group" role="group" aria-label="View And Cart"><a title="View" class="btn btn-primary" href="'+window.contextRoot+ '/show/'+data+'/product"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>';
					str += '<a title="Add to Cart" class="btn btn-success" href="'+window.contextRoot+ '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></div>';
				
					return str;
				}
			}

		]

	});
}