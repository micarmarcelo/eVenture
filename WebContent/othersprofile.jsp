<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				$("button").click(function(){
						// get id of the clicked event service button
						var eventID = $(this).attr("id");
						
						// set value of hidden input to the id
						$("#hiddeninput-eventservice").val(eventID);
						
						// submit form automatically
						$("#view-event-service-form").submit();

				});
			});
		</script> 
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
                <span><%= session.getAttribute("firstName") %> <%= session.getAttribute("lastName")%></span>
                <label for="profile2"><i class="mdi mdi-menu"></i></label>
                <ul>
                  <li><a href="GetUsersEventServicesServlet"><i class="material-icons">perm_identity</i>My Profile</a></li>
                  <li><a href="editprofile.jsp"><i class="fa fa-edit small"></i>Edit Profile</a></li>
                  <li><a href="advertiseevent.jsp"><i class="material-icons">announcement</i>Advertise Event Service</a></li>
                  <li><a href="viewnotif.html"><i class="fa fa-bell small"></i></i>Notifications</a></li>
                  <li><a href="LogOutServlet"><i class="material-icons">power_settings_new</i></i>Logout</a></li>
                </ul>
        </label>

  		    
    <!-- PAGE CONTENT -->
    <div class="section no-pad-bot" id="index-banner">
      <div id = "container">
        <div class = "row center-align">  
           <div class="container about">
              <h5>${user.firstName} ${user.lastName}</h5>
              <h6>Know More About Me</h6>
              <hr>
              <div class="row">
                <div class="col s12 m4 l4">
                  <h6> PROFILE </h6>
                  <div class="card" style = "background-color:#f2e3c6">
                    <div class="card-content">
                      <img src="Photos/my_dp.jpg" width = "250" height = "250">
                      <p style = "color:#424242;"> 50.7k Followers <br>
                          50 Following <br>
                          Been trusted by 980 clients.<br>
                         
                      </p>
                    </div>
                    <div class="card-action">
                      <a href="#">Facebook</a>
                      <a href='#'>Twitter</a>
                      <a href='#'>Instagram</a>
                      <a href='#'>Wordpress</a>
                    </div>
                  </div>
                </div>
                <div class="col s12 m4 l4">
                  <h6>PERSONAL INFORMATION </h6>
                  <table class = "bordered striped">
                    <tbody>
                      <tr>
                        <td> Gender: </td>
                        <td> ${user.gender} </td>
                      </tr>

                      <tr>
                        <td> Age: </td>
                        <td> ${user.age} </td>
                      </tr>

                      <tr>
                        <td> Email Address: </td>
                        <td> ${user.emailAddress} </td>
                      </tr>

                      <tr>
                        <td> Contact Number: </td>
                        <td> ${user.contactNum} </td>
                      </tr>

                      <tr>
                        <td> Location: </td>
                        <td> ${user.location} </td>
                      </tr>

                      <tr>
                        <td>  Bio: </td>
                        <td> ${user.bio} </td>
                      </tr>

                    </tbody>

                  </table>
                  <p>© 2016 Eventure. All Rights Reserved. </p>
                </div>

                <div class="col s12 m4 l4">
                  <h6>EVENT SERVICES OFFERED</h6>
                  <ul class="collapsible">
                  	  <c:if  test = "${empty(eventslist)}">
				      		<span class="black-text"> <i> NO EVENT SERVICES </i></span>
					  </c:if>
	                  <c:forEach var ="c" items ="${eventslist}"> 
	                  
	                    <li class="active">
	                      <div class="collapsible-header"><i class="material-icons">stars</i>${c.eventName}</div>
	                      <div class="collapsible-body"><p> Overall Rating: ${c.avgRating} 
	                      		<button id = "${c.eventID}" class = "btnhreflike"> View Event Service </button></p>
	                      </div>
	                    </li>
	              
	                  </c:forEach>
                  </ul>
                </div>
              </div>
           </div>
        </div>
      </div>
    </div>
    
     <!-- HIDDEN FORMS -->
     <form id = "view-event-service-form" action = "ViewEventServiceServlet" method = "POST">
		<input name = "eventID" type="hidden" id="hiddeninput-eventservice">
	 </form>
	 <form id = "search-by-category" action = "SearchByCategServlet" method = "POST">
		<input name = "categoryID" type="hidden" id="hiddeninput-category">
	 </form>


	</body>

	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>

</html>