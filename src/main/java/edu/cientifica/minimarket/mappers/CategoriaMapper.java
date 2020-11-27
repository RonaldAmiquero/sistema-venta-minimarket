package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import edu.cientifica.minimarket.model.Categoria;


@Mapper
public interface CategoriaMapper {
	
	
	@Select("SELECT * FROM categorias")
	@ResultMap("edu.cientifica.minimarket.mappers.CategoriaMapper.categoriaResultMap")
	public List<Categoria> finAllCategory();

}
