<div class="container">
	<h1>Shopping Cart</h1>
	<c:choose>
		<c:when test="${empty cart.items}">
			<div>No items in shopping cart.</div>
		</c:when>
		<c:otherwise>
			<form role="form" action="updateCart.do" method="post">
				<table class="table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cart.items}" var="item">
							<tr>
								<td>${item.value.book.title.name}</td>
								<td class="col-sm-2"><input type="hidden" name="isbn"
									value="${item.value.book.isbn13}" />
									<div class="input-group input-group-sm">
										<span class="input-group-btn">
											<button class="btn btn-default" type="button"
												onclick="var elem = document.getElementById('${item.value.book.isbn13}'); elem.value = parseInt(elem.value)-1">-</button>
										</span> <input class="form-control" type="number" name="quantity"
											id="${item.value.book.isbn13}" size="3"
											value="${item.value.quantity}" /> <span
											class="input-group-btn">
											<button class="btn btn-default" type="button"
												onclick="var elem = document.getElementById('${item.value.book.isbn13}'); elem.value = parseInt(elem.value)+1">+</button>
										</span>
									</div></td>
								<td>${item.value.book.price}</td>
								<td>${item.value.book.price*item.value.quantity}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button class="btn btn-primary" type="submit">Update</button>
			</form>
			<c:choose>
				<c:when test="${cart.numberOfItems == 1}">
					<div>Subtotal: ${cart.subtotal}</div>
				</c:when>
				<c:otherwise>
					<div>
						<c:out
							value="Subtotal (${cart.numberOfItems} items): ${cart.subtotal}"></c:out>
					</div>
				</c:otherwise>
			</c:choose>
			<br />
			<div>
				<a href="debug/list_books.jsp">Continue shopping</a>
			</div>
			<div>
				<a href="selectShippingAddress.do">Go to checkout</a>
			</div>
		</c:otherwise>
	</c:choose>
</div>