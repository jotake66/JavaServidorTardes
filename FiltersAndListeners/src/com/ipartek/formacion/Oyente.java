package com.ipartek.formacion;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Oyente
 *
 */
@WebListener
public class Oyente implements ServletContextListener, HttpSessionListener, ServletRequestListener, HttpSessionActivationListener, HttpSessionIdListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("NUEVO USUARIO");
		se.getSession().setAttribute("carrito", new ArrayList<String>());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ARRANQUE DE APLICACION");
		sce.getServletContext().setAttribute("productos", new ArrayList<String>());
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub

	}

}
