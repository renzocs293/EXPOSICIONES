<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- BootStrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<!-- Google -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="700268559711-qu8fv57oq3jnfh9hip33ektrvraurphm.apps.googleusercontent.com">
</head>



<body>
	<!-- ======================================= -->
	<!--  NAVBAR -->
	<!-- ======================================= -->
	<nav
		class="navbar navbar-expand-lg navbar-dark bg-dark scrolling-navbar fixed-top">

		<a class="navbar-brand" href="#"> <img src="images/descarga.png"
			width="30" height="30" class="d-inline-block align-top" alt=""
			loading="lazy">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					routerLink="/productos">Hombre </a></li>
				<li class="nav-item "><a class="nav-link"
					routerLink="/productos">Mujer</a></li>
				<li class="nav-item "><a class="nav-link"
					routerLink="/productos">Niño</a></li>
				<li class="nav-item"><a class="nav-link"
					routerLink="/productos">Deporte</a></li>
				<li class="nav-item"><a class="nav-link"
					routerLink="/productos">Marcas</a></li>
			</ul>

		</div>
	</nav>
	
	<!--  -->
	
	<!-- BODY -->

	<div class="container">
		<div class="row" style="margin-top: 120px;">
			<div class="col" style="margin-bottom: 20px;">
				
				<div class="row">
					<div class="col" id="ff">
					<h3>INICIAR SESION</h3>
					<a href="#">¿Olvidaste tu contraseña?</a>

						<form #f="ngForm" (ngSubmit)="onLogin()" novalidate>
							<div class="md-form input-with-pre-icon">
								<i class="fas fa-user input-prefix"></i> <input type="text"
									name="email" id="email" class="form-control"
									[(ngModel)]="email" required> <label
									for="nombreUsuario">Email</label>
							</div>
							<div class="md-form input-with-pre-icon">
								<i class="fas fa-key input-prefix"></i> <input type="password"
									name="password" id="password" class="form-control"
									[(ngModel)]="password" required> <label for="password">Contraseña</label>
							</div>
							<div style="margin-bottom: 20px;">
								<button type="button " class="btn btn-dark"
									[disabled]="!f.valid">
									INICIAR SESION <img src="images/flechaIzquierdaOpaco.png "
										class="ml-4 ">
								</button>
							</div>
						</form>

					</div>
				</div>
			
				<div class="row">
					<div class="col">
						<div style="margin-bottom: 20px;">
							<div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
						</div>

						<img id="myImg"> <br>
						<p id="name"></p>


						<div id="status"></div>
						<button onclick="myFunction()">Sign Out</button>
					</div>
				</div>
			</div>
			<div class="col">
				<h3>CREAR UNA CUENTA</h3>
				<p>Crear una cuenta es fácil. Introduce tu dirección de correo
					electrónico, diligencia el formulario de la página siguiente y
					disfruta de los beneficios de tener una cuenta.</p>
				<ul style="list-style: none; padding-left: 10px;">
					<li><i class="far fa-check-circle"></i> <span>Una sola
							cuenta global con la que podrás acceder a todos los productos</span></li>
					<li><i class="far fa-check-circle"></i> <span>Finalizar
							tus pedidos más rápido</span></li>
					<li><i class="far fa-check-circle"></i> <span>Consultar
							tu historial de pedidos</span></li>
					<li><i class="far fa-check-circle"></i> <span>Añadir o
							modificar tus preferencias de correo electrónico</span></li>
				</ul>
				<div style="margin-bottom: 20px;">
					<button type="button" routerLink="/registro" class="btn btn-dark">
						REGISTRARSE <img src="images/flechaIzquierdaOpaco.png "
							class="ml-4 ">
					</button>
				</div>
			</div>
		</div>
	</div>

	
	

	<script type="text/javascript">
		function onSignIn(googleUser) {
			// window.location.href='success.jsp';

			var profile = googleUser.getBasicProfile();
			var imagurl = profile.getImageUrl();
			var name = profile.getName();
			var email = profile.getEmail();
			document.getElementById("myImg").src = imagurl;
			document.getElementById("name").innerHTML = name;

			// Si iniciamos sesion se oculta mi iniciarSesionGoogle
			document.getElementById("myP").style.visibility = "hidden";
			document.getElementById("ff").style.visibility = "hidden";

			// Traemos a este jsp
			document.getElementById("status").innerHTML = 'Bienvenido ' + name
					+ '!<a href=success.jsp?email=' + email + '&name=' + name
					+ '/> <br>Continue con Google login</a></p>'

		}
	</script>

	<script>
		function myFunction() {
			gapi.auth2.getAuthInstance().disconnect();
			location.reload();
		}
	</script>

</body>
</html>