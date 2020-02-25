package br.com.sistriagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistriagem.domain.SisUsuario;
import br.com.sistriagem.factory.ConnectionFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        
        public void salvar(SisUsuario user){
            StringBuilder sql = new StringBuilder();
            sql.append("insert into sis_usuario ");
            sql.append("(nomeusuario,login,senha) ");
            sql.append("values (?,?,?) ");
            
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte messageDigest[] = md.digest(user.getSenha().getBytes());
                StringBuilder sb = new StringBuilder();
                
                for(byte b : messageDigest){
                 sb.append(String.format("%02X",0xFF &b));
                }
                String senhaHex = sb.toString();
                
                con = ConnectionFactory.connect();
                stmt = con.prepareStatement(sql.toString());
                stmt.setString(1, user.getNomeUsuario());
                stmt.setString(2, user.getLogin());
                stmt.setString(3, senhaHex);
                stmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

	public static void main(String[] args) {
		SisUsuario user = new SisUsuario();
                user.setNomeUsuario("Administrador");
		user.setLogin("admin");
		user.setSenha("adminadmin");

		UsuarioDAO dao = new UsuarioDAO();
		/*try {
			dao.logar(user);
			System.out.println("Usuário: " + user.getLogin() + ", Logado com sucesso!!\n Bem Vindo!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Usuário e/ou senha incorreto!");
			e.printStackTrace();
		}*/
                dao.salvar(user);
                System.out.println("Usuario: "+user.getNomeUsuario() + ", salvo com sucesso!");
	}
}
