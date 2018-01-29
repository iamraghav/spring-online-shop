<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp"%>
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Sign up - Personal</h4>
							</div>
							<div class="panel-body">
								<sf:form
									method="POST"
									class="form-horizontal"
									id="registerForm"
									modelAttribute="user"
								>
								
									<div class="form-group">
										<label class="control-label col-md-4">First Name</label>
										<div class="col-md-8">
											<sf:input type="text" class="form-control" path="firstName" placeholder="First Name"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-4">Last Name</label>
										<div class="col-md-8">
											<sf:input type="text" class="form-control" path="lastName" placeholder="Last Name"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-4">Email</label>
										<div class="col-md-8">
											<sf:input type="email" class="form-control" path="email" placeholder="abc@xyz.com"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-4">Contact Number</label>
										<div class="col-md-8">
											<sf:input type="text" class="form-control" path="contactNumber" maxlength="10" placeholder="xxxxxxxxxx"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-md-4">Password</label>
										<div class="col-md-8">
											<sf:input type="password" class="form-control" path="password" placeholder="Password"/>
										</div>
									</div>
									
									<!-- radio button using bootstrap class for radio-inline -->
									<div class="form-group">
										<label class="control-label col-md-4">Select Role</label>
										<div class="col-md-8">
											<label class="radio-inline">
												<sf:radiobutton path="role" value="USER" checked="checked" /> User
											</label>
											<label class="radio-inline">
												<sf:radiobutton path="role" value="SUPPLIER" /> Supplier
											</label>
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">
											<!-- Submit button inside the form -->
											<button type="submit" name="_eventId_billing" class="btn btn-primary">
												Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
											</button>
										</div>
									</div>
								
								</sf:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

<%@include file="../shared/flows-footer.jsp"%>		