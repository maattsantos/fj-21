package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/deletaContato")
public class DeletaContatoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		Contato contato = new Contato();
		contato.setId(Long.parseLong(id));
		
		ContatoDao dao = new ContatoDao();
		dao.exclui(contato);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() + " deletado com sucesso");
		out.println("</body>");
		out.println("</html>");
		
	}

}
