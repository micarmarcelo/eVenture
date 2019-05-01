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
        <link rel="stylesheet" href="css/eventure.css">
        <link rel="stylesheet" href="css/search.css">
        <link rel="stylesheet" href="css/icons.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<script src="jquery-3.0.0.min.js"></script>
	    <script>	
			$(document).ready(function(){
				$("a.viewfullprofile").click(function(){
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
		<script>
			$(document).ready(function(){
				$("a.viewuser").click(function(){
					// get id of the clicked category button
					var userID = $(this).attr("id");
						
					// set value of hidden input to the id
					$("#hiddeninput-profile").val(userID);
						
					// submit form automatically
					$("#view-profile-form").submit();
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
        <div class = "row center">  
          <div class="col s8 offset-s2">
            <!-- Content page content  -->
              <br>
              
              
              <div class="row">
                <div class = "col s12" style id = "category-header">
                   <c:choose>
                   		<c:when test = "${categoryID == 1}">
                   			<span class = "icon-camera">
                   			</span>
                   		</c:when>
                   		<c:when test = "${categoryID == 2}">
                   			<span class = "icon-catering">
                   			</span>
                   		</c:when>
                   		<c:when test = "${categoryID == 3}">
                   			<span class = "icon-makeup">
                   			</span>
                   		</c:when>
                   		<c:when test = "${categoryID == 4}">
                   			<span class = "icon-sounds">
                   			</span>
                   		</c:when>
                   		<c:when test = "${categoryID == 5}">
                   			<span class = "icon-camera">
                   			</span>
                   		</c:when>
                   </c:choose>
                   <h4>${categoryName} </h4>
                   <hr class="style11">
                </div>

                <br><br><br><br>
                
               	<c:forEach var = "c" items = "${users}">
				<div class="col s12 m4">
		          <div class="card">
		            <div class="card-image">
		              <img src="Photos/my_dp.jpg">
		            </div>
		            <div class="card-content">
		              <p>${c.firstName} ${c.lastName}<br>@${c.username}</p><br>
		              <a href="#" id = "${c.userID}" class = "viewuser">View User's Profile</a>
		            </div>
		          </div>
		        </div>					
				</c:forEach>
				
                <c:forEach var = "c" items = "${events}">
                <div class="col s12 m4">
				  <div class="card">
				    <div class="card-image waves-effect waves-block waves-light">
				      
				        <c:choose>
	                   		<c:when test = "${categoryID == 1}">
								<img class="activator" src="Photos/portfolio/1_p1.jpg">
	                   		</c:when>
	                   		<c:when test = "${categoryID == 2}">
	                   			<img class="activator" src="Photos/portfolio/2_p1.jpg">
	                   		</c:when>
	                   		<c:when test = "${categoryID == 3}">
	                   			<img class="activator" src="Photos/portfolio/3_p4.jpg">
	                   		</c:when>
	                   		<c:when test = "${categoryID == 4}">
	                   			<img class="activator" src="Photos/portfolio/4_p4.jpg">
	                   		</c:when>
	                   		<c:when test = "${categoryID == 5}">
								<img class="activator" src="Photos/portfolio/5_p1.jpg">
	                   		</c:when>
                   		</c:choose>
				    </div>
				    <div class="card-content">
				      <span class="card-title activator grey-text text-darken-4"> ${c.eventName} <i class="material-icons right">more_vert</i></span>
				      <p><a href="#" id = "${c.eventID}" class = "viewfullprofile">View Full Profile</a></p>
				    </div>
				    <div class="card-reveal">
				      <span class="card-title grey-text text-darken-4"><i class="material-icons right">close</i></span>
				      <p><br><br><br><br> Overall Rating: ${c.avgRating} out of 5 <br> 
						 <c:choose>
		                        	<c:when test = "${c.floorRating == 1}">
		                          		<img src="Photos/rating/1-star.png" id = "rating-pic"/> 
		                          	</c:when>
		                          	
		                          	<c:when test = "${c.floorRating == 2}">
		                          		<img src="Photos/rating/2-star.png" id = "rating-pic"/> 
		                          	</c:when>
		                          	
		                         	<c:when test = "${c.floorRating == 3}">
		                          		<img src="Photos/rating/3-star.png" id = "rating-pic"/> 
		                          	</c:when>
		                          	
		                       		<c:when test = "${c.floorRating == 4}">
		                          		<img src="Photos/rating/4-star.png" id = "rating-pic"/> 
		                          	</c:when>
		                          	
		                         	<c:when test = "${c.floorRating == 5}">
		                          		<img src="Photos/rating/5-star.png" id = "rating-pic"/> 
		                          	</c:when>
		                        </c:choose>
		             </p>
				    </div>
				  </div>
                </div>
				</c:forEach>


        </div>


        </div>
      </div>


    </div>
    
    <!-- HIDDEN FORMS -->
     <form id = "view-profile-form" action = "ViewOthersProfileServlet" method = "POST">
		<input name = "userID" type="hidden" id="hiddeninput-profile">
	 </form>
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