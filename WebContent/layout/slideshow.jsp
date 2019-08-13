<div class="container ">
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel" data-interval="4000">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="${pageContext.request.contextPath }/assets/imgs/one.jpg"
					class="d-block w-100 myslideshow" alt="...">
			</div>
			<div class="carousel-item">
				<img src="${pageContext.request.contextPath }/assets/imgs/three.png"
					class="d-block w-100 myslideshow" alt="...">
			</div>
			<div class="carousel-item">
				<img src="${pageContext.request.contextPath }/assets/imgs/two.png"
					class="d-block w-100 myslideshow" alt="...">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</div>