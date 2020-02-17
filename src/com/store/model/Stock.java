package com.store.model;

public class Stock {
	private int idProducto;
	private double stock;

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(int idProducto, double stock) {
		super();
		this.idProducto = idProducto;
		this.stock = stock;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Stock [idProducto=" + idProducto + ", stock=" + stock + "]";
	}

}
