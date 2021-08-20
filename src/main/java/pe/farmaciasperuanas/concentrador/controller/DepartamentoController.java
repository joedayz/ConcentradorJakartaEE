package pe.farmaciasperuanas.concentrador.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import pe.farmaciasperuanas.concentrador.model.Departamento;
import pe.farmaciasperuanas.concentrador.repository.DepartamentoRepository;

@RequestScoped
@Path("/departamento")
@Produces("application/json")
@Consumes("application/json")
public class DepartamentoController {

	@Inject
	DepartamentoRepository departamentoRepository;
	
	@GET
	public List<Departamento> listar(){
		return departamentoRepository.findAll();
	}
}
