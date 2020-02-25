package br.com.sistriagem.dao;

import br.com.sistriagem.domain.SisPaciente;
import br.com.sistriagem.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

@ManagedBean(name = "paciente")
@ViewScoped
public class PacienteDAO {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public void salvar(SisPaciente pac) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into sis_paciente ");
        sql.append("(nomepaciente,cpf,sexo,datanascimento,curso) ");
        sql.append("values (?,?,?,?,?)");

        try {
            con = ConnectionFactory.connect();
            stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, pac.getNomePessoa());
            stmt.setString(2, pac.getCPF());
            stmt.setString(3, pac.getSexo());
            //10/07/1993
            String dia = pac.getDataNascimento().substring(0, 2);
            String mes = pac.getDataNascimento().substring(3, 5);
            String ano = pac.getDataNascimento().substring(6);
            String data = ano + "-" + mes + "-" + dia;
            stmt.setString(4, data);
            stmt.setString(5, pac.getCurso());

            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Paciente salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getErrorCode());
        }

    }
}
