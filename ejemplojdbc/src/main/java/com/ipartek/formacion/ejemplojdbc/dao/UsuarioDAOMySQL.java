package com.ipartek.formacion.ejemplojdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplojdbc.tipos.Usuario;

public class UsuarioDAOMySQL implements UsuarioDAO {

	private Connection con;
	private String url = "jdbc:mysql://localhost/ipartek";
	private String mysqlUser = "root";
	private String mysqlPass = "";

	private final static String FIND_ALL = "SELECT * FROM usuarios";
	private final static String FIND_BY_ID = "SELECT * FROM usuarios WHERE id = ?";
	private final static String INSERT = 
		"INSERT INTO usuarios (username, password, nombre_completo, id_roles)" + 
		" VALUES (?, ?, ?, ?)";
	private final static String UPDATE = "UPDATE usuarios " + 
		"SET username = ?, password = ?, nombre_completo = ?, id_roles = ? " + 
		"WHERE id = ?";
	private final static String DELETE = "DELETE FROM usuarios WHERE id = ?";

	private PreparedStatement psFindAll, psFindById, psInsert, psUpdate, psDelete;
	
	public UsuarioDAOMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, mysqlUser, mysqlPass);
			
			psFindAll = con.prepareStatement(FIND_ALL);
			psFindById = con.prepareStatement(FIND_BY_ID);
			psInsert = con.prepareStatement(INSERT);
			psUpdate = con.prepareStatement(UPDATE);
			psDelete = con.prepareStatement(DELETE);
			
		} catch (InstantiationException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("No se ha encontrado el driver de MySQL", e);
		} catch (SQLException e) {
			throw new DAOException("Error de conexión a la base de datos", e);
		} catch (Exception e) {
			throw new DAOException("ERROR NO ESPERADO", e);
		} finally {
//			if(con != null)
//				try {
//					con.close();
//				} catch (SQLException e) {
//					throw new DAOException("Error al cerrar", e);
//				}
		}
	}

	public Usuario[] findAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			ResultSet rs = psFindAll.executeQuery(); 
			
			Usuario usuario;
			
			while(rs.next()){
				//System.out.println(rs.getString("username"));
				usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setId_roles(rs.getInt("id_roles"));
				usuario.setNombre_completo(rs.getString("nombre_completo"));
				usuario.setPassword(rs.getString("password"));
				usuario.setUsername(rs.getString("username"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			throw new DAOException("Error en findAll", e);
		} finally {
//			if(con != null)
//				try {
//					con.close();
//				} catch (SQLException e) {
//					throw new DAOException("Error al cerrar en findAll", e);
//				}
		}
		return usuarios.toArray(new Usuario[usuarios.size()]);
	}

	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	public void update(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
