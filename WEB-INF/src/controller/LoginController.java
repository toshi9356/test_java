package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.LoginUser;
import service.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nextPage = "";
		LoginService loginService = new LoginService();
		String name = loginService.login(email, password);
		LoginUser loginUser = new LoginUser();
		if ("".equals(name)) {
			// 名前が取得できなかった＝ログインできなかったときの処理
			nextPage = "error.jsp";
		} else {
			// ログインしたときの処理
			loginUser.setEmail(email);
			loginUser.setPassword(password);
			loginUser.setName(name);
			nextPage = "mypage.jsp";
		}
		request.setAttribute("loginUser", loginUser);
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/" + nextPage).forward(request, response);
	}

}
