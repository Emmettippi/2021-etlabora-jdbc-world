package it.etlabora.world.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.etlabora.world.dao.CountryDao;
import it.etlabora.world.dao.impl.CountryDaoImpl;
import it.etlabora.world.model.Country;

public class CountryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CountryDao countryDao = new CountryDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Country> countries = countryDao.getCountryList();
		// Questa è la variabile "countries" nella jsp
		req.setAttribute("countries", countries);
		req.getRequestDispatcher("pages/country-list.jsp").forward(req, resp);
	}
}
