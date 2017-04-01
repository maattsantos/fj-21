package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Connection conn = (Connection) req.getAttribute("conexao");
		List<Contato> contatos = new ContatoDao(conn).getLista();

		req.setAttribute("contatos", contatos);

		System.out.println("Entrei na lista");

		return "/WEB-INF/lista-contatos.jsp";

	}

}
