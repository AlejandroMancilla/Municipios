public class Persona {
    private String Nombre;
    private String Telefono;
    private String Correo;
    
    public Persona(String nombre, String telefono, String correo) {
        Nombre = nombre;
        Telefono = telefono;
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

}
