
public class ProductoNoAlimentario extends Producto {

    public ProductoNoAlimentario(
            String id,
            String nombreProducto,
            double precio,
            int cantidad,
            String categoria) {

        super(id, nombreProducto, precio, cantidad, categoria);
    }

    @Override
    public ProductoNoAlimentario mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Tipo de producto: No alimentario");
        return this;
    }
}
