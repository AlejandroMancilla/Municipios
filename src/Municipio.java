public class Municipio {
    private String Nombre;
    private int Poblacion;
    private float Area;
    
    public Municipio(String nombre, int poblacion, float area) {
        Nombre = nombre;
        Poblacion = poblacion;
        Area = area;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(int poblacion) {
        Poblacion = poblacion;
    }

    public float getArea() {
        return Area;
    }

    public void setArea(float area) {
        Area = area;
    }

    @Override
    public String toString() {
        return "-".repeat(32) + "\nMUNICIPIO\n\tNombre = " + Nombre + "\n\tPoblacion = " + Poblacion + "\n\tArea = " + Area +"\n" + "-".repeat(32);
    }
}
