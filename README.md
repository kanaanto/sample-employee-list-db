# employee-list-db
a sample spring/hibernate/mysql impl of an employee list for reference

notes (1/2):
1. had issues in setting up local machine
2. first commit was done in ~4 hours, including the setup. still need a few more features to implement

(2/2):
1. wasn't able to complete the requirements due to lack of time (and frustration lol)
2. overall time: ~7 hours
3. features not implemented:
	- session handling: no backend login/logout
		- no user type handling
	- no editing of employee info
	- no computation of age and years rendered
	- no multiple adding of contact and address info
		- no choosing of primary info
		
sql instructions:
1. employeedb.sql under src/main/resources (not integrated in deployment process)
	- db config to edit: webapp/WEB-INF/spring/appServlet/servlet-context.xml
2. server used: tomcat 7
3. default url: http://localhost:8080/employee-list-db/

