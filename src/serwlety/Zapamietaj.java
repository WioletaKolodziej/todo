package serwlety;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Zapamietaj")
public class Zapamietaj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todoItem = request.getParameter("todo-item");
		
		if (todoItem != null && !todoItem.isEmpty()) {
			
			/**
			 * Sesja działa trochę jak kolekcja (hashmapa)
			 */
			HttpSession sesja = request.getSession();
			
			ArrayList<String> todoLista = (ArrayList) sesja.getAttribute("todoLista");
			
			if (todoLista == null) {
				todoLista = new ArrayList<>();
				sesja.setAttribute("todoLista", todoLista);
			}
			
			todoLista.add(todoItem);
			System.out.println(todoLista);
		}
		
		System.out.println(todoItem);
		
		// PRG - Post-Redirect-Get
		response.sendRedirect("todo.jsp");
	}

}
