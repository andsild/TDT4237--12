<div class="container">
	<h1>Logout</h1>
	
	<c:choose>
		<c:when test="${not empty customer}">
			<div>
				<p>Logged out!</p>
			</div>		
		</c:when>
		<c:otherwise>
		<div>
			Test not logged in
		</div>
		</c:otherwise>
	</c:choose>
</div>