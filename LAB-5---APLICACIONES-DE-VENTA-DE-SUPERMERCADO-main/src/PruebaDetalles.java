import java.time.LocalDate;

public class PruebaDetalles {
    public static void main(String[] args) {

        ProductoAlimentario producto = new ProductoAlimentario(
                "P001",
                "Leche",
                85.50,
                10,
                "Lácteos",
                LocalDate.of(2026, 12, 15)
        );

        Cliente cliente = new Cliente(
                "C001",
                "Juan Pérez",
                "001-1234567-8"
        );

        producto.mostrarDetalle();
        IO.println("-------------------");
        cliente.mostrarDetalle();

        IO.println("Producto retorna this: "
                + (producto.mostrarDetalle() == producto));

        IO.println("Cliente retorna this: "
                + (cliente.mostrarDetalle() == cliente));
    }
}