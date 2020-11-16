package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.cientifica.minimarket.model.Cliente;

@Mapper
public interface ClienteMapper {
	
	public List<Cliente> findAllClientes();

}
