<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
 	<script>
 	$(document).ready(function() {
 		
		$('#id').focusout(function () {
	        var text_val = $(this).val();
	        if(text_val > 0){
	        	$('#exampleModal').modal('show');
	        }
	    }).focusout(); 
 		
 	});
		
	</script> 
    <title>Employee DB</title>
  </head>
  <body>
  <div class="col-md-12">
  <div class="row m-3">
  	<h3>Employee List</h3>
  	<sec:authorize access="hasRole('ROLE_ADMIN')">
  		<button type="button" id="popUpModal" class="ml-3 mr-3 btn btn-primary" data-toggle="modal" data-target="#exampleModal">
	  	Add Employee
		</button>
	</sec:authorize>
	
	<a href="<c:url value='/employee-list-db/j_spring_security_logout'/>">(logout)</a>
  </div>
    
    <c:if test="${!empty employeeList}">
	<table class="table" id="employeeList">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Address</th>
	      <th scope="col">Contact Info</th>
	      <th scope="col">Age</th>
	      <th scope="col">Rendered Years</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${employeeList}" var="e">
	    <tr>
	      <th scope="row">${e.firstName} ${e.lastName}</th>
	      <td>${e.addressInfo}</td>
	      <td>${e.contactInfo}</td>
	      <td>${e.age}</td>
	      <td>${e.renderedYears}</td>
	      <td>
  	<sec:authorize access="hasRole('ROLE_ADMIN')">

	      	<a class="btn btn-info popUpModalEdit" href="<c:url value='/employee/${e.id}' />" >Edit</a>
	      	<a class="btn btn-danger" href="<c:url value='/employee/delete/${e.id}' />" >Delete</a>
	</sec:authorize>
  	<sec:authorize access="hasRole('ROLE_USER')">
	      	<a class="btn btn-info popUpModalEdit" href="<c:url value='/employee/${e.id}' />" >View</a>
	</sec:authorize>
	      </td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</c:if>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Employee Info Page</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form:form action="/employee-list-db/employee/add" commandName="employee">
	    <div class="col-md-12">
	    	<c:if test="${!empty employee.id}">
			
				<div class="form-group row">
			    <label for="id" class="col-sm-3 col-form-label">ID</label>
			    <div class="col-sm-7">
			      <form:input path="id" readonly="true" type="text" class="form-control" id="id"/>
			    </div>
			</div>
				</c:if>
	  		<div class="form-group row">
			    <label for="firstName" class="col-sm-3 col-form-label">First Name</label>
			    <div class="col-sm-7">
			      <form:input path="firstName" type="text" class="form-control" id="firstName"/>
			    </div>
			</div>
			<div class="form-group row">
			    <label for="lastName" class="col-sm-3 col-form-label">Last Name</label>
			    <div class="col-sm-7">
			      <form:input path="lastName" type="text" class="form-control" id="lastName"/>
			    </div>
			</div>
			<div class="form-group row">
			    <form:label path="middleName" for="middleName" class="col-sm-3 col-form-label">Middle Name</form:label>
			    <div class="col-sm-7">
			      <form:input path="middleName" type="text" class="form-control" id="middleName"/>
			    </div>
			</div>
			<div class="form-group row">
			    <label for="birthDate" class="col-sm-3 col-form-label">Birth Date</label>
			    <div class="col-sm-7">
			      <form:input path="birthDate" type="date" class="computeDate form-control" id="birthDate"/>
			    </div> 
			</div>
			<div class="form-group row">
			    <label for="gender" class="col-sm-3 col-form-label">Gender</label>
			    <div class="col-sm-7">
				    <form:select path="gender" class="form-control" id="gender">
				      <option>MALE</option>
				      <option>FEMALE</option>
				    </form:select>
			    </div> 
			</div>
			<div class="form-group row">
			    <label for="maritalStatus" class="col-sm-3 col-form-label">Marital Status</label>
			    <div class="col-sm-7">
			      <form:select path="maritalStatus" class="form-control" id="maritalStatus">
				      <option>SINGLE</option>
				      <option>MARRIED</option>
				      <option>WIDOWED</option>
				      <option>SPACESHIP</option>
				    </form:select>
			    </div> 
			</div>
			<div class="form-group row">
			    <label for="position" class="col-sm-3 col-form-label">Position</label>
			    <div class="col-sm-7">
			      <form:select path="position" class="form-control" id="position">
				      <option>CEO</option>
				      <option>ENGINEER</option>
				      <option>KAINUMAN</option>
				    </form:select>
			    </div> 
			</div>
			<div class="form-group row">
			    <label for="dateHired" class="col-sm-3 col-form-label">Date Hired</label>
			    <div class="col-sm-7">
			      <form:input path="dateHired" type="date" class="form-control" id="dateHired"/>
			    </div> 
			</div>
	      <div class="form-group row">
			    <label for="contactInfo" class="col-sm-3 col-form-label">Contact Info</label>
			    <div class="col-sm-7">
			      <form:input path="contactInfo" type="text" class="form-control" id="contactInfo"/>
			    </div> 
			</div>
			<div class="form-group row">
			    <label for="addressInfo" class="col-sm-3 col-form-label">Address Info</label>
			    <div class="col-sm-7">
			      <form:input path="addressInfo" type="text" class="form-control" id="addressInfo"/>
			    </div> 
			</div>
	    </div>
	          <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
	      	<button type="submit" class="btn btn-primary">Save changes</button>
	    </sec:authorize>
        
      </div>
	    </form:form>
      </div>

    </div>
  </div>
</div>
</div>
</body>
</html>