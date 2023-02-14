package task01.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import task01.domain.Magazine;
import task01.service.MagazineService;
import task01.service.impl.MagazineServiceImpl;

public class MagazineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<Magazine> magazines = null; 
		 magazines = magazineService.readAll();
		 String json = new Gson().toJson(magazines);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8"); 
		 response.getWriter().write(json);	
		 
	}
	
}