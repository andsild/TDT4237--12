<script type="text/javascript">
	var RecaptchaOptions = {
		theme : 'custom',
		custom_theme_widget : 'recaptcha_widget'
	};
</script>

<link rel="stylesheet" type="text/css" href="/bookstore/css/commentStyle.css" />

<%@page import="amu.database.BookDAO"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"
	type="text/javascript"></script>
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
							<li><b>Authors:</b> <c:forEach items="${book.author}"
									var="author" varStatus="it">
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
								<p>
									<b>No reviews exists for this book yet</b>
								</p>
							</c:when>
							<c:otherwise>
								<p style="white-space: nowrap;">
									<i>Average rating for this book</i>
								<div style="white-space: nowrap;" class="rateit" id="rater2"
									data-rateit-readonly="true"
									data-rateit-value="${averageRating}">
								</div>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${empty customer }">
								<p>
									<i>Log in to rate this book</i>
								</p>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${empty rating}">
										<script type="text/javascript">
											function submitFormy() {
												document.forms['id_rateForm'].rating.value = $(
														'#rater1').rateit(
														'value');
												document.forms['id_rateForm']
														.submit();
											}
										</script>
										<p>
											<i>Rate this book: </i>
										<div class="rateit" name="userrating" id="rater1" step="1.0"
											onClick="$javascript:submitFormy()"></div>
										<form method="POST" action="rateBook.do" id="id_rateForm">
											<input type="hidden" name="isbn" value="${book.isbn13}" /> <input
												type="hidden" name="rating" value="" />
										</form>
									</c:when>
									<c:otherwise>
										<p>
											<i> Your rating of this book:</i>
										</p>
										<div style="white-space: nowrap;" class="rateit" id="rater3"
											data-rateit-readonly="true" data-rateit-value="${rating}"></div>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
						<!-- TODO: 
							make sure there's authorization for rating, currently any user can..
							-->



						<form class="form-inline" role="form" action="addBookToCart.do"
							method="post">
							<div class="form-group">
								<input type="hidden" name="isbn" value="${book.isbn13}" /> <input
									type="text" class="form-control" size="2" name="quantity"
									value="1" />
							</div>
							<button type="submit" class="btn btn-primary">Add to
								cart</button>
						</form>
						<form class="form-inline" role="form" action="addBookToList.do"
							method="post">
							<div class="form-group">
								<input type="hidden" name="isbn" value="${book.isbn13}" /> <select
									class="form-control" name="id">
									<c:forEach items="${customerLists}" var="item">
										<option value="${item.id}">${item.title}</option>
									</c:forEach>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">Add to
								list</button>
						</form>
					</div>
				</div>
				<div class="col-md-4">
					<img class="img-thumbnail"
						src="http://www4.alibris-static.com/isbn/${book.isbn13}.gif">
				</div>

				<c:choose>
					<c:when test="${empty customer }">
						<p>
							<i>Log in to review this book</i>
						</p>
					</c:when>
					<c:otherwise>
					<div class="col-md-3">
						<label>Write review:</label>
						<form action="addReview.do" id="id_Review" method="POST">
							<input type="hidden" name="isbn" value="${book.isbn13}" /> <input
								name="review">
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
							<div class="form-group"></div>
						</form>
						
										
				<form method="POST" id="idHelpful" action="markHelpful.do">
					<input type="hidden" name="helpful" />
					<input type="hidden" name="commentID" />
					<input type="hidden" name="isbn" value="${book.isbn13}" />
				</form>
				
				
				<script type="text/javascript">
					// 1 for helpful, 0 for not
					function markHelpFul(reviewID, helpFul)
					{
						document.forms['idHelpful'].commentID.value = reviewID;
						document.forms['idHelpful'].helpful.value = helpFul;
						document.forms['idHelpful'].submit();
						}
					</script>
					</c:otherwise>
				</c:choose>
						<c:forEach items="${reviews}" var="item">
								<p>${item.text}</p>
								<b>${item.thumbsUp}</b>
								<img height="20" width="20" src="./img/thumbUP.jpg"
								 		onClick='$javascript:markHelpFul(${item.id}, 1)'/>
								 <img height="20" width="20" src="./img/thumbUP.jpg"
								 		onClick='$javascript:markHelpFul(${item.id}, 0)'/>
								 <b>${item.thumbsDown}</b>
						</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
