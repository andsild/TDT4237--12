<script type="text/javascript">
	var RecaptchaOptions = {
		theme : 'custom',
		custom_theme_widget : 'recaptcha_widget'
	};
</script>
<div class="container">
	<h1>Create Book List</h1>
	<div class="col-md-5">
		<form role="form" action="addBookList.do" method="post">
			<div class="form-group">
				<label for="title">Subject</label> <input class="form-control" id="subject"
					name="title" type="text" placeholder="title" required />
			</div>
			<div class="form-group">
			<label for="description">Description</label>
				<textarea class="form-control"
					name="description" rows="10" required ></textarea>
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
				<c:forEach items="${messages}" var="item">
					<p class="alert alert-danger">${item}</p>
				</c:forEach>
				
			</div>
		</form>
	</div>
</div>