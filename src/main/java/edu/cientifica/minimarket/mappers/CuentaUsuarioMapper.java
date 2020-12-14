package edu.cientifica.minimarket.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.cientifica.minimarket.model.CuentaUsuario;


@Mapper
public interface CuentaUsuarioMapper {
	@Select("select max(id_cuenta) + 1 as codigo from cuentausuarios")
	@ResultType(Integer.class)
	
	public int completarId();
	
	@Select("Select * From cuentausuarios usuario\n" + 
			"    Inner Join empleados e\n" + 
			"    On usuario.id_empleado = e.id_empleado\n" + 
			"    Inner Join personas p\n" + 
			"    On e.id_empleado = p.id\n" + 
			"    Inner Join cuentausuarios_permisos permisos\n" + 
			"    On usuario.id_cuenta=permisos.id_cuenta\n" + 
			"    Inner Join permisos permiso\n" + 
			"    On permisos.id_permiso=permiso.id_permiso\n" + 
			"    Where  usuario.id_cuenta =#{idCuenta}")
	@ResultMap("edu.cientifica.minimarket.mappers.CuentaUsuarioMapper.usuarioResultMap")
	public CuentaUsuario findCuentaUsuarioId(int idCuenta);
	
	@Select("SELECT * FROM cuentausuarios")
	@ResultMap("edu.cientifica.minimarket.mappers.CuentaUsuarioMapper.usuarioResultMap")
	public List<CuentaUsuario> findAllUsuarios();
	
	@Update("UPDATE cuentausuarios SET usuario= #{usuario}, contrasenha= #{contrasenha}, tipo_usuario= #{tipoUsuario}, "
			+ "id_empleado= #{empleado.id} WHERE id_cuenta= #{idCuenta}")
	public int updateCuentaUsuario(CuentaUsuario usuario);
	
	@Select("SELECT * FROM empleados where id_empleado = #{empleado.id}")
	@ResultMap("edu.cientifica.minimarket.mappers.CuentaUsuarioMapper.usuarioResultMap")
	public CuentaUsuario findIdCuentaUsuario(int idCuenta);
	
	@Insert("INSERT INTO cuentausuarios (id_cuenta, usuario, contrasenha, tipo_usuario, id_empleado) "
			+ "VALUES (#{idCuenta}, #{usuario}, #{contrasenha}, #{tipoUsuario}, #{empleado.id})")
	public int addUsuario(CuentaUsuario usuario);
	
	public CuentaUsuario encontrarNombreUsuario(String username);
}
