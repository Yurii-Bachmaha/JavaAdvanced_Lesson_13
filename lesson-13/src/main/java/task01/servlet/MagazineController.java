package task01.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task01.domain.Magazine;
import task01.service.MagazineService;
import task01.service.impl.MagazineServiceImpl;

public class MagazineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String magazineDescription = request.getParameter("description");
		String subscribePrice = request.getParameter("subscribePrice");
		
		Magazine magazine = new Magazine(name, magazineDescription, new Date(), Double.parseDouble(subscribePrice));
		magazineService.create(magazine);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magazineID = request.getParameter("id");
		Magazine magazine = null;
		magazine = magazineService.read(Integer.parseInt(magazineID));
		request.setAttribute("magazine", magazine);
		request.getRequestDispatcher("singleMagazine.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}