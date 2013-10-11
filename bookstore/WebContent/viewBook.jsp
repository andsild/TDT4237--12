<div class="container">
	<c:choose>
		<c:when test="${empty book}">
			<h2>Book not found!</h2>
			<div class="index-item">
				<a href="debug/list_books.jsp">List books</a>
			</div>
		</c:when>
		<c:otherwise>
			<h2>${book.title.name}</h2>
			<div class="row">

				<div class="col-md-4 well">
					<div>
						<ul class="list-unstyled">
							<li><b>Authors:</b> 
							<c:forEach items="${book.author}" var="author" varStatus="it">
	                            ${author.name}<c:if test="${!it.last}">, </c:if>
							</c:forEach></li>
							<li><b>Publisher:</b> ${book.publisher.name}</li>
							<li><b>Published:</b> ${book.published}</li>
							<li><b>Edition:</b> ${book.edition} (${book.binding})</li>
							<li><b>ISBN:</b> ${book.isbn13}</li>
							<li><b>Price:</b> ${book.price}</li>
						</ul>
						<p>${book.description}</p>

						<form class="form-inline" role="form" action="addBookToCart.do"
							method="post">
							<div class="form-group">
								<input type="hidden" name="isbn" value="${book.isbn13}" /> 
								<input type="text" class="form-control" size="2" name="quantity" value="1" />
							</div>
							<button type="submit" class="btn btn-primary">Add to cart</button>
						</form>
					</div>
				</div>
				<div class="col-md-4">
					<img class="img-thumbnail" src="http://www4.alibris-static.com/isbn/${book.isbn13}.gif">
				</div>
				
			</div>
			<div class="row">
				<div class="col.md-9" >
				<div class="list-group">
				<div class="list-group-item">
					<h4 class="list-group-heading">Bookreview</h4>
					<p class="list-group-item-text">The Devil's Company, a treat for lovers of historical fiction, sees the return of 
					Benjamin Weaver in his third exciting romp through the varied and sometimes surreal landscape of 18th-century London. 
					Weaver is an endearing protagonist, a former pugilist and investigator for hire whom we first met in 
					David Liss's A Conspiracy of Paper (1999)
					</p>
					<span class="glyphicon glyphicon-search"></span>
					
				</div>
				<div class="list-group-item">
					<h4 class="list-group-heading">Bookreview</h4>
					<p class="list-group-item-text">The Devil's Company, a treat for lovers of historical fiction, sees the return of 
					Benjamin Weaver in his third exciting romp through the varied and sometimes surreal landscape of 18th-century London. 
					Weaver is an endearing protagonist, a former pugilist and investigator for hire whom we first met in 
					David Liss's A Conspiracy of Paper (1999)
					</p>
				</div>
				</div>
			</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>