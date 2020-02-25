package br.com.sistriagem.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "user")
@ViewScoped
public class SisUsuario {
private int id;
private String nomeUsuario;
private String login;
private String senha;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomeUsuario() {
	return nomeUsuario;
}
public void setNomeUsuario(String nomeUsuario) {
	this.nomeUsuario = nomeUsuario;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}

}
