<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>eVenture</title>
      <link href="css/materialplusicons.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/homepage.css">
         <script src="js/sweetalert.min.js"></script> <link rel="stylesheet" type="text/css" href="css/sweetalert.css">
        <script src= "http://code.jquery.com/jquery-2.1.1.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body>
    <div class="navbar-fixed">
        <nav>
          <div class="nav-wrapper">
            <a href="homepage.jsp" class="brand-logo center">
                <img src="Photos/eVenture.png" id = "logotxt" alt = "eVenture"/>
            </a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
              <li><a href="#modal_signup" class="menu modal-trigger">Sign Up</a></li>
              <li><a href="#modal_login" class="menu modal-trigger">Log In</a></li>
              <li><a href="#about">About</a></li>
              <li><a href = "#developers">Developers</a></li>
            </ul>
          </div>
        </nav>
     </div>

     <!-- SLIDER EFFECT -->
     <div class="row">
        <div class="slider">
          <ul class="slides">
              <li>
                <img src="Photos/homepage/slide1.jpg">
                <div class="caption center-align">
                  <p class="z-depth-4">
                    <h1>eVenture</h1>
                    <h5 class="light grey-text text-lighten-3">Make dream events come into a reality</h5>
                  </p>
                </div>
              </li>
              <li>
                <img src="Photos/homepage/slide2.jpg">
                <div class="caption left-align">
                  <p class="z-depth-4">
                    <h3>Are you providing event services?</h3>
                    <h5 class="light grey-text text-lighten-3">Join the growing community of event personnel!</h5>
                  </p>
                </div>
              </li>
              <li>
                <img src="Photos/homepage/slide3.jpg">
                <div class="caption right-align">
                    <h3>Are you in need of services?</h3>
                    <h5 class="light grey-text text-lighten-3">Browse through eVenture and connect with event personells to address your needs.</h5>
                </div>
              </li>
          </ul>
        </div>
      </div>
      <br>

      <div class="section no-pad-bot" id="index-banner">
        <div id = "container">
          <!-- ABOUT -->
          <div class = "row" id = "about">
            <div class = "col s6 offset-s3" id = "headers"> 
              <h4 class = "center-align"> ABOUT </h4> </div>
            </div>
            <div class = "row" >
                <div class = "col s3 offset-s3 white">
                  INSERT LOGO HERE <br><br><br><br><br><br><br>
                </div>

                <div class = "col s3">
                  eVenture is a hub specially dedicated for the event personnels: people who make dream
                  events come into a reality. It is a place for them to advertise and connect themselves
                  with the event planners which are the people who are interested in the services they offer.
                </div>
            </div>
          </div>
          <br><br>
          <!-- DEVELOPERS -->
          <div class="row" id = "developers">
            <div class = "col s6 offset-s3" id = "headers"> 
              <h4 class = "center-align"> DEVELOPERS </h4> </div>
            </div>
            <div class = "row">
              <div class = "col s2 offset-s3">
                <div class="card z-depth-4" id = "card">
                  <div class="card-image">
                    <img src="Photos/developers/micaella.jpg" class = "developer" width:"100" height:"100">
                    <span class="card-title">Marcelo, Micaella</span>
                  </div>
                  <div class="card-content">
                    <p>I love Tobiby <3.</p>
                  </div>
                  <div class="card-action">
                    <a href="#">This is a link</a>
                  </div>
                </div>
              </div>
              <div class = "col s2">
                <div class="card z-depth-4" id = "card">
                  <div class="card-image">
                    <img src="Photos/developers/danica.jpg" class = "developer" width:"100" height:"100">
                    <span class="card-title">Sevilla, Danica</span>
                  </div>
                  <div class="card-content">
                    <p>18. A walter mitty at heart.</p>
                  </div>
                  <div class="card-action">
                    <a href="#">This is a link</a>
                  </div>
                </div>
              </div>
              <div class = "col s2">
                <div class="card z-depth-4" id = "card">
                  <div class="card-image">
                    <img src="Photos/developers/denise.jpg" class = "developer" width:"100" height:"100">
                    <span class="card-title">Silva, Denise Anne</span>
                  </div>
                  <div class="card-content">
                    <p>18. Hugot Queen. </p>
                  </div>
                  <div class="card-action">
                    <a href="#">This is a link</a>
                  </div>
                </div>
              </div>
            </div>
        </div>
      </div>

       <footer class="page-footer">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2016 Copyright eVenture
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>

      <!-- MODAL FOR LOGIN -->
      <div id = "modal_login" class="modal z-depth-5">
        <div class="modal-content">

          <form class="col s12" action = "LogInServlet" method="post">
            <div class='row'>
              <div class='col s12 center-align'>
                <img src = "Photos/mainpage_login.png" width = "100" height = "100"></img>
              </div>
            </div>

            
            <div class='row'>
               <div class="input-field col s6" >
                  <div id="username">
                    <span class="icon"><i class="fa fa-user" aria-hidden="true"></i></span>
                    <input name = "username" type="text" id = "login-username" placeholder="Username" minlength = "2" maxlength = "25" required = "" class = "validate">
                  </div>
                </div>
            </div>

            <div class = "row">
               <div class = "input-field col s6">
                  <div id="password">
                    <span class="icon"><i class="fa fa-lock"></i></span>
                    <input name = "password" type="password" id = "login-password" placeholder="Password" minlength = "8" maxlength = "20" class="validate" required = "">
                  </div>
                </div>
            </div>

            <br />
            <center>
              <div class='row'>
                <button type='submit' name='btn_login' class='col s12 brown btn btn-large waves-effect indigo'>Login</button>
              </div>
            </center>
          </form>
        </div>
      </div>

      <!-- MODAL FOR SIGNUP -->
      <div id = "modal_signup" class="modal z-depth-5">
        <div class="modal-content">
          <form class="col s12" id = "signup-form" action = "SignUpServlet" method="post">
            <div class='row'>
              <div class='col s12 center-align'>
                <img src = "Photos/mainpage_signup.png" width = "100" height = "100"/>
              </div>
            </div>

                <div class="row">
                  <div class="input-field col s6" >
                    <input name = "firstName" id="first_name" type="text" minlength = "2" maxlength = "45" class="validate" required = "">
                    <label for="first_name">First Name *</label>
                  </div>

                  <div class="input-field col s6">
                    <input name = "lastName" id="last_name" type="text" minlength "2" maxlength = "45" class="validate" required = "">
                    <label for="last_name">Last Name *</label>
                  </div>
                </div>
   
                <div class="row">
                  <div class="input-field col s12">
                    <input name = "emailAddress" id="email" type="email" type="email" minlength = "3" maxlength "254" class="validate" required = "">
                    <label for="email">Email Address *</label>
                  </div>
                </div>

                <div class="row">
                  <div class="input-field col s12">
                    <input name = "username" id="username" type="text" minlength = "2" maxlength = "25" class="validate" required = "">
                    <label for="username">Username *</label>
                  </div>
                </div>
         

                <div class="row">
                  <div class="input-field col s12">
                    <input name = "password" id="pass1" type="password" minlength = "8" maxlength = "20" class="validate" required = "">
                    <label for="password">Password *</label>
                  </div>
                </div>

                <div class="row">
                  <div class="input-field col s12">
                    <input id="pass2" type="password" onkeyup = "checkPass(); return false;" minlength = "8" maxlength = "20" class="validate" required = "" >
                    <label for="repassword">Confirm password *</label>
                    <span id="confirmMessage" class="confirmMessage"></span>
                  </div>
                </div>

              <label style='float: left;'>
                <span class='pink-text'><b>* Required</b></span>
              </label>
                

            <br /> <br>
            <center>
              <div class='row'>
                <button id = "submit-signup" type='submit' name='btn_login' class='col s12 brown btn btn-large waves-effect indigo'>SIGN UP</button>
              </div>
            </center>
          </form>
        </div>
      </div>


     

    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
    <script type="text/javascript"> 
        $(document).ready(function(){
          $('.slider').slider({full_width: true});
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
          $('.modal-trigger').leanModal();
        });
    </script>
	<script>
		function checkPass()
		{
		    //Store the password field objects into variables ...
		    var pass1 = document.getElementById('pass1');
		    var pass2 = document.getElementById('pass2');
		    //Store the Confimation Message Object ...
		    var message = document.getElementById('confirmMessage');
		    //Set the colors we will be using ...
		    var goodColor = "transparent";
		    var badColor = "red";
		    //Compare the values in the password field 
		    //and the confirmation field
		    if(pass1.value == pass2.value){
		        //The passwords match. 
		        //Set the color to the good color and inform
		        //the user that they have entered the correct password 
		        pass2.style.backgroundColor = goodColor;
		        message.style.color = "black";
		        message.innerHTML = "Passwords Match!";
		        document.getElementById("submit-signup").disabled = false;
		    }else{
		        //The passwords do not match.
		        //Set the color to the bad color and
		        //notify the user.
		        pass2.style.backgroundColor = goodColor;
		        message.style.color = badColor;
		        message.innerHTML = "Passwords Do Not Match!";
		        document.getElementById("submit-signup").disabled = true;
		    }
		}  
	</script>
	
	<script type="text/javascript">
		var Msg ='<%=request.getAttribute("getAlert")%>';
		if(Msg == "signup"){
			
		}
		else if(Msg == "failed"){
		    	function alertName(){
		 			swal({title: "Error!", 
		 				text: "Username & Password did not match.", 
		 				type: "error",
		 				timer: 2500,
		 				showConfirmButton: false	
		 			});
				} 
		    }
		 else if(Msg == "taken"){
			 function alertName(){
		 			swal({title: "Error!", 
		 				text: "Email or Username is already taken.", 
		 				type: "error",
		 				timer: 2500,
		 				showConfirmButton: false	
		 			});
				} 
		 }
	</script> 
	<script type="text/javascript"> window.onload = alertName; </script>
  </body>
</html>