package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IProgramacionAnualRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioProgramacionAnual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioProgramacionAnual")
public class ServicioProgramacionAnual implements IServicioProgramacionAnual{

	@Autowired
	IProgramacionAnualRepository programacionAnualRepository;
	
	@Override
	public List<ProgramacionAnual> buscarTodos() {
		// TODO Auto-generated method stub
		return programacionAnualRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return programacionAnualRepository.findAll().size();
	}

	@Override
	public ProgramacionAnual guardar(ProgramacionAnual entidad) {
		// TODO Auto-generated method stub
		return programacionAnualRepository.save(entidad);
	}

	@Override
	public ProgramacionAnual crear() {
		// TODO Auto-generated method stub
		return new ProgramacionAnual();
	}

	@Override
	public void eliminar(ProgramacionAnual entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Collection<ProgramacionAnual> entidades) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public ProgramacionAnual buscarPorIdProgramacion(int id) {
		// TODO Auto-generated method stub
		return programacionAnualRepository.findById(id);
	}



	@Override
	public List<ProgramacionAnual> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return programacionAnualRepository.buscarPorX(parametro);
	}

	@Override
	public List<ProgramacionAnual> buscarProgramacionPorEstado(
			EstadoProgramacionAnual estadoprogramacionanual) {
		// TODO Auto-generated method stub
		return programacionAnualRepository.findByEstadoprogramacionanual(estadoprogramacionanual);
	}

	@Override
	public ProgramacionAnual buscarProgramacionStatus(String status) {
		// TODO Auto-generated method stub
		return programacionAnualRepository.findByStatus(null);
	}

	@Override
	public ProgramacionAnual buscarPorAno(String ano) {
		// TODO Auto-generated method stub
		return programacionAnualRepository.findByAno(ano);
	}

	@Override
	public List<ProgramacionAnual> buscarOrdenadoPorAnno() {
		// TODO Auto-generated method stub
		return programacionAnualRepository.buscarOrdenadoPorAnno();
	}

	
}
