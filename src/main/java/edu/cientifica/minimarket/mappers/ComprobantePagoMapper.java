package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import edu.cientifica.minimarket.model.TipoComprobante;

@Mapper
public interface ComprobantePagoMapper {
	
	@Select("SELECT * FROM tipocomprobante")
	@ResultType(TipoComprobante.class)
	public List<TipoComprobante> findAllTipoComprobante();
	
	@Select("SELECT max(id_cp)+1 as codigo FROM comprobantepago")
	@ResultType(Integer.class)
	public int findIdComprobante();

}
