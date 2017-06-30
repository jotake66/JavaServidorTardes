package com.ipartek.formacion;

import java.util.Date;

public class Prueba {

	public static void main(String[] args) {
		CajaCutre cc = new CajaCutre();
		
		cc.guardar(new Date());
		
		Date d = (Date)cc.obtener();
		
		Caja<Date> c = new Caja<Date>();
		
		c.guardar(new Date());
		
		Date d2 = c.obtener();
		
	}

}
