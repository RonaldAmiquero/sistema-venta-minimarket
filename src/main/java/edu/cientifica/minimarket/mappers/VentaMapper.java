package edu.cientifica.minimarket.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VentaMapper {
	
	@Select("select max(id_venta) + 1 as codigo from ventas")
	@ResultType(Integer.class)
	public int findIdVenta();

}
