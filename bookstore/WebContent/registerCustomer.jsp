<script type="text/javascript">
	var RecaptchaOptions = {
		theme : 'custom',
		custom_theme_widget : 'recaptcha_widget'
	};
</script>
<div class="container">
	<h1>Register</h1>
	<c:choose>
		<c:when test="${empty sessionScope.customer}">
			<c:choose>
				<c:when test="${not empty register_success}">
					<div>
						You've successfully created a user. Maybe you should <a
							href="loginCustomer.do">sign in</a>?
					</div>
				</c:when>
				<c:otherwise>
					<c:if test="${not empty register_error}">
						<div>${register_error}</div>
					</c:if>
					<div class="col-md-5">
						<form role="form" action="registerCustomer.do" method="post">
							<div class="form-group">
								<label for="email">Email</label> <input class="form-control"
									id="email" name="email" type="text" placeholder="Email"
									required />
							</div>
							<div class="form-group">
								<label for="name">Name</label> <input class="form-control"
									id="name" name="name" type="text" placeholder="Name" required />
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input
									class="form-control" id="password" name="password"
									type="password" autocomplete="off" placeholder="Password"
									required />
							</div>
							<div id="recaptcha_widget" style="display: none">
								<div id="recaptcha_image"></div>
								<div class="form-group">
									<div class="input-group">
										<input type="text" id="recaptcha_response_field"
											name="recaptcha_response_field" class="form-control"
											placeholder="Captcha" required> <span
											class="input-group-btn">
											<button class="btn btn-default" type="button"
												onclick="javascript:Recaptcha.reload()">
												<span class="glyphicon glyphicon-refresh"></span>
											</button>
										</span>
									</div>
								</div>

								<script type="text/javascript"
									src="http://www.google.com/recaptcha/api/challenge?k=6LcwqOgSAAAAANhXXKjhfVcoJLQPdrOgLqE15ue-">
									
								</script>
								<noscript>
									<iframe
										src="http://www.google.com/recaptcha/api/noscript?k=6LcwqOgSAAAAANhXXKjhfVcoJLQPdrOgLqE15ue-"
										height="300" width="500"></iframe>
									<br>
									<textarea name="recaptcha_challenge_field" rows="3" cols="40">
								   </textarea>
									<input type="hidden" name="recaptcha_response_field"
										value="manual_challenge">
								</noscript>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
							<div class="form-group">
								<c:if test="${not empty messages.error}">
									<p class="alert alert-danger">${messages.error}</p>
								</c:if>
							</div>
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<div>You're already logged in. Now, don't be greedy, one
				account should be enough.</div>
		</c:otherwise>
	</c:choose>
</div>