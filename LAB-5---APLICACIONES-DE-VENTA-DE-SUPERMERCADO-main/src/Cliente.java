public class Cliente {
    private String id;
    private String nombreCompleto;
    private String cedula;

    public Cliente(String id, String nombreCompleto, String cedula) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
    }

    public Cliente mostrarDetalle() {
        IO.println("ID: " + id);
        IO.println("Nombre: " + nombreCompleto);
        IO.println("Cédula: " + cedula);

        return this;
    }
}