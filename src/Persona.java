public class Persona {
    private String Nombre;
    private String Telefono;
    private String Correo;
    private String Partido;
    
    public Persona(String nombre, String telefono, String correo, String partido) {
        this.Nombre = nombre;
        this.Telefono = telefono;
        this.Correo = correo;
        this.Partido = partido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

}
