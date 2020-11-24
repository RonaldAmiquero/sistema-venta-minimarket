package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import edu.cientifica.minimarket.model.ComprobantePago;
import edu.cientifica.minimarket.model.TipoComprobante;

@Mapper
public interface ComprobantePagoMapper {
	
	@Select("SELECT * FROM tipocomprobante")
	@ResultMap("edu.cientifica.minimarket.mappers.ComprobantePagoMapper.tipoComprobanteResultMap")
	public List<TipoComprobante> findAllTipoComprobante();
	
	@Select("SELECT max(id_cp)+1 as codigo FROM comprobantepago")
	@ResultType(Integer.class)
	public int findIdComprobante();
	
	@Insert("INSERT INTO comprobantepago (id_cp, fecha, subtotal, igv, total_venta, metodo_pago, id_tc) "
			+ "VALUES (#{idComprobanteP}, #{fecha}, #{subTotal}, #{igv}, #{totalVenta}, #{metodoPago}, #{tipoComprobante.idTipoC})")
	public int insertComprobante(ComprobantePago comprobante);

	public List<ComprobantePago> findAllComprobantePago();

}
