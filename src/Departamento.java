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

    public void EliminarMunicipio(int Index) {
        this.Municipios.remove(Index);
        CalcularAP();
    }

    public void CalcularAP() {
        this.AreaTotal = 0;
        this.Poblacion = 0;
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
        if(Municipios.size() > 0){
            System.out.println("-".repeat(33));
            System.out.printf("|%-20s|%-10s|%n", "MUNICIPIO", "ÁREA");
            System.out.println("+" + "-".repeat(20) + "+" + "-".repeat(10) + "+");
            for (Municipio M : Municipios) {
                System.out.printf("|%20s|%10s|%n", M.getNombre(), String.valueOf(M.getArea()));
            }
            System.out.println("-".repeat(33));
        }
        return AreaTotal;
    }

    public void setAreaTotal(float areaTotal) {
        AreaTotal = areaTotal;
    }

    public int getPoblacion() {
        if(Municipios.size() > 0){
            System.out.println("-".repeat(35));
            System.out.printf("|%-20s|%-12s|%n", "MUNICIPIO", "POBLACIÓN");
            System.out.println("+" + "-".repeat(20) + "+" + "-".repeat(12) + "+");
            for (Municipio M : Municipios) {
                System.out.printf("|%20s|%12s|%n", M.getNombre(), String.valueOf(M.getPoblacion()));
            }
            System.out.println("-".repeat(35));
        }
        return Poblacion;
    }

    public void setPoblacion(int poblacion) {
        Poblacion = poblacion;
    }

    public void ListarMunicipios() {
        if(Municipios.size() == 0) {
            System.out.println("Departamento sin Municipios");
        }else{
            System.out.printf("|%-2s|%-20s|%-12s|%-12s|%n", "ID", "MUNICIPIO", "POBLACIÓN", "ÁREA");
            System.out.println("+" + "-".repeat(2) + "+" + "-".repeat(20) + "+" + "-".repeat(12) + "+" + "-".repeat(12) + "+");
            int Count = 1;
            for (Municipio M : Municipios) {
                System.out.printf("|%-2d|%20s|%12s|%12s|%n", Count, M.getNombre(), String.valueOf(M.getPoblacion()), String.valueOf(M.getPoblacion()));
                Count++;
            }
            System.out.println("+" + "-".repeat(2) + "+" + "-".repeat(20) + "+" + "-".repeat(12) + "+" + "-".repeat(12) + "+");
        }
    }
    
}
