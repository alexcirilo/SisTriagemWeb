package br.com.sistriagem.domain;

public class SisMedico {
private int id;
private String nomeMedico;
private String especialidade;
private int CRM;
private String ufCRM;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomeMedico() {
	return nomeMedico;
}
public void setNomeMedico(String nomeMedico) {
	this.nomeMedico = nomeMedico;
}
public String getEspecialidade() {
	return especialidade;
}
public void setEspecialidade(String especialidade) {
	this.especialidade = especialidade;
}
public int getCRM() {
	return CRM;
}
public void setCRM(int cRM) {
	CRM = cRM;
}
public String getUfCRM() {
	return ufCRM;
}
public void setUfCRM(String ufCRM) {
	this.ufCRM = ufCRM;
}

}
