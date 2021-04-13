package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Customer;
import service.DeleteService;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	int id = Integer.parseInt(request.getParameter("id"));
	DeleteService deleteService = new DeleteService();
	List<Customer> customerList = deleteService.deleteCustomer(id);
	request.setAttribute("customerList", customerList);
	ServletContext sc = getServletContext();
	sc.getRequestDispatcher("/" + "delete.jsp").forward(request, response);
	}

}
