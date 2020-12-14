package edu.cientifica.minimarket.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import edu.cientifica.minimarket.model.CuentaUsuario;


@Mapper
public interface CuentaUsuario_PermisoMapper {
	@Insert("INSERT INTO cuentausuarios_permisos (id_cuenta, id_permiso) VALUES (#{idCuenta}, #{permisos.idPermiso})")
	public int addPermiso(CuentaUsuario permiso);
	@Update("UPDATE cuentausuarios_permisos SET id_cuenta= #{idCuenta}, id_permiso= #{permisos.idPermiso} WHERE id_cuenta= #{idCuenta}")
	public int updateCuentaUsuarioPermiso(CuentaUsuario permiso);
}
