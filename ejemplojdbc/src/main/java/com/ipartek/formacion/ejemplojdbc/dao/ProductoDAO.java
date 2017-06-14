package com.ipartek.formacion.ejemplojdbc.dao;

import com.ipartek.formacion.ejemplojdbc.tipos.Producto;

public interface ProductoDAO extends IpartekDAO {
	public Producto[] findAll();

	public Producto findById(int id);

	public int insert(Producto producto);

	public void update(Producto producto);

	public void delete(Producto producto);

	public void delete(int id);
}
