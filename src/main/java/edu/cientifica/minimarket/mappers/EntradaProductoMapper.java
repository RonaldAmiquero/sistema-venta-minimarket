package edu.cientifica.minimarket.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EntradaProductoMapper {

	@Select("select max(id_ep) + 1 as codigo from entradaproductos")
	@ResultType(Integer.class)
	public int findIdEntradaProd();
}
