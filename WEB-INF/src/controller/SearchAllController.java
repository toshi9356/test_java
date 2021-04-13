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
import service.SearchAllService;


@WebServlet("/searchAll")
public class SearchAllController extends HttpServlet {

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			LoginService loginService = new LoginService();
			String name = loginService.login(email, password);
			LoginUser loginUser = new LoginUser();
			loginUser.setEmail(email);
			loginUser.setPassword(password);
			loginUser.setName(name);
			request.setAttribute("loginUser", loginUser);
			SearchAllService searchAllService = new SearchAllService();
			List<Customer> customerAllList = searchAllService.searchAllCustomer(gender);
			request.setAttribute("customerList", customerAllList);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/" + "mypage.jsp").forward(request, response);
		}
}
