import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    static Scanner sc = new Scanner(System.in);
    static List<Departamento> Departamentos = new ArrayList<Departamento> ();
    public static void main(String[] args) throws Exception {
        MostrarMenu();
    }

    static void MostrarMenu() throws Exception {
        int Opc;
        do {
            LimpiarConsola();
            System.out.println("*********** MENU PRINCIPAL **********");
            System.out.println("\t1. Agregar Departamento");
            System.out.println("\t2. Agregar Municipio a Departamento");
            System.out.println("\t3. Listar Departamentos");
            System.out.println("\t4. Listar Municipios de Departamento");
            System.out.println("\t5. Buscar Municipio en Departamento");
            System.out.println("\t6. Eliminar Municipio");
            System.out.println("\t7. Calcular Censo de Departamento");
            System.out.println("\t8. Calcular Área Total de Departamento");
            System.out.println("\t0. Salir");
            System.out.println("************************************");
            System.out.print("Seleccione una Opción del Menú: ");
            Opc = sc.nextInt();
            sc.nextLine();
            switch (Opc) {
                case 1:
                    AgregarDepartamento();
                    sc.next();
                    break;
                case 2:
                    AgregarMunicipio();
                    break;
                case 3:
                    ListarDepartamentos();
                    sc.next();
                    break;
                case 4:
                    ListarMunicipios();
                    sc.next();
                    break;
                case 5:
                    BuscarMunicipio();
                    sc.next();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
            
                default:
                System.out.println("¡Opción No Válida!");
                    break;
            }
        }while(Opc != 0);
    }
    
    static void AgregarDepartamento() {
        String Nombre, NomGob, Correo, Celular;
        System.out.print("Nombre de Departamento: ");
        Nombre = sc.nextLine();
        System.out.print("Nombre de Gobernador: ");
        NomGob = sc.nextLine();
        System.out.print("Correo de Gobernador: ");
        Correo = sc.nextLine();
        System.out.print("Celular de Gobernador: ");
        Celular = sc.nextLine();
        Departamento D = new Departamento(Nombre.toUpperCase(), new Persona(NomGob.toUpperCase(), Celular, Correo.toUpperCase()));
        Departamentos.add(D);
        System.out.println("\tDEPARTAMENTO AGREGADO EXITOSAMENTE");
    }

    static void ListarDepartamentos() {
        System.out.println("***** LISTADO DEPARTAMENTOS *****");
        int Cont = 1;
        for (Departamento D: Departamentos) {
            System.out.println("\t" + Cont + ". " + D.getNombre());
            Cont++;
        }
    }

    static void ListarMunicipios() {
        ListarDepartamentos();
        System.out.print("Seleccione Departamento de la lista: ");
        int Select = sc.nextInt();
        sc.nextLine();
        if (Select > 0 && Select <= Departamentos.size()) {
            LimpiarConsola();
            System.out.println("DEPARTAMENTO: " + Departamentos.get(Select-1).getNombre());
            System.out.println("Gobernador: " + Departamentos.get(Select-1).getGobernador().getNombre());
            Departamentos.get(Select-1).ListarMunicipios();
        }
    }

    static void AgregarMunicipio() {
        ListarDepartamentos();
        System.out.print("Seleccione Departamento de la lista: ");
        int Select = sc.nextInt();
        sc.nextLine();
        if (Select > 0 && Select <= Departamentos.size()) {
            LimpiarConsola();
            System.out.println("NUEVO MUNICIPIO EN " + Departamentos.get(Select-1).getNombre());
            String Nombre;
            int Poblacion;
            float Area;
            System.out.print("Nombre de Municipio: ");
            Nombre = sc.nextLine();
            System.out.println("Población de Municipio: ");
            Poblacion = sc.nextInt();
            System.out.println("Área de Municipio: ");
            Area = sc.nextFloat();
            Municipio M = new Municipio(Nombre, Poblacion, Area);
            Departamentos.get(Select-1).NuevoMunicipio(M);
            System.out.println("MUNICIPIO AGREGADO EXITOSAMENTE");
        }else{
            System.out.println("¡Opción No Válida!");
        }
    }

    static void BuscarMunicipio() {
        ListarDepartamentos();
        System.out.print("Seleccione Departamento de la lista: ");
        int Select = sc.nextInt();
        sc.nextLine();
        if (Select > 0 && Select <= Departamentos.size()) {
            LimpiarConsola();
            System.out.println("BUSCAR MUNICIPIO EN " + Departamentos.get(Select-1).getNombre());
            System.out.println("Ingrese Nombre de Municipio: ");
            String Busqueda = sc.nextLine();
            
        }
    }

    static void LimpiarConsola() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

}
