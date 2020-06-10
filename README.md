# employee-list-db
a sample spring/hibernate/mysql impl of an employee list for reference

notes (1/4):
1. had issues in setting up local machine
2. first commit was done in ~4 hours, including the setup. still need a few more features to implement

(2/4):
1. wasn't able to complete the requirements due to lack of time (and frustration lol)
2. dev time: ~3 hours
3. features not implemented:
	- session handling: no backend login/logout
		- no user type handling
	- no editing of employee info
	- no computation of age and years rendered
	- no multiple adding of contact and address info
		- no choosing of primary info
		
(3/4):
1. dev time: ~2 hours
2. added a login security checker via xml
3. added user role handling
	- admin can add, edit, delete and view employee list
	- user can view employee list
	
(4/4): 
1. dev time: ~1 hour
2. added edit feature for admins
3. added computation for age and years rendered

total setup and dev time: ~10 hours
-----------------------------------------------------------
sql instructions:
1. employeedb.sql under src/main/resources (not integrated in deployment process)
	- db config to edit: webapp/WEB-INF/spring/appServlet/servlet-context.xml
2. server used: tomcat 7
3. default url: http://localhost:8080/employee-list-db/

