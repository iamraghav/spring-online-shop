<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- Success or faliure mesage -->
					<c:if test="${not empty message}">
							<div class="alert alert-success alert-dismissible">
								<button class="close" type="button" data-dismiss="alert">&times;</button>

								${message}
							</div>
					</c:if>
					<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal" modelAttribute="product"
						acrion="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name: </label>
							<div class="col-md-8">
								<sf:input type="text" class="form-control" id="name" path="name"
									placeholder="Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name: </label>
							<div class="col-md-8">
								<sf:input type="text" class="form-control" id="brand"
									path="brand" placeholder="Brand Name" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description: </label>
							<div class="col-md-8">
								<sf:textarea class="form-control" rows="4" id="description"
									path="description" placeholder="Product Description" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price: </label>
							<div class="col-md-8">
								<sf:input type="number" class="form-control" id="unitPrice"
									path="unitPrice" placeholder="Unit Price in &#8377;" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity
								Available: </label>
							<div class="col-md-8">
								<sf:input type="number" class="form-control" id="quantity"
									path="quantity" placeholder="Quantity Available" />
							</div>
						</div>

						<!-- File element for image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								Product Image: </label>
							<div class="col-md-8">
								<sf:input type="file" class="form-control" id="file" path="file" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category: </label>
							<div class="col-md-8">
								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" class="btn btn-primary" id="submit"
									name="submit" value="Submit" />

								<!-- Hidden Fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />
		</div>
		<div class="col-xs-12">
			<div style="overflow: auto">
				<!-- Products table for admin -->
				<table id="adminProductsTable"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="danger">Id</th>
							<th class="success">&#160;</th>
							<th class="info">Name</th>
							<th class="active">Quantity</th>
							<th class="danger">Unit Price</th>
							<th class="success">Active</th>
							<th class="info">Edit</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>4</td>
							<td><img class="adminDataTableImg"
								src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg"
								alt="Macbook Pro" /></td>
							<td>Macbook Pro</td>
							<td>3</td>
							<td>&#8377; 54000</td>
							<td>
								<!-- toggle Switch --> <label class="switch"> <input
									type="checkbox" checked="checked" value="4" />
									<div class="slider"></div>
							</label>
							</td>
							<td><a href="${contextRoot}/manage/4/product"
								class="btn btn-warning"> <span
									class="glyphicon glyphicon-pencil"></span>
							</a></td>
						</tr>

						<tr>
							<td>4</td>
							<td><img class="adminDataTableImg"
								src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg"
								alt="Macbook Pro" /></td>
							<td>Macbook Pro</td>
							<td>3</td>
							<td>&#8377; 54000</td>
							<td>
								<!-- toggle Switch --> <label class="switch"> <input
									type="checkbox" value="4" />
									<div class="slider"></div>
							</label>
							</td>
							<td><a href="${contextRoot}/manage/4/product"
								class="btn btn-warning"> <span
									class="glyphicon glyphicon-pencil"></span>
							</a></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th class="danger">Id</th>
							<th class="success">&#160;</th>
							<th class="info">Name</th>
							<th class="active">Quantity</th>
							<th class="danger">Unit Price</th>
							<th class="success">Active</th>
							<th class="info">Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>

</div>