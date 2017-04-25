package com.ipartek.ejemplos.javierlete.dal;

import com.ipartek.ejemplos.javierlete.tipos.Usuario;

public interface UsuariosDAL {
	public void alta(Usuario usuario);

	public boolean validar(Usuario usuario);
}
