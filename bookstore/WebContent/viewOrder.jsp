<div class="container">
	<h1>View order</h1>
	<c:choose>
		<c:when test="${empty cart.items}">
			<div>Invalid order.</div>
		</c:when>
		<c:otherwise>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Title</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cart.items}" var="item" varStatus="counter">
							<tr>
								<td>${counter.count}</td>
								<td>${item.value.book.title.name}</td>
								<td>${item.value.quantity}</td>
								<td>${item.value.book.price}</td>
								<td>${item.value.book.price*item.value.quantity}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
					<tr>
						<th></th>
						<th>Total</th>
						<th>${cart.numberOfItems}</th>
						<th></th>
						<th>${cart.subtotal}</th>
					</tfoot>
				</table>
				
			<p>Status: ${order.statusText}</p>
			<c:if test="${status=='0'}">
			<a href="cancelOrder.do">Cancel order</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</div>