package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import edu.cientifica.minimarket.model.Proveedor;

@Mapper
public interface ProveedorMapper {
	
	public List<Proveedor> findAllProveedores();

	/*@Insert("INSERT INTO personas (id, nombre, email, telefono, direccion) values(#{id}, #{nombre}, #{email}, #{telefono},#{direccion} );\n"
			+ "INSERT INTO proveedores(id_proveedor, ruc, nombre_empresa, comercializa) values(#{id},#{ruc},#{nombreEmpresa},#{comercializa});")*/
	
	@Insert("INSERT INTO proveedores(id_proveedor, ruc, nombre_empresa, comercializa) values(#{id},#{ruc},#{nombreEmpresa},#{comercializa})")
	public int addProveedor(Proveedor proveedor);
		
	@Select("select max(id_proveedor) + 1 as codigo from proveedores")
	@ResultType(Integer.class)
	public int findId();
	
	@Select("SELECT * FROM proveedores WHERE id_proveedor = #{id}")
	@ResultMap("edu.cientifica.minimarket.mappers.ProveedorMapper.proveedorResultMap")
	public Proveedor finProveedorId(int id);
	
	@Update("UPDATE proveedores SET ruc= #{ruc}, nombre_empresa= #{nombreEmpresa}, comercializa= #{comercializa} WHERE id_proveedor= #{id} ")
    public int updateProveedor(Proveedor proveedor); 
	
    /*@Update("UPDATE proveedores SET(id_proveedor, ruc, nombre_empresa, comercializa) values(#{id},#{ruc},#{nombreEmpresa},#{comercializa})")
	public int updateProveedor(Proveedor proveedor);*/
	


	
}
