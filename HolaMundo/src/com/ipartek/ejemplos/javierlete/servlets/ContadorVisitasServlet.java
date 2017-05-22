package com.ipartek.ejemplos.javierlete.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date antes = new Date();

		ServletContext application = getServletContext();

		int visitas = 0;

		synchronized (application) {
			// for (int i = 0; i < 1000000; i++) {
			if (application.getAttribute("visitas") == null)
				visitas = 0;
			else
				visitas = (int) application.getAttribute("visitas");

			application.setAttribute("visitas", visitas + 1);
			// visitas = visitas + 1
			// }
		}

		Date despues = new Date();

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		out.println(visitas);
		out.println(antes.getTime());
		out.println(despues.getTime());
		out.println(despues.getTime() - antes.getTime());
	}

}
