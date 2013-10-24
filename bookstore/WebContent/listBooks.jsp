<div class="container">

	<c:if test="${not empty books}">
		<h2>List of all books</h2>
	</c:if>
	<c:forEach items="${ books}" var="item">
		<p>
		<a href="viewBook.do?isbn=${item.key}">${item.value}</a>
		</p>
		
	</c:forEach>
</div>
