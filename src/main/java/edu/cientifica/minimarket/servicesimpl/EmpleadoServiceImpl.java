package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.EmpleadoMapper;
import edu.cientifica.minimarket.model.Empleado;
import edu.cientifica.minimarket.services.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	EmpleadoMapper empleadoMapper;
	
	@Override
	public List<Empleado> listarEmpleados() {
		
		return empleadoMapper.findAllEmpleados();
	}

}
