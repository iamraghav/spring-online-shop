<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">

	<div class="row">
		<!-- columns for Display The personal details -->
		<div class="col-sm-6">
			<div class="panel panel-success">
				<div class="panel-heading">

					<h3 class="text-center">Personal Details</h3>

				</div>

				<div class="panel-body">
						<h4>Name : <small>${registerModel.user.firstName } ${registerModel.user.lastName }</small></h4>
						<h4>Email : <small>${registerModel.user.email }</small></h4>
						<h4>Mobile : <small>${registerModel.user.contactNumber }</small></h4>
						<h4>Role : <small>${registerModel.user.role }</small></h4>

				</div>
				<div class="panel-footer">
					<a href="${flowExecutionUrl }&_eventId_personal"
						class="btn btn-primary">Edit</a>
				</div>
			</div>
		</div>

		<!-- column for Display the address -->
		<div class="col-sm-6">
			<div class="panel panel-warning">
				<div class="panel-heading">

					<h3 class="text-center">Address Details</h3>

				</div>

				<div class="panel-body">
						<h4>Address 1 : <small>${registerModel.billing.addressLineOne }</small></h4>
						<h4>Address 2 : <small>${registerModel.billing.addressLineTwo }</small></h4>
						<h4>City &amp; ZipCode : <small>${registerModel.billing.city } - ${registerModel.billing.postalCode }</small></h4>
						<h4>State &amp; Country : <small>${registerModel.billing.state } - ${registerModel.billing.country }</small></h4>
				</div>
				<div class="panel-footer">
					<a href="${flowExecutionUrl }&_eventId_billing"
						class="btn btn-primary">Edit </a>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<div class="text-center">
				<a href="${flowExecutionUrl }&_eventId_submit"
					class="btn btn-primary">Confirm</a>
			</div>
		</div>
	</div>
</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>