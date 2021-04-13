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
import service.ConfirmService;

@WebServlet("/entry")
public class ConfirmController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		int old = Integer.parseInt(request.getParameter("old"));
		String memo = request.getParameter("memo");
		ConfirmService confirmService = new ConfirmService();
		List<Customer> customerList = confirmService.confirmCustomer(email, password, name, gender, blood, old, memo);
		request.setAttribute("customerList", customerList);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "complete.jsp").forward(request, response);
	}

}