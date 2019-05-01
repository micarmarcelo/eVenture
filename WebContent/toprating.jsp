<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<title>eVenture - Top Rating Event Servies</title>
      	<link href="css/materialplusicons.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/homepage.css">
        <link rel="stylesheet" href="css/eventure.css">
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/toprating.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">
        <link href="css/jquery.nailthumb.1.1.css" type="text/css" rel="stylesheet" />
        <script src="js/sweetalert.min.js"></script> <link rel="stylesheet" type="text/css" href="css/sweetalert.css">
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
		<script>	
			$(document).ready(function(){
				$("a.see-all").click(function(){
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
				$("a.view-event-service").click(function(){
					// get id of the clicked event service button
					var eventID = $(this).attr("id");
					// set value of hidden input to the id
					$("#hiddeninput-eventservice").val(eventID);
					// submit form automatically
					$("#view-event-service-form").submit();
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
                <img src="https://cdn1.iconfinder.com/data/icons/avatar-1-1/512/Avatar_17-512.png">
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

            <div class="row center">
              <div class = "col s12" id = "category-header">
                  <h4> Top Rating Event Service </h4>
                  <hr class="style11">
              </div>
            </div>

            <!--Photography & Videography-->
            <div class="col s12" id="category-col">
              <h5>Photography & Videography</h5>
              <a id = "1" href="#" class="see-all">See all</a>
            </div>
            <br><br><br>
            	
            	<c:if test = "${empty(top1)}">
		          <span class="black-text"> <i> No top-rating event-services found. </i></span>
		        </c:if>
		        <c:if test = "${not empty(top1)}">
		            <div class="flexslider">
		              <ul class="slides">
		              	<c:forEach var="c" items="${top1}">
			                <li class="slides-li">
			                  <a id = "${c.eventID}" href="#" class = "view-event-service">
			                    <div class="nailthumb-container square-thumb  nailthumb-image-titles-animated-onhover">
			                      <img src="Photos/event_logos/photog1.jpg" title="${c.eventName}"/>
			                    </div>
			                  </a>
			                </li>
						</c:forEach>
		                
		              </ul>
		            </div>
	            </c:if>
			
            <div class="col s12" id="category-col">
                  <h5>Venue & Catering</h5>
                  <a id = "2" href="#" class="see-all">See all</a>
            </div>
                  <br><br><br>
                  <c:if test = "${empty(top2)}">
		          	<span class="black-text"> <i> No top-rating event-services found. </i></span>
		          </c:if>
		        <c:if test = "${not empty(top2)}">
                  <div class="flexslider">
		              <ul class="slides">
		              	<c:forEach var="c" items="${top2}">
			                <li class="slides-li">
			                  <a id = "${c.eventID}" href="#" class = "view-event-service">
			                    <div class="nailthumb-container square-thumb  nailthumb-image-titles-animated-onhover">
			                      <img src="Photos/event_logos/venue1.jpg" title="${c.eventName}"/>
			                    </div>
			                  </a>
			                </li>
		                </c:forEach>

		              </ul>
            	  </div>
            	 </c:if>

            <!--Fashion Design-->
            <div class="col s12" id="category-col">
                <h5>Fashion Design</h5>
                <a id = "3" class="see-all">See all</a>
            </div>
                <br><br><br>
                  <c:if test = "${empty(top3)}">
		          	<span class="black-text"> <i> No top-rating event-services found. </i></span>
		          </c:if>
		        <c:if test = "${not empty(top3)}">
		            <div class="flexslider">
		              <ul class="slides">
			              <c:forEach var="c" items="${top3}">
			                <li class="slides-li">
			                  <a id = "${c.eventID}" href="#" class = "view-event-service">
			                    <div class="nailthumb-container square-thumb  nailthumb-image-titles-animated-onhover">
			                      <img src="Photos/event_logos/fashion2.jpg" title="${c.eventName}"/>
			                    </div>
			                  </a>
			                </li>
						</c:forEach>
		              </ul>
		            </div>
		         </c:if>

			
            <!--Make-up Artist-->
            <div class="col s12" id="category-col">
              <h5>Make-up Artist</h5>
              <a id = "4" href="#" class="see-all">See all</a>
           	</div>
            <br><br><br>
            <c:if test = "${empty(top4)}">
		    	<span class="black-text"> <i> No top-rating event-services found. </i></span>
		    </c:if>
		    <c:if test = "${not empty(top4)}">            
	            <div class="flexslider">
	              <ul class="slides">
	              	<c:forEach var="c" items="${top4}">
		                <li class="slides-li">
		                  <a id = "${c.eventID}" href="#" class = "view-event-service">
		                    <div class="nailthumb-container square-thumb  nailthumb-image-titles-animated-onhover">
		                      <img src="Photos/event_logos/makeup4.jpg" title="${c.eventName}"/>
		                    </div>
		                  </a>
		                </li>
	               </c:forEach> 
	              </ul>
	            </div>
            </c:if>
           

            <!--Sounds and Lights-->
            <div class="col s12" id="category-col">
               <h5>Sounds and Lights</h5>
               <a id = "5" href="#" class="see-all">See all</a>
            </div>
            <br><br><br>
            <c:if test = "${empty(top5)}">
		    	<span class="black-text"> <i> No top-rating event-services found. </i></span>
		    </c:if>
		    <c:if test = "${not empty(top5)}"> 
            <div class="flexslider">
              <ul class="slides">
              	<c:forEach var="c" items="${top5}">
	                <li class="slides-li">
	                  <a id = "${c.eventID}" href="#" class = "view-event-service">
	                    <div class="nailthumb-container square-thumb  nailthumb-image-titles-animated-onhover">
	                      <img src="Photos/event_logos/soundlight1.jpg" title="${c.eventName}"/>
	                    </div>
	                  </a>
	                </li>
				</c:forEach>
              </ul>
              
            </div>
            </c:if>

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
  <script type="text/javascript" src="js/jquery.flexslider.js"></script>

  <script type="text/javascript" src="js/jquery.nailthumb.1.1.js"></script>
  <script type="text/javascript">
    jQuery(document).ready(function() {
      jQuery('.nailthumb-image-titles-animated-onhover').nailthumb();
      jQuery('.nailthumb-image-titles-onhover').nailthumb({animateTitle:false});
    });
  </script>

  <script type="text/javascript">
        $(window).load(function() {
      $('.flexslider').flexslider({
        animation: "slide",
        animationLoop: false,
        itemWidth: 300,
        itemMargin: 5,
        minItems: 2,
        maxItems: 4
      });
    });      
  </script>


</html>