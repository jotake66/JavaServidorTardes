package com.ipartek.ejemplos.javierlete.dal;

import com.ipartek.ejemplos.javierlete.tipos.Usuario;

public class UsuariosDALUsuarioUnico implements UsuariosDAL {

	private Usuario usuario;

	@Override
	public void alta(Usuario usuario) {
		if (this.usuario.getNombre().equals(usuario.getNombre()))
			throw new DALException("Ya existe un usuario con ese nombre: " + usuario);

		this.usuario = usuario;
	}

	@Override
	public boolean validar(Usuario usuario) {
		return this.usuario != null && this.usuario.equals(usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		if (!this.usuario.getNombre().equals(usuario.getNombre()))
			throw new DALException("No se ha encontrado el usuario a modificar " + usuario);
		this.usuario = usuario;

	}

	@Override
	public void borrar(Usuario usuario) {
		if (this.usuario.equals(usuario))
			this.usuario = null;
	}

	@Override
	public Usuario buscarPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario[] buscarTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
