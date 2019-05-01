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
        <link rel="stylesheet" href="css/star.css">
        <link rel="stylesheet" href="css/search.css">
        <script src="js/sweetalert.min.js"></script> <link rel="stylesheet" type="text/css" href="css/sweetalert.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script src="jquery-3.0.0.min.js"></script>
	    <script>	
			$(document).ready(function(){
				$("button.btnhreflike").click(function(){
					// get id of the clicked event service button
					var userID = $(this).attr("id");
						
					// set value of hidden input to the id
					$("#hiddeninput-profile").val(userID);
						
					// submit form automatically
					$("#view-profile-form").submit();
					
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
        <div class = "row center-align">
            <div class="container portfolio">
              <h5>${event.eventName}</h5>
              <h6>|| Gallery ||</h6>
              <hr>
              <div class="row">
                <div class="col s12 m12 l12 portfolio-holder">
                   <c:choose>
                  	<c:when test = "${categoryID == 1}">
                  		<img class="materialboxed" src="Photos/portfolio/1_p1.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/1_p2.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/1_p3.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/1_p4.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/1_p5.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/1_p6.jpg"/>
                  	</c:when>
                  	<c:when test = "${categoryID == 2}">
                  		<img class="materialboxed" src="Photos/portfolio/2_p1.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/2_p2.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/2_p3.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/2_p4.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/2_p5.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/2_p6.jpg"/>
                  	</c:when>
                  	<c:when test = "${categoryID == 3}">
                  		<img class="materialboxed" src="Photos/portfolio/3_p1.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/3_p2.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/3_p3.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/3_p4.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/3_p5.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/3_p6.jpg"/>
                  	</c:when>
                  	<c:when test = "${categoryID == 4}">
                  		<img class="materialboxed" src="Photos/portfolio/4_p1.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/4_p2.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/4_p3.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/4_p4.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/4_p5.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/4_p6.jpg"/>
                  	</c:when>
                  	<c:when test = "${categoryID == 5}">
                  		<img class="materialboxed" src="Photos/portfolio/5_p1.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/5_p2.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/5_p3.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/5_p4.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/5_p5.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/5_p6.jpg"/>
                  	</c:when>
                  	<c:when test = "${categoryID == 6}">
                  		<img class="materialboxed" src="Photos/portfolio/6_p1.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/6_p2.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/6_p3.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/6_p4.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/6_p5.jpg"/>
                  		<img class="materialboxed" src="Photos/portfolio/6_p6.jpg"/>
                  	</c:when>
                  </c:choose>
                </div>
              </div>
            </div>
           <div class="container about">
              <h6>|| ABOUT ||</h6>
              <hr>
              <div class="row">
                <div class="col s12 m4 l5">
                  <h6>EVENT SERVICE INFORMATION</h6>
                  <table class = "bordered striped">
                    <tbody>
                      <tr>
                        <td> Category: </td>
                        <td> ${event.categoryID} </td>
                      </tr>

                      <tr>
                        <td> Owner: </td>
                        <td> <button id = "${event.userID}" class = "btnhreflike">${fullName}</button></td>
                      </tr>

                      <tr>
                        <td> Portfolios/Websites: </td>
                        <td> ${event.websites} </td>
                      </tr>

                      <tr>
                        <td>  Description: </td>
                        <td> ${event.description} </td>
                      </tr>

                    </tbody>

                  </table>
                  
                    <div class="card-panel left-align" style = "background-color:#f2e3c6;">
                        <span class="black-text">
                          <h6> PRICES AND PACKAGES </h6>
                           ${event.packages}
                        </span>
                     </div>
                  


                  <p>© 2016 Eventure. All Rights Reserved. </p>
                </div>

                <div class="col s12 m4 l7">
                  <h6>REVIEWS</h6>
				<c:choose>
	            	<c:when test = "${currUserID != eventOwner }">
		                  <form action = "AddReviewServlet" method = "post">
		                    <fieldset class = "z-depth-2 white">
		                    <legend> Rating & Review</legend>
		                        <div class="rating">
		                            <input type="radio" id="star5" name="rating" value="5" /><label for="star5" title="Rocks!"></label>
		                            <input type="radio" id="star4" name="rating" value="4" /><label for="star4" title="Pretty good"></label>
		                            <input type="radio" id="star3" name="rating" value="3" /><label for="star3" title="Meh"></label>
		                            <input type="radio" id="star2" name="rating" value="2" /><label for="star2" title="Kinda bad"></label>
		                            <input type="radio" id="star1" name="rating" value="1" /><label for="star1" title="Sucks big time"></label>
		                        </div>
		                      
		                      
		  
		                      <div class="row">
		                        <div class="input-field col s12">
		                          <i class="material-icons prefix">mode_edit</i>
		                          <textarea name = "message" id="textarea-review" class="materialize-textarea"></textarea>
		                          <label for="icon_prefix2">Type your review here</label>
		                        </div>
		                          <div class = "col s6 offset-s3">
		                            <button type='submit' name='btn_login' class='col s12 brown btn btn-large waves-effect indigo'>SUBMIT</button>
		                          </div>
		                      </div>
		                    </fieldset>
		                    
		                    <!-- additional things need to pass. -->
		                    <input name = "userID" type="hidden" value= "${currUserID}"/>
		                    <input name = "eventID" type="hidden" value = "${event.eventID}"/>
		              		
		                  </form>
		             </c:when>
		           </c:choose>

		       
		          <c:if test = "${empty(reviewList)}">
		          	<span class="black-text"> <i> NO REVIEWS. </i></span>
		          </c:if>
		          
		          
		          <c:forEach var="c" items="${reviewList}">
		                  <div class="card-panel grey lighten-5 z-depth-1" id = "review-container">
		                    <div class="row valign-wrapper">
		                      <div class="col s2">
		                        <img src="Photos/avatar-female.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
		                      </div>
		                      <div class="col s10">
		                        <span class="black-text">
		                           ${c.reviewedBy} - 
		                           <c:choose>
			                        	<c:when test = "${c.rating == 1}">
			                          		<img src="Photos/rating/1-star.png" id = "rating-pic"/> 
			                          	</c:when>
			                          	
			                          	<c:when test = "${c.rating == 2}">
			                          		<img src="Photos/rating/2-star.png" id = "rating-pic"/> 
			                          	</c:when>
			                          	
			                         	<c:when test = "${c.rating == 3}">
			                          		<img src="Photos/rating/3-star.png" id = "rating-pic"/> 
			                          	</c:when>
			                          	
			                       		<c:when test = "${c.rating == 4}">
			                          		<img src="Photos/rating/4-star.png" id = "rating-pic"/> 
			                          	</c:when>
			                          	
			                         	<c:when test = "${c.rating == 5}">
			                          		<img src="Photos/rating/5-star.png" id = "rating-pic"/> 
			                          	</c:when>		                           
		                           </c:choose>
		                           
		                          <br> ${c.message}
		                        </span>
		                        <br>
		                        <label style='float: right;' class = "grey-text">
		                          <b>Posted: ${c.reviewDate} </b>
		                        </label>
		                      </div>
		                    </div>
		                  </div>
		           </c:forEach>      

                </div>
              </div>
           </div>
        </div>
      </div>
    </div>

	     <!-- HIDDEN FORMS -->
     <form id = "view-profile-form" action = "ViewOthersProfileServlet" method = "POST">
		<input name = "userID" type="hidden" id="hiddeninput-profile">
	 </form>
	 <form id = "search-by-category" action = "SearchByCategServlet" method = "POST">
		<input name = "categoryID" type="hidden" id="hiddeninput-category">
	 </form>

	 <script type="text/javascript">
		var Msg ='<%=request.getAttribute("getAlert")%>';
		    if(Msg == "review"){
		    	function alertName(){
		 			swal({   title: "Thank you!",   
		 				text: "You successfully reviewed an event service.",   
		 				timer: 2000,   
		 				showConfirmButton: false 
		 				});
				} 
		    }if(Msg == "error"){
		    	function alertName(){
		 			swal({title: "Error!", 
		 				text: "Reviews can't be empty.", 
		 				type: "error",
		 				timer: 4000,
		 				showConfirmButton: false	
		 			});
				} 
		    }
	</script> 
	<script type="text/javascript"> window.onload = alertName; </script>
	 

	</body>

	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="js/materialize.js"></script>

</html>