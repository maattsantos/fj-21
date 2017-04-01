package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/buscarContato")
public class BuscarContatoServlet {

	public class AlteraContatoServlet extends HttpServlet {

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			PrintWriter out = response.getWriter();

			ContatoDao dao = new ContatoDao((Connection) request.getAttribute("conexao"));
			List<Contato> contatos = dao.getLista();

			for (Contato contato : contatos) {
				System.out.println(contato.getId());
				System.out.println(contato.getNome());
				System.out.println(contato.getEndereco());
				System.out.println(contato.getEmail());
				System.out.println(contato.getDataNascimento());
			}

			out.println("<html>");
			out.println("<body>");
			out.println("<p></p>");
			out.println("</body>");
			out.println("</html>");

		}

	}

}
