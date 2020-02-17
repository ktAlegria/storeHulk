package com.store.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.dao.ProductoDao;
import com.store.dao.StockDao;
import com.store.model.Producto;
import com.store.model.Stock;

/**
 * Servlet implementation class StockController
 */
@WebServlet(name = "Stock", urlPatterns = { "/Stock" })
public class StockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StockController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		StockDao sDao = new StockDao();
		Stock s = new Stock();
		s.setIdProducto(Integer.parseInt(request.getParameter("id")));
		double stock = Double.parseDouble(request.getParameter("stock"));
		double vende = Double.parseDouble(request.getParameter("vende"));
		if (vende <= stock) {
			Double newStock = Double.parseDouble(request.getParameter("stock"))
					- Double.parseDouble(request.getParameter("vende"));
			s.setStock(newStock);
			try {
				sDao.editar(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ProductoDao pDAO = new ProductoDao();
			List<Producto> listProd = new ArrayList<>();
			listProd = pDAO.listar();
			request.setAttribute("listProductos", listProd);
			RequestDispatcher rD = request.getRequestDispatcher("View/ListarProductos.jsp");
			rD.forward(request, response);
		}

	}

}
