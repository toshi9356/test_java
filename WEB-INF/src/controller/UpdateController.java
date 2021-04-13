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
import service.UpdateService;

@WebServlet("/update")
public class UpdateController extends HttpServlet  {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String memo = request.getParameter("memo");
		int id = Integer.parseInt(request.getParameter("id"));
		UpdateService updateService = new UpdateService();
		List<Customer> customerList = updateService.updateCustomer(email, password, name, gender, blood, memo, id);
		request.setAttribute("customerList", customerList);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "update.jsp").forward(request, response);
	}

}
