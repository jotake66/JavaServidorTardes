package com.ipartek.ejemplos.javierlete.dal;

public class DALFactory {
	public static UsuariosDAL getUsuariosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new UsuariosDALColeccion();
	}
}
