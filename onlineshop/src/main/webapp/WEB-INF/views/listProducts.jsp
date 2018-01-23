<div class="container">
	<div class="row">
		<!-- Display Side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Display Products -->
		<div class="col-md-9">
			<!-- Added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
					
					<script>
						window.categoryId = '';
					</script>
					
						<ol class="breadcrumb">
							<li><a href="${contextroot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
					
					<script>
						window.categoryId = '${category.id}';
					</script>
					
						<ol class="breadcrumb">
							<li><a href="${contextroot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table id="productListTable" class="table table-hover table-striped table-border">
						<thead>
							<tr>
								<th class="active"></th>
								<th class="info">Name</th>
								<th class="danger">Brand</th>
								<th class="success">Price</th>
								<th class="warning">Qty. Avail</th>
								<th class="active"></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th class="active"></th>
								<th class="info">Name</th>
								<th class="danger">Brand</th>
								<th class="success">Price</th>
								<th class="warning">Qty. Avail</th>
								<th class="active"></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>