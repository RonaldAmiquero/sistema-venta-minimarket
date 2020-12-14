package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.cientifica.minimarket.model.Persona;
import edu.cientifica.minimarket.model.Proveedor;


@Mapper
public interface PersonaMapper {
	
	public List<Persona> findAllPersonas(); 
	
	@Insert ("INSERT INTO personas (id, nombre, email, telefono, direccion) values(#{id}, #{nombre}, #{email}, #{telefono},#{direccion})")
	public int savePersona(Proveedor proveedor);
	
		
	@Select("SELECT * FROM personas WHERE id= #{id}")
	@ResultMap("edu.cientifica.minimarket.mappers.PersonaMapper.personaResultMap")
	public Persona findPersonaId(int id);
	 
	
	 @Update("UPDATE personas SET id= #{id}, nombre= #{nombre}, email= #{email}, telefono= #{telefono}, direccion= #{direccion} WHERE id= #{id} ")
	public int updatePersona(Proveedor proveedor); 
	
	 /*@Update ("UPDATE personas SET (id, nombre, email, telefono, direccion) values(#{id}, #{nombre}, #{email}, #{telefono},#{direccion})")
	public int updatePersona(Proveedor proveedor);*/
	
	/*
	@Select("SELECT * FROM personas")
	@ResultMap("edu.cientifica.minimarket.mappers.PersonaMapper.personaResultMap")
	public List<Persona> findAllPersonas();*/

	
	
}
