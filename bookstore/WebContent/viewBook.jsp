<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javas    cript"></script>
<script src="js/ratebook.js"></script>
<link href="css/rateit.css" rel="stylesheet" type="text/css">

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
						
						<c:choose>
							<c:when test="${empty averageRating}">
								<p><b>No reviews exists for this book yet</b></p>
							</c:when>
							<c:otherwise>
								<p><i>Average rating for this book</i></p>
								<div class="rateit" id="rater2" data-rateit-readonly="true" data-rateit-value="${averageRating}"></div>
							</c:otherwise>		
						</c:choose>	
											
						<c:choose>
							<c:when test="${empty customer }">
							<p><i>Log in to review this book</i></p>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${empty rating}">
										<script type="text/javascript">
											function submitFormy(){
												document.forms['id_rateForm'].rating.value=$('#rater1').rateit('value');
												document.forms['id_rateForm'].submit();
												window.location.reload();
											}
										</script>
										<div class="rateit" name="userrating" id="rater1" step="1.0" onClick="$javascript:submitFormy()"> </div>
										<form method="POST" action="rateBook.do" id="id_rateForm">
											<input type="hidden" name="isbn" value="${book.isbn13}" />
											<input type="hidden" name="rating" value="" />
										</form>
									</c:when>
									<c:otherwise>
										<p><i>Log in to review this book</i></p>					
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
						<!-- TODO: 
							When empty customerRating
							load default value, if any
							submitting values to customer
							setting read-only for "correct values"
							make sure there's authorization for rating, currently any user can..
							check if review already exists for this customer
							-->

							

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
					<div class="btn-group">
					<button type="button" class="btn btn-default">
					<span class="badge">42</span>
					<span class="glyphicon glyphicon-thumbs-up"></span> 
					</button>
					<button type="button" class="btn btn-default">
					<span class="badge"></span>
					<span class="glyphicon glyphicon-thumbs-down"></span>
					</button>
					</div>
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
