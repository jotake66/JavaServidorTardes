package com.ipartek.formacion.ejemplojdbc.dao;

public interface IpartekDAO {
	public void abrir();
	public void cerrar();
	public void reutilizarConexion(IpartekDAO dao);
	
	public void iniciarTransaccion();
	public void confirmarTransaccion();
	public void deshacerTransaccion();
}
