package com.store.model;

public class Usuario {
	private int id;
	private String nombre;
	private String perfil;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String nombre, String perfil) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", perfil=" + perfil + "]";
	}

}
