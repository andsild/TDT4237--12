<div class="container">
<c:choose>
 <c:when test="${not empty bookList}">
 <h2>${bookList.title}</h2>
 <p>${bookList.description}
				<div class="list-group">
 	<c:forEach items="${bookList.list}" var="item">
				<div class="list-group-item">
					<h4 class="list-group-heading"><a href="viewBook.do?isbn=${item.value.isbn13}">${item.value.title.name}</a></h4>
					<p class="list-group-item-text">${item.value.description}</p>
				</div>
 	</c:forEach>
				</div>
 		
 </c:when>
 <c:when test="${not empty customerLists}">
 	<h2>Your booklists</h2>
 	<div class="list-group">
 	<c:forEach items="${customerLists}" var="item">
 		<div class="list-group-item">
					<h4 class="list-group-heading"><a href="bookList.do?id=${item.id}">${item.title}</a></h4>
					<p class="list-group-item-text">${item.description}</p>
				</div>
 	</c:forEach>
 	</div>
 </c:when>
 <c:otherwise>
 	<div class="list-group">
 	<c:forEach items="${bookListArray}" var="item">
 		<div class="list-group-item">
					<h4 class="list-group-heading"><a href="bookList.do?id=${item.id}">${item.title}</a></h4>
					<p class="list-group-item-text">${item.description}</p>
				</div>
 	</c:forEach>
 	</div>
 </c:otherwise>
</c:choose>

</div>