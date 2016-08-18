package br.com.imov.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

import br.com.imov.interfac.InterfaceConexaoBd;

public class ConexaoBd implements InterfaceConexaoBd{
	
	private static Connection conexao = null;
	
	public ConexaoBd() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConexao() {
		try {
			if (conexao == null || conexao.isClosed()){
				String url = "jdbc:mysql://localhost:3306/Imov?useSSL=false";
				String usuario = "imov";
				String senha = "imov";
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conexao = DriverManager.getConnection(url,usuario, senha);
				conexao.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;
	}
	
	public static void desconectar(){
		try {
			if (conexao != null){
				conexao.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int inserir(PreparedStatement stmt){
		int retorno = 0;
		try {
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			retorno = rs.getInt(1);
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}            
		return retorno;	
	}
	
	public boolean atualizar(PreparedStatement stmt){
		boolean retorno = false;
		try {
			int retornoExecute = stmt.executeUpdate();
			if (retornoExecute == 1){
				retorno = true;
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}            
		return retorno;	
	}
	
	public boolean excluir(PreparedStatement stmt){
		boolean retorno = false;
		try {
			int retornoExecute = stmt.executeUpdate();
			if (retornoExecute == 1){
				retorno = true;
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}            
		return retorno;	
	}
	
	public List<Map<String, Object>> localizar(PreparedStatement stmt){
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
	    Map<String, Object> row = null;
	    try {
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			ResultSetMetaData metaData = rs.getMetaData();
			Integer columnCount = metaData.getColumnCount();
			while (rs.next()) {
				row = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					row.put(metaData.getColumnName(i), rs.getObject(i));
				}
				resultList.add(row);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}            
		return resultList;	
	}
	
	public Map<String, Object> localizarById(PreparedStatement stmt){
		List<Map<String, Object>> resultList  = localizar(stmt);
		return resultList.get(0);
	}
}
