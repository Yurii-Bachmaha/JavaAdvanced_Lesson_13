package task01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task01.domain.AccessLevel;
import task01.domain.User;
import task01.service.UserService;
import task01.service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String accessLevel = null;
		
		if("user".equals(request.getParameter("accessLevel"))) {
			accessLevel = AccessLevel.USER.toString();
		}else if("admin".equals(request.getParameter("accessLevel"))){
			accessLevel = AccessLevel.ADMIN.toString();
		}
		
		if(!firstName.isEmpty()&&!lastName.isEmpty()&&!email.isEmpty()&&!password.isEmpty()) {
			userService.create(new User(firstName, lastName, email, password, accessLevel));
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");	
	}

}