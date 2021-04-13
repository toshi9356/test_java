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
import data.LoginUser;
import service.LoginService;
import service.SearchService;

@WebServlet("/search")
public class SearchController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		LoginService loginService = new LoginService();
		String name = loginService.login(email, password);
		LoginUser loginUser = new LoginUser();
		loginUser.setEmail(email);
		loginUser.setPassword(password);
		loginUser.setName(name);
		request.setAttribute("loginUser", loginUser);
		SearchService searchService = new SearchService();
		List<Customer> customerList = searchService.searchCustomer(gender, blood);
		request.setAttribute("customerList", customerList);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "mypage.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		SearchService searchService2 = new SearchService();
		List<Customer> customerList2 = searchService2.searchId(id);
		request.setAttribute("customerList", customerList2);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + "detail.jsp").forward(request, response);
	}
}
