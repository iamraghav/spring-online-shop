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

	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

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

		$table
				.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ], [ '3', '5', '10', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img class="dataTableImg" src="'
											+ window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" />';
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
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red; font-weight:bold">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									str += '<div class="btn-group" role="group" aria-label="View And Cart"><a title="View" class="btn btn-primary" href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>';

									if (row.quantity < 1) {
										str += '<a title="Add to Cart" class="btn btn-success disabled" href="javascript:void(0)"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></div>';
									} else {
										str += '<a title="Add to Cart" class="btn btn-success" href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></div>';
									}

									return str;
								}
							}

					]

				});
	}

	// dismissing the alert after 3 seconds
	var $alert = $('.alert');

	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}
	// --------------------------------

	// --------------------------------------------
	// data table for admin
	// ======================================

	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only where we have this table
	if ($adminProductsTable.length) {

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '10', '30', '50', 'ALL' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img class="adminDataTableImg" src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" />';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red; font-weight:bold">Out of Stock!</span>';
									}

									return data;

								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<label class="switch">';
									if (data) {
										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '" />';
									} else {
										str += '<input type="checkbox" value="'
												+ row.id + '" />';
									}

									str += '<div class="slider"></div></label>';

									return str;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span 	class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}
							}

					],

					// ---------------------------------
					// Toggle Switch bootBox
					// ==============================

					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'Are you sure you want to activate the product?'
													: 'Are you sure you want to deactivate the product?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({

														size : 'medium',
														title : 'Product Activation & Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {

															if (confirmed) {
																// console.log(value);

																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';

																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data
																							});
																				});
															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}

														}

													});

										});
						// ---------------------------------------------
					}

				});
	}

	// -------------------------------------------

});