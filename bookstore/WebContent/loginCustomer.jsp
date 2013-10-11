<div class="container">
	<c:choose>
		<c:when test="${empty customer}">
		<div class="col-md-3">
			<h1>Login</h1>
			<form role="form" action="loginCustomer.do" method="post">
				<c:if test="${not empty values.from}">
					<input type="hidden" name="from" value="${values.from}">
				</c:if>
				<div class="form-group">
					<label for="email">Email</label> 
					<input class="form-control" placeholder="Email"
						id="email" name="email" type="text" value="${values.email}" />
				</div>
				
				<div class="form-group">
					<label for="password">Password</label>
					 <input class="form-control" id="password" placeholder="password" name="password" type="text" autocomplete="off" />
					
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
				<c:if test="${not empty messages.error}">
				<br />
				<br />
					<p class="alert alert-danger">${messages.error}</p>
				</c:if>
				
			</form>

			</div>
		</c:when>
		<c:otherwise>
			<div>Login successful!</div>
			
		</c:otherwise>
	</c:choose>
</div>