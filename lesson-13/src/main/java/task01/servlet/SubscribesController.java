package task01.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import task01.domain.Magazine;
import task01.domain.Subscribe;
import task01.dto.SubscribeDto;
import task01.service.MagazineService;
import task01.service.SubscribeService;
import task01.service.impl.MagazineServiceImpl;
import task01.service.impl.SubscribeServiceImpl;

public class SubscribesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeService();
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subscribe> subscribes = subscribeService.readAll();
		Map<Integer, Magazine> idToProduct = magazineService.readAllMap();
		List<SubscribeDto> listOfSubscribeDtos = map(subscribes, idToProduct);

		String json = new Gson().toJson(listOfSubscribeDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	public List<SubscribeDto> map(List<Subscribe> subscribes, Map<Integer, Magazine> idToProduct) {

		return subscribes.stream().map(subscribe -> {
			SubscribeDto subscribeDto = new SubscribeDto();
			subscribeDto.subscribeId = subscribe.getId();
			subscribeDto.subscribePeriod = subscribe.getSubscribePeriod();
			subscribeDto.subscribeDate = subscribe.getSubscribeDate();

			Magazine magazine = idToProduct.get(subscribe.getMagazine().getId());
			subscribeDto.name = magazine.getName();
			subscribeDto.description = magazine.getDescription();
			subscribeDto.subscribePrice = magazine.getSubscribePrice();

			return subscribeDto;
		}).collect(Collectors.toList());

	}
}