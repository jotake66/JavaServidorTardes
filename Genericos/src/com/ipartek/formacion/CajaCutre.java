package com.ipartek.formacion;

public class CajaCutre {

	private Object objeto;

	public void guardar(Object objeto){
		this.objeto = objeto; 
	}
	
	public Object obtener(){
		return objeto;
	}
}
