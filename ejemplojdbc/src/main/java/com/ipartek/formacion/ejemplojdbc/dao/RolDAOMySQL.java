package com.ipartek.formacion.ejemplojdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplojdbc.tipos.Rol;

public class RolDAOMySQL extends IpartekDAOMySQL implements RolDAO {

	private final static String FIND_ALL = "SELECT * FROM roles";
	private final static String FIND_BY_ID = "SELECT * FROM roles WHERE id = ?";
	private final static String INSERT = "INSERT INTO roles (rol, descripcion)" + " VALUES (?, ?)";
	private final static String UPDATE = "UPDATE roles " + "SET rol = ?, descripcion = ?" + "WHERE id = ?";
	private final static String DELETE = "DELETE FROM roles WHERE id = ?";

	private PreparedStatement psFindAll, psFindById, psInsert, psUpdate, psDelete;

	public Rol[] findAll() {
		ArrayList<Rol> roles = new ArrayList<Rol>();
		ResultSet rs = null;

		try {
			psFindAll = con.prepareStatement(FIND_ALL);

			rs = psFindAll.executeQuery();

			Rol rol;

			while (rs.next()) {
				rol = new Rol();

				rol.setId(rs.getInt("id"));
				rol.setRol(rs.getString("rol"));
				rol.setDescripcion(rs.getString("descripcion"));

				roles.add(rol);
			}

		} catch (SQLException e) {
			throw new DAOException("Error en findAll", e);
		} finally {
			cerrar(psFindAll, rs);
		}
		return roles.toArray(new Rol[roles.size()]);
	}

	public Rol findById(int id) {
		Rol rol = null;
		ResultSet rs = null;

		try {
			psFindById = con.prepareStatement(FIND_BY_ID);

			psFindById.setInt(1, id);
			rs = psFindById.executeQuery();

			if (rs.next()) {
				rol = new Rol();

				rol.setId(rs.getInt("id"));
				rol.setRol(rs.getString("rol"));
				rol.setDescripcion(rs.getString("descripcion"));
			}

		} catch (SQLException e) {
			throw new DAOException("Error en FindById", e);
		} finally {
			cerrar(psFindById, rs);
		}
		return rol;
	}

	public int insert(Rol rol) {
		ResultSet generatedKeys = null;

		try {
			psInsert = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			psInsert.setString(1, rol.getRol());
			psInsert.setString(2, rol.getDescripcion());

			int res = psInsert.executeUpdate();

			if (res != 1) {
				throw new DAOException("La inserción ha devuelto un valor " + res);
			}
			generatedKeys = psInsert.getGeneratedKeys();

			if (generatedKeys.next()) {
				return generatedKeys.getInt(1);
			} else {
				throw new DAOException("No se ha recibido la clave generada");
			}

		} catch (SQLException e) {
			throw new DAOException("Error en el insert", e);
		} finally {
			cerrar(psInsert, generatedKeys);
		}

	}

	public void update(Rol rol) {

		try {
			psUpdate = con.prepareStatement(UPDATE);

			psUpdate.setString(1, rol.getRol());
			psUpdate.setString(2, rol.getDescripcion());
			psUpdate.setInt(3, rol.getId());

			int res = psUpdate.executeUpdate();

			if (res != 1) {
				throw new DAOException("La actualización ha devuelto un valor " + res);
			}
		} catch (Exception e) {
			throw new DAOException("Error en el update", e);
		} finally {
			cerrar(psUpdate);
		}

	}

	public void delete(Rol rol) {
		delete(rol.getId());
	}

	public void delete(int id) {
		try {
			psDelete = con.prepareStatement(DELETE);

			psDelete.setInt(1, id);

			int res = psDelete.executeUpdate();

			if (res != 1) {
				throw new DAOException("La eliminación por ID ha devuelto un valor " + res);
			}
		} catch (Exception e) {
			throw new DAOException("Error en el deleteID", e);
		} finally {
			cerrar(psDelete);
		}

	}

	private void cerrar(PreparedStatement ps) {
		cerrar(ps, null);
	}

	private void cerrar(PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			throw new DAOException("Error en el cierre de ps o rs", e);
		}
	}
}
