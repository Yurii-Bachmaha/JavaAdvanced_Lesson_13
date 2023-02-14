package task01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import task01.domain.User;
import task01.dto.UserLogin;
import task01.service.UserService;
import task01.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userService.getUserByEmail(email);
		
		if(user == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		if(user.getPassword().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.getId());
			session.setAttribute("accessLevel", user.getAccessLevel().toString());
			UserLogin userLogin = new UserLogin(user.getEmail(), "cabinet.jsp");
			
			String json = new Gson().toJson(userLogin);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		}
		
	}
}