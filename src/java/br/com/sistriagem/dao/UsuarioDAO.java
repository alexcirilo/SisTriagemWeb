package br.com.sistriagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistriagem.domain.SisUsuario;
import br.com.sistriagem.factory.ConnectionFactory;

public class UsuarioDAO {
	PreparedStatement stmt;
	ResultSet rs;
	Connection con;

	public void logar(SisUsuario user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select login,senha ");
		sql.append("from Sis_Usuario ");
		sql.append("where login = ? ");
		sql.append("and senha = ? ");

		con = ConnectionFactory.connect();
		stmt = con.prepareStatement(sql.toString());

		stmt.setString(1, user.getLogin());
		stmt.setString(2, user.getSenha());

		rs = stmt.executeQuery();

		rs.first(); 
			user.setLogin(rs.getString("login"));
			user.setSenha(rs.getString("senha"));
		
	}

	public static void main(String[] args) {
		SisUsuario user = new SisUsuario();
		user.setLogin("admin");
		user.setSenha("admin");

		UsuarioDAO dao = new UsuarioDAO();
		try {
			dao.logar(user);
			System.out.println("Usuário: " + user.getLogin() + ", Logado com sucesso!!\n Bem Vindo!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Usuário e/ou senha incorreto!");
			e.printStackTrace();
		}
	}
}
