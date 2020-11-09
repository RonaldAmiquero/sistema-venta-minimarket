package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import edu.cientifica.minimarket.model.Proveedor;

@Mapper
public interface ProveedorMapper {
	
	public List<Proveedor> findAllProveedores();

	
}
