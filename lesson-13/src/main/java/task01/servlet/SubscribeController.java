package task01.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import task01.domain.Magazine;
import task01.domain.Subscribe;
import task01.domain.User;
import task01.service.MagazineService;
import task01.service.SubscribeService;
import task01.service.UserService;
import task01.service.impl.MagazineServiceImpl;
import task01.service.impl.SubscribeServiceImpl;
import task01.service.impl.UserServiceImpl;

public class SubscribeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private	SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeService();
	private	MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	private	UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magazineId = request.getParameter("magazineId");
		
		Magazine magazine = magazineService.read(Integer.parseInt(magazineId));
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		User user = userService.read(userId);
		
		Subscribe subscribe = new Subscribe();
		subscribe.setId(subscribe.getId());
		subscribe.setMagazine(magazine);
		subscribe.setUser(user);
		subscribe.setSubscribeStatus(true);
		subscribe.setSubscribeDate(new Date());
		subscribe.setSubscribePeriod(1);
		
		subscribeService.create(subscribe);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subscribeId = request.getParameter("subscribeId");
		subscribeService.delete(Integer.parseInt(subscribeId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
		
	}

}