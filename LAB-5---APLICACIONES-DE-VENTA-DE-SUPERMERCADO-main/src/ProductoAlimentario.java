import java.time.LocalDate;

public class ProductoAlimentario extends Producto {
    private LocalDate fechaVencimiento;

    public ProductoAlimentario(String id, String nombreProducto, double precio, int cantidad, String categoria, LocalDate fechaVencimiento) {
        super(id, nombreProducto, precio, cantidad, categoria);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
public ProductoAlimentario mostrarDetalle() {
    super.mostrarDetalle();
    System.out.println("Fecha de vencimiento: " + fechaVencimiento);
    return this;
}
}