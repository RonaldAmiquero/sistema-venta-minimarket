package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.ClienteMapper;
import edu.cientifica.minimarket.model.Cliente;
import edu.cientifica.minimarket.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteMapper clienteMapper;
	
	@Override
	public List<Cliente> listarClientes() {
		return clienteMapper.findAllClientes();
	}
	
}
