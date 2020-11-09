package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import edu.cientifica.minimarket.model.Proveedor;

@Mapper
public interface ProveedorMapper {
	/*
	@Select("SELECT pe.id, pe.nombre, pe.email, pe.telefono, pe.direccion, p.ruc, p.nombre_empresa,"
			+ "p.comercializa FROM proveedores p INNER JOIN personas pe ON pe.id = p.id_proveedor;")
	@ResultMap("edu.cientifica.minimarket.mappers.ProveedorMapper.proveedorResulMap")*/
	public List<Proveedor> findAllProveedores();

}
