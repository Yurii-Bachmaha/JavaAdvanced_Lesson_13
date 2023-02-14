package task01.filters;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import task01.domain.AccessLevel;
import task01.shared.FilterService;

@WebFilter("/product")
public class ProductFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	private FilterService filterService = FilterService.getFilterService();

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		filterService.doFilterValidation(request, response, chain, Arrays.asList(AccessLevel.USER));
	}
}