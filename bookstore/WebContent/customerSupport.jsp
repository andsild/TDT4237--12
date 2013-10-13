<script type="text/javascript">
	var RecaptchaOptions = {
		theme : 'custom',
		custom_theme_widget : 'recaptcha_widget'
	};
</script>
<div class="container">
	<h1>Customer Support</h1>
	<div class="col-md-5">
		<form role="form" action="customerSupport.do" method="post">
			<div class="form-group">
				<label for="department">Department</label> 
				<select class="form-control"
					 name="email" required>
					 	<option selected value="sales">Sales</option>
                            <option value="techSupport">Technical support</option>
					 </select>
			</div>
			<div class="form-group">
				<label for="subject">Subject</label> <input class="form-control" id="subject"
					name="subject" type="text" placeholder="subject" required />
			</div>
			<div class="form-group">
				<textarea class="form-control"
					name="content" rows="10" required ></textarea>
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
						height="300" width="500" frameborder="0"></iframe>
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
</div>