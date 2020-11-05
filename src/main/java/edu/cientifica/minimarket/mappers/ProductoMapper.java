package edu.cientifica.minimarket.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.cientifica.minimarket.model.Producto;

@Mapper
public interface ProductoMapper {
	
	/*
	 @Insert("INSERT INTO unidadprivada (id_uprivada, tipo_unidad, numeracion, zona, id_uinmobiliaria) "
			+ "VALUES (#{id}, #{tipoUnidad}, #{numeracion}, #{zona}, #{unidadInmobiliaria.id})" )
	public int addUnidadPrivada(UnidadPrivada unidadPrivada);
	 */
	
	@Insert("INSERT INTO productos (id_producto, codigo_barra, nombre, costo_unitario, precio_venta, stock_producto, fecha_vencimiento, id_categoria) "
			+ "VALUES (#{idProducto}, #{codigoBarras}, #{nombre}, #{costoUnitario}, #{precioVenta}, #{stockProducto}, #{fechaVencimiento}, #{categoria.idCategoria})")
	public int addProducto(Producto producto);
	
	//@Insert("INSERT INTO proveedores_productos(id_producto, id_proveedor) VALUES (#{idProducto}, #{proveedor.id})")
	//public void addTabProductoProveedor(Producto producto);
	
}
