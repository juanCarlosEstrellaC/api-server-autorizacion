package com.example.demo.service.to;

import java.io.Serializable;


public class UsuarioTo implements Serializable{
	
	// No implemento RepresentationModel<> porque no tendrá linsk
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String password;
	
	// ToString:
	@Override
	public String toString() {
		return "UsuarioTo [nombre=" + nombre + ", password=" + password + "]";
	}
	
	// GET Y SET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
