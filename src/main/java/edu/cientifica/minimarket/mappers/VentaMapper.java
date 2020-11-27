package edu.cientifica.minimarket.mappers;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
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

	@Insert("INSERT INTO ventas (id_venta, id_cliente, id_empleado, id_cp) "
			+ "VALUES (#{idVenta}, #{cliente.id}, #{empleado.id}, #{comprobantePago.idComprobanteP})")
	public int insertVenta(Venta venta);

	public List<Venta> findAllVentas();
	
	@Select("SELECT v.id_venta, p.nombre, cp.fecha, cp.total_venta, cp.metodo_pago, cp.id_tc FROM ventas v INNER JOIN personas p INNER JOIN comprobantepago cp ON (v.id_cliente = p.id and v.id_cp = cp.id_cp) WHERE fecha BETWEEN #{fechaInicio} AND #{fechaFin}")
	@ResultMap("edu.cientifica.minimarket.mappers.VentaMapper.ventaResultMap")
	public List<Venta> findVentas(Date fechaInicio, Date fechaFin);


}
