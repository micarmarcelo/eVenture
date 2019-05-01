
<html>
	<head>
		<title>eVenture</title>
      	<link href="css/materialplusicons.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/homepage.css">
        <link rel="stylesheet" href="css/eventure.css">
        <link rel="stylesheet" href="css/search.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script src="jquery-3.0.0.min.js"></script>
       	<script>	
			$(document).ready(function(){
				$("a.category").click(function(){
					// get id of the clicked category button
					var categoryID = $(this).attr("id");
						
					// set value of hidden input to the id
					$("#hiddeninput-category").val(categoryID);
						
					// submit form automatically
					$("#search-by-category").submit();
				});
			});
		</script> 
	</head>

	<body>
    <nav>
          <div class="nav-wrapper">
            <a href="TopRatingServlet" class="brand-logo left-align">
                <img src="Photos/eVenture.png" id = "logotxt" alt = "eVenture"/>
            </a>
          <form action = "SearchServlet" method = "post" style = "margin-right:20px;">
            <div style = "float:right;">
               <div class="container-4" style = "padding-top:20px;">
                  <input name = "search" type="search" id="search" placeholder="Search..." />
                  <button class="dropdown-button icon"><i class="material-icons">search</i></button>
                </div>
            </div>
            <div style = "float:right;padding-top:20px;">
              <select name = "filter" class="browser-default" style = "color:black;height:2.4rem;">
                <option value="" disabled selected>Filter Search by</option>
                <option value="1">People</option>
                <option value="2">Event Services</option>
                <option value="3">Location</option>
              </select>
            </div>

          </form>
          </div>
    </nav>

  		<nav>
		    <div class="nav-wrapper">
		      <ul id="nav-mobile" class="center hide-on-med-and-down">
		        <li><a id = "1" class = "category" href="#">Photography & Videography</a></li>
		        <li><a id = "2" class = "category" href="#">Venue & Catering</a></li>
		        <li><a id = "3" class = "category" href="#">Fashion Design</a></li>
		        <li><a id = "4" class = "category" href="#">Make-Up Artist</a></li>
		         <li><a id = "5" class = "category" href="#">Sounds & Lights</a></li>
		      </ul>
		    </div>
  		</nav>
  		<label for="profile2" class="profile-dropdown">
                <input type="checkbox" id="profile2">
                <img src="https://cdn2.iconfinder.com/data/icons/the-world-faces/512/Pretty_Girl_Face_Avatar-512.png">
                <span><%= session.getAttribute("firstName") %> <%= session.getAttribute("lastName") %></span>
                <label for="profile2"><i class="mdi mdi-menu"></i></label>
                <ul>
                  <li><a href="GetUserEventServicesServlet"><i class="material-icons">perm_identity</i>My Profile</a></li>
                  <li><a href="editprofile.jsp"><i class="fa fa-edit small"></i>Edit Profile</a></li>
                  <li><a href="advertiseevent.jsp"><i class="material-icons">announcement</i>Advertise Event Service</a></li>
                  <li><a href="viewnotif.html"><i class="fa fa-bell small"></i></i>Notifications</a></li>
                  <li><a href="LogOutServlet"><i class="material-icons">power_settings_new</i></i>Logout</a></li>
                </ul>
        </label>

  		    
    <!-- PAGE CONTENT -->
    <div class="section no-pad-bot" id="index-banner">
      <div id = "container">
        <div class = "row center">  
          <div class="col s6 offset-s3 z-depth-5" id = "content-div">
                  <form class="col s12" id = "edit-profile-form" action = "UpdateUserServlet" method="post">
                      <div class='row'>
                        <div class='col s12 center-align'>
                          <img src = "Photos/editprofile.png" class = "homepage_icon"/>
                          <h4>EDIT PROFILE</h4>
                        </div>
                      </div>

                        <div class="row">
                          <div class="input-field col s6" >
                            <span class = "labels left">First Name</span>
                            <input name = "firstName" value = "<%= session.getAttribute("firstName") %>" id="first_name" type="text" minlength = "2"maxlength = "45" class="validate" required = "">
                          </div>

                          <div class="input-field col s6">
                            <span class = "labels left">Last Name</span>
                            <input name = "lastName" value="<%= session.getAttribute("lastName")%>" id="last_name" type="text" minlength "2" maxlength = "45" class="validate" required = "">
                          </div>
                        </div>
           
                        <div class="row">
                          <div class="input-field col s6">
                            <span class = "labels left">Age</span>
                            <input name = "age" value="<%= session.getAttribute("age")%>" id="age" type="number" min = "1" max = "99" class="validate" required = "">
                          </div>

                           <div class="input-field col s6">
                            <span class = "labels left">Gender</span><br>
                              <select name="gender" id="gender" class="browser-default" required = "">
                                  <option value="" disabled selected>Choose Gender</option>
                                  <option value="<%= session.getAttribute("gender")%>" selected='selected'><%= session.getAttribute("gender")%></option>
                                  <option value="Female">Female</option>
                                  <option value="Male">Male</option>
                              </select>
                          </div>
                        </div>
                  

                        <div class = "row">
                          <div class="input-field col s6">
                            <span class = "labels left">Email Address</span>
                            <input name = "emailAddress" value="<%= session.getAttribute("emailAddress")%>" id="email" type="email" minlength = "3" maxlength "254" class="validate" required = "">
                          </div>

                          <div class="input-field col s6">
                            <span class = "labels left">Location</span>
                            <select name="location" id="location" class="browser-default" required = "">
                                      <option value="" disabled selected>Choose Location</option>
									  <option value="<%= session.getAttribute("location")%>" selected='selected'><%= session.getAttribute("location")%></option>
                                      <!-- NATIONAL CAPITAL REGION -->
                                      <optgroup id="ncr" label="National Capital Region">
                                        <option value="Caloocan" label = "Caloocan">Caloocan</option>
                                        <option value="Las Pinas" label = "Las Pinas">Las Pinas</option>
                                        <option value="Makati" label = "Makati">Makati</option>
                                        <option value="Malabon" label = "Malabon">Malabon</option>
                                        <option value="Mandaluyong" label = "Mandaluyong">Mandaluyong</option>
                                        <option value="Manila" label = "Manila">Manila</option>
                                        <option value="Marikina" label = "Marikina"> Marikina</option>
                                        <option value="Muntinlupa" label = "Muntinlupa">Muntinlupa</option>
                                        <option value="Navotas" label = "Navotas">Navotas</option>
                                        <option value="Paranaque" label = "Paranaque">Paranaque</option>
                                        <option value="Pasay" label = "Pasay">Pasay</option>
                                        <option value="Pasig" label = "Pasig">Pasig</option>
                                        <option value="Quezon City" label = "Quezon City">Quezon City</option>
                                        <option value="San Juan" label = "San Juan">San Juan</option>
                                        <option value="Taguig" label = "Taguig">Taguig</option>
                                        <option value="Valenzuela" label = "Valenzuela">Valenzuela</option>
                                      </optgroup>

                                      <!-- REGION I -->
                                      <optgroup id="region1" label="Region I">
                                        <option value="Ilocos Norte" label = "Ilocos Norte">Ilocos Norte</option>
                                        <option value="Ilocos Sur" label = "Ilocos Sur">Ilocos Sur</option>
                                        <option value="La Union" label = "La Union">La Union</option>
                                        <option value="Pangasinan" label = "Pangasinan">Pangasinan</option>
                                      </optgroup>

                                      <!-- REGION II -->
                                      <optgroup id="region2" label="Region II">
                                        <option value="Cagayan" label = "Cagayan">Cagayan</option>
                                        <option value="Isabela" label = "Isabela">Isabela</option>
                                      </optgroup>

                                      <!-- REGION III -->
                                      <optgroup id="region3" label="Region III">
                                        <option value="Bataan" label = "Bataan">Bataan</option>
                                        <option value="Bulacan" label = "Bulacan">Bulacan</option>
                                        <option value="Nueva Ecija" label = "Nueva Ecija">Nueva Ecija</option>
                                        <option value="Pampanga" label = "Pampanga">Pampanga</option>
                                        <option value="Tarlac" label = "Tarlac">Tarlac</option>
                                        <option value="Zambales" label = "Zambales">Zambales</option>
                                      </optgroup>

                                      <!-- REGION IV -->
                                      <optgroup id="region4" label="Region IV">
                                        <option value="Batangas" label = "Batangas">Batangas</option>
                                        <option value="Cavite" label = "Cavite">Cavite</option>
                                        <option value="Laguna" label = "Laguna">Laguna</option>
                                        <option value="Quezon" label = "Quezon">Quezon</option>
                                        <option value="Rizal" label = "Rizal">Rizal</option>
                                        <option value="Oriental Mindoro" label = "Oriental Mindoro">Oriental Mindoro</option>
                                         <option value="Palawan" label = "Palawan">Palawan</option>
                                      </optgroup>

                                      <!-- REGION V -->
                                      <optgroup id="region5" label="Region V">
                                        <option value="Albay" label = "Albay">Albay</option>
                                        <option value="Camarines Sur" label = "Camarines Sur">Camarines Sur</option>
                                        <option value="Masbate" label = "Masbate">Masbate</option>
                                        <option value="Sorsogon" label = "Sorsogon">Sorsogon</option>
                                      </optgroup>

                                       <!-- REGION VI -->
                                      <optgroup id="region6" label="Region VI">
                                        <option value="Capiz" label = "Capiz">Capiz</option>
                                        <option value="Iloilo" label = "Iloilo">Iloilo</option>
                                      </optgroup>

                                       <!-- REGION VII -->
                                      <optgroup id="region7" label="Region VII">
                                        <option value="Bohol" label = "Bohol">Bohol</option>
                                        <option value="Cebu" label = "Cebu">Cebu</option>
                                      </optgroup>

                                      <!-- REGION VIII -->
                                      <optgroup id="region8" label="Region VIII">
                                        <option value="Eastern Samar" label = "Eastern Samar">Eastern Samar</option>
                                        <option value="Leyte" label = "Leyte">Leyte</option>
                                        <option value="Western Samar" label = "Western Samar">Western Samar</option>
                                      </optgroup>

                                       <!-- REGION IX -->
                                      <optgroup id="region9" label="Region IX">
                                        <option value="Basilan" label = "Basilan">Basilan</option>
                                        <option value="Zamboanga del Norte" label = "Zamboanga del Norte">Zamboanga del Norte</option>
                                        <option value="Zamboanga del Sur" label = "Zamboanga del Sur">Zamboanga del Sur</option>
                                      </optgroup>

                                      <!-- REGION X -->
                                      <optgroup id="region10" label="Region X">
                                        <option value="Bukidnon" label = "Bukidnon">Bukidnon</option>
                                        <option value="Lanao del Norte" label = "Lanao del Norte">Lanao del Norte</option>
                                        <option value="Misamis Occidental" label = "Misamis Occidental">Misamis Occidental</option>
                                        <option value="Misamis Oriental" label = "Misamis Oriental">Misamis Oriental</option>
                                      </optgroup>

                                      <!-- REGION XI -->
                                      <optgroup id="region11" label="Region XI">
                                        <option value="Davao del Norte" label = "Davao del Norte">Davao del Norte</option>
                                        <option value="Davao del Sur" label = "Davao del Sur">Davao del Sur</option>
                                        <option value="Davao Oriental" label = "Davao Oriental">Davao Oriental</option>
                                      </optgroup>

                                      <!-- REGION XII -->
                                      <optgroup id="region11" label="Region XI">
                                        <option value="Maguindanao" label = "Maguindanao">Maguindanao</option>
                                        <option value="North Cotabato" label = "North Cotabato">North Cotabato</option>
                                        <option value="South Cotabato" label = "South Cotabato">South Cotabato</option>
                                        <option value="Sultan Kudarat" label = "Sultan Kudarat">Sultan Kudarat</option>
                                      </optgroup>

                                       <!-- REGION XIII -->
                                      <optgroup id="region13" label="Region XIII">
                                        <option value="Agusan del Norte" label = "Agusan del Norte">Agusan del Norte</option>
                                        <option value="Agusan del Sur" label = "Agusan del Sur">Agusan del Sur</option>
                                        <option value="Surigao del Norte" label = "Surigao del Norte">Surigao del Norte</option>
                                         <option value="Surigao del Sur" label = "Surigao del Sur">Surigao del Sur</option>
                                      </optgroup>

                                       <!-- ARMM -->
                                      <optgroup id="armm" label="Autonomous Region in Muslim Mindanao">
                                        <option value="Basilan" label = "Basilan">Basilan</option>
                                        <option value="Lanao del Sur" label = "Lanao del Sur">Lanao del Sur</option>
                                      </optgroup>

                                       <!-- CAR -->
                                      <optgroup id="car" label="Cordillera Administrative Region">
                                        <option value="Benguet" label = "Benguet">Benguet</option>
                                        <option value="Kalinga" label = "Kalinga">Kalinga</option>
                                      </optgroup>

                                      <!-- NIR -->
                                      <optgroup id="nir" label="Negros Island Region">
                                        <option value="Negros Occidental" label = "Negros Occidental">Negros Occidental</option>
                                        <option value="Negros Oriental" label = "Negros Oriental">Negros Oriental</option>
                                      </optgroup>
                            </select>
                          </div>
                        </div>

                        <div class="row">
                          <div class="input-field col s12">
                            <span class = "labels left">Contact Information</span>
                            <textarea name = "contactNum" id="contactNo" type="text" class="validate"><%= session.getAttribute("contactNum")%></textarea>
                          </div>
                        </div>
                  
                        <div class="row">
                          <div class="input-field col s12">
                            <span class = "labels left">Bio</span>
                            <textarea name = "bio" id="bio" type="text" class="validate"><%= session.getAttribute("bio")%></textarea>
                          </div>
                        </div>

                        

                    <br />
                    <center>
                      <div class='row col s6 offset-s3'>
                        <button type='submit' name='btn_login' class='col s12 brown btn btn-large waves-effect indigo'>SAVE CHANGES</button>
                      </div>
                    </center>
                  </form>
                
              


          </div>
        </div>
      </div>
    </div>
	<!-- HIDDEN FORMS -->
     <form id = "search-by-category" action = "SearchByCategServlet" method = "POST">
		<input name = "categoryID" type="hidden" id="hiddeninput-category">
	 </form>
	

	</body>
  
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="js/materialize.js"></script>

</html>