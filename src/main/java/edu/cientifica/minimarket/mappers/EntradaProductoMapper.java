package edu.cientifica.minimarket.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import edu.cientifica.minimarket.model.DetalleEntradaProducto;
import edu.cientifica.minimarket.model.EntradaProducto;

@Mapper
public interface EntradaProductoMapper {

	@Select("select max(id_ep) + 1 as codigo from entradaproductos")
	@ResultType(Integer.class)
	public int findIdEntradaProd();
	
	@Insert("INSERT INTO entradaproductos (id_ep, nro_factura, fecha_ingreso, id_proveedor) "
			+ "VALUES (#{idEproducto}, #{nroFactura}, #{fechaIngreso}, #{proveedor.id})")
	public int saveEntradaProducto(EntradaProducto entradap);

	@Insert("INSERT INTO entradaproductos_productos (id_ep, id_producto, cantidad_ingresado, costo_unitario, fechav_nuevo) "
			+ "VALUES (#{entradaProducto.idEproducto}, #{producto.idProducto}, #{cantidadIngresado}, #{costoUnitario}, #{fechavNuevo})")
	public int saveDetalleEntradaProducto(DetalleEntradaProducto detalleEP);
}
