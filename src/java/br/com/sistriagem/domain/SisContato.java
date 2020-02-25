package br.com.sistriagem.domain;

public class SisContato {
private int id;
private String tipoContato;
private int DDD;
private String numero;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTipoContato() {
	return tipoContato;
}
public void setTipoContato(String tipoContato) {
	this.tipoContato = tipoContato;
}
public int getDDD() {
	return DDD;
}
public void setDDD(int dDD) {
	DDD = dDD;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
}
