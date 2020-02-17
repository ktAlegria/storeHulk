package com.store.model;

public class Producto {

	private int id;
	private String nombre;
	private String descripcion;
	private double precioVenta;
	private double stock;
	private double vende;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String descripcion, double precioVenta) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioVenta = precioVenta;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public double getVende() {
		return vende;
	}

	public void setVende(double vende) {
		this.vende = vende;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioVenta="
				+ precioVenta + "]";
	}

}
