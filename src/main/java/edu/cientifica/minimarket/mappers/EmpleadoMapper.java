package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.cientifica.minimarket.model.Empleado;
@Mapper
public interface EmpleadoMapper {

	public List<Empleado> findAllEmpleados();

}
