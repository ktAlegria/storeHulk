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
 * Servlet implementation class ProductoController
 */
@WebServlet("/Producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoController() {
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
		// .getWriter().append("Served at: ").append(request.getContextPath());
		String op = request.getParameter("opcion");

		if (op.equalsIgnoreCase("crear")) {
			RequestDispatcher rD = request.getRequestDispatcher("View/CrearProducto.jsp");
			rD.forward(request, response);
		}
		if (op.equalsIgnoreCase("listar")) {
			ProductoDao pDAO = new ProductoDao();
			List<Producto> listProd = new ArrayList<>();
			listProd = pDAO.listar();
			request.setAttribute("listProductos", listProd);
			RequestDispatcher rD = request.getRequestDispatcher("View/ListarProductos.jsp");
			rD.forward(request, response);
		}
		if (op.equalsIgnoreCase("vender")) {
			Producto p = new Producto();
			p.setId(Integer.parseInt(request.getParameter("id")));
			p.setNombre(request.getParameter("nom"));
			p.setPrecioVenta(Double.parseDouble(request.getParameter("precio")));
			p.setStock(Double.parseDouble(request.getParameter("stock")));
			request.setAttribute("productoV", p);
			RequestDispatcher rD = request.getRequestDispatcher("View/VenderProductos.jsp");
			rD.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("proceso");
		if (op.equalsIgnoreCase("insertar")) {
			ProductoDao productoDAO = new ProductoDao();
			StockDao sDAO = new StockDao();
			Producto p = new Producto(request.getParameter("nomProd"), request.getParameter("desProd"),
					Double.parseDouble(request.getParameter("valProd")));
			try {
				int idP = productoDAO.crear(p);
				Stock s = new Stock(idP, Double.parseDouble(request.getParameter("Stock")));
				sDAO.crear(s);
				RequestDispatcher rD = request.getRequestDispatcher("/index.jsp");
				rD.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
