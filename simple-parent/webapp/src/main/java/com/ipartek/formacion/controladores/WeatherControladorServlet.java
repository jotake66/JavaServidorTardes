package com.ipartek.formacion.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.WeatherService;

public class WeatherControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WeatherService ws = new WeatherService();
		Weather weather = null;
		try {
			weather = ws.retrieveWeather(request.getParameter("zip"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("weather", weather);
		request.getRequestDispatcher("/WEB-INF/weather.jsp").forward(request, response);
	}

}
