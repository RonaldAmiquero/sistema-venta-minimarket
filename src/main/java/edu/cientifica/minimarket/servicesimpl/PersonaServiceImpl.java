package edu.cientifica.minimarket.servicesimpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.PersonaMapper;
import edu.cientifica.minimarket.model.Persona;
import edu.cientifica.minimarket.model.Proveedor;
import edu.cientifica.minimarket.services.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	protected final Log LOG = LogFactory.getLog(this.getClass());

	
	@Autowired
	PersonaMapper personaMapper;
	
	@Override
	public int registrarPersona(Proveedor proveedor) {
		
		return personaMapper.savePersona(proveedor);
	}
	
	public int actualizarPersona(Proveedor proveedor) {
		int result;
		result = personaMapper.updatePersona(proveedor);
		LOG.info("Numero de registros afectados : " + result);
		return result;
}

	@Override
	public Persona buscarPersonarId(int id) {
		// TODO Auto-generated method stub
		return personaMapper.findPersonaId(id);
	}
}
