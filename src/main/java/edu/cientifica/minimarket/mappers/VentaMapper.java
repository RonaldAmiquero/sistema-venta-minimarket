package edu.cientifica.minimarket.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import edu.cientifica.minimarket.model.DetalleVenta;
import edu.cientifica.minimarket.model.Venta;

@Mapper
public interface VentaMapper {
	
	@Select("select max(id_venta) + 1 as codigo from ventas")
	@ResultType(Integer.class)
	public int findIdVenta();

	@Insert("INSERT INTO detalleventa (id_producto, id_venta, cantidad_producto, importe) "
			+ "VALUES (#{producto.idProducto}, #{venta.idVenta}, #{cantidad}, #{importe})")
	public int insertDetalleVenta(DetalleVenta detalleVenta);

	@Insert("INSERT INTO ventas (id_venta, fecha, id_cliente, id_empleado, id_tc) "
			+ "VALUES (#{idVenta}, #{fecha}, #{cliente.id}, #{empleado.id}, #{tipoComprobante.idTipoC})")
	public int insertVenta(Venta venta);

}
