import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Departamento {
    Scanner sc = new Scanner(System.in);
    private String Nombre;
    private Persona Gobernador;
    private List<Municipio> Municipios;
    private float AreaTotal;
    private int Poblacion;
    
    public Departamento(String nombre, Persona gobernador) {
        this.Nombre = nombre;
        this.Gobernador = gobernador;
        this.AreaTotal = 0;
        this.Poblacion = 0;
        this.Municipios = new ArrayList<Municipio>();
    }

    public void NuevoMunicipio(Municipio M) {
        this.Municipios.add(M);
        CalcularAP();
    }

    public void CalcularAP() {
        for (Municipio M : Municipios) {
            this.AreaTotal += M.getArea();
            this.Poblacion += M.getPoblacion();
        }
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Persona getGobernador() {
        return Gobernador;
    }

    public void setGobernador(Persona gobernador) {
        Gobernador = gobernador;
    }

    public List<Municipio> getMunicipios() {
        return Municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        Municipios = municipios;
    }

    public float getAreaTotal() {
        return AreaTotal;
    }

    public void setAreaTotal(float areaTotal) {
        AreaTotal = areaTotal;
    }

    public void ListarMunicipios() {
        if(Municipios.size() == 0) {
            System.out.println("Departamento sin Municipios");
        }else{
            for (Municipio M : Municipios) {
                System.out.println(M.getNombre());
                System.out.printf("%,d %n" , M.getPoblacion());
                System.out.println( M.getPoblacion());
            }
        }
    }
    
}
