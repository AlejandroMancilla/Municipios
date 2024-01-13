import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    static Scanner sc = new Scanner(System.in);
    static List<Departamento> Departamentos = new ArrayList<Departamento> ();
    public static void main(String[] args) throws Exception {
        CargarDatos();
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
            System.out.println("\t8. Calcular Ýrea Total de Departamento");
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
                    EliminarMunicipio();
                    sc.next();
                    break;
                case 7:
                    CalcularCenso();
                    sc.next();
                    break;
                case 8:
                    CalcularArea();
                    sc.next();
                    break;
                case 0:
                    break;
                default:
                System.out.println("¡Opción No Válida!");
                    break;
            }
        }while(Opc != 0);
    }
    
    static void AgregarDepartamento() {
        String Nombre, NomGob, Correo, Celular, Partido;
        System.out.print("Nombre de Departamento: ");
        Nombre = sc.nextLine();
        System.out.print("Nombre de Gobernador: ");
        NomGob = sc.nextLine();
        System.out.print("Correo de Gobernador: ");
        Correo = sc.nextLine();
        System.out.print("Celular de Gobernador: ");
        Celular = sc.nextLine();
        System.out.print("Partido Politico de Gobernador: ");
        Partido = sc.nextLine();
        Departamento D = new Departamento(Nombre.toUpperCase(), new Persona(NomGob.toUpperCase(), Celular, Correo.toUpperCase(), Partido));
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

    static int ListarMunicipios() {
        ListarDepartamentos();
        System.out.print("Seleccione Departamento de la lista: ");
        int Select = sc.nextInt();
        sc.nextLine();
        if (Select > 0 && Select <= Departamentos.size()) {
            LimpiarConsola();
            System.out.println("-> DEPARTAMENTO: " + Departamentos.get(Select-1).getNombre());
            System.out.println("Gobernador: " + Departamentos.get(Select-1).getGobernador().getNombre());
            Departamentos.get(Select-1).ListarMunicipios();
        }
        return Select - 1;
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
            System.out.println("Ýrea de Municipio: ");
            Area = sc.nextFloat();
            Municipio M = new Municipio(Nombre.toUpperCase(), Poblacion, Area);
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
            System.out.print("Ingrese Nombre de Municipio: ");
            String Busqueda = sc.nextLine();
            for (Municipio M : Departamentos.get(Select-1).getMunicipios()) {
                M.toString();
                if(M.getNombre().contains(Busqueda.toUpperCase())) {
                    System.out.println(M.toString());
                }
            }
            
        }
    }

    static void EliminarMunicipio() {
        int Dep = ListarMunicipios();
        if(Departamentos.get(Dep).getMunicipios().size() == 0) {
            System.out.println("¡No existen Municipios para eliminar!");
        }else{
            System.out.print("Seleccione ID de Municipio a eliminar: ");
            int Select = sc.nextInt();
            sc.nextLine();
            if (Select > 0 && Select <= Departamentos.get(Dep).getMunicipios().size()) {
                Departamentos.get(Dep).EliminarMunicipio(Select-1);
                System.out.println("MUNICIPIO ELIMINADO EXITOSAMENTE");
            }else{
                System.out.println("¡Opción No Válida!");
            }
        }
        
    }

    static void CalcularCenso() {
        ListarDepartamentos();
        System.out.print("Seleccione Departamento de la lista: ");
        int Select = sc.nextInt();
        sc.nextLine();
        if (Select > 0 && Select <= Departamentos.size()) {
            LimpiarConsola();
            System.out.println("CENSO TOTAL DE " + Departamentos.get(Select-1).getNombre());
            System.out.println("Población Total = " + Departamentos.get(Select-1).getPoblacion());
        }else{
            System.out.println("¡Opción No Válida!");
        }
    }

    static void CalcularArea() {
        ListarDepartamentos();
        System.out.print("Seleccione Departamento de la lista: ");
        int Select = sc.nextInt();
        sc.nextLine();
        if (Select > 0 && Select <= Departamentos.size()) {
            LimpiarConsola();
            System.out.println("ÁREA TOTAL DE " + Departamentos.get(Select-1).getNombre());
            System.out.println("Área Total = " + Departamentos.get(Select-1).getAreaTotal());
        }else{
            System.out.println("��Opción No Válida!");
        }
    }

    static void LimpiarConsola() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    static void CargarDatos() {
        Departamento departamento1 = new Departamento("ANTIOQUIA", new Persona("Juan Perez", "123456789", "juan.perez@example.com", "Partido A"));
        departamento1.NuevoMunicipio(new Municipio("MEDELLIN", 2500000, 382.9f));
        departamento1.NuevoMunicipio(new Municipio("ENVIGADO", 200000, 38.5f));
        departamento1.NuevoMunicipio(new Municipio("ITAGUI", 180000, 32.7f));
        
        Departamento departamento2 = new Departamento("BOGOTA D.C.", new Persona("Maria Rodriguez", "987654321", "maria.rodriguez@example.com", "Partido B"));
        
        Departamento departamento3 = new Departamento("VALLE DEL CAUCA", new Persona("Carlos Sanchez", "555123456", "carlos.sanchez@example.com", "Partido C"));
        departamento3.NuevoMunicipio(new Municipio("CALI", 2400000, 564.2f));
        departamento3.NuevoMunicipio(new Municipio("PALMIRA", 300000, 120.5f));
        departamento3.NuevoMunicipio(new Municipio("YUMBO", 150000, 80.0f));

        Departamento departamento4 = new Departamento("ATLANTICO", new Persona("Laura Gomez", "999888777", "laura.gomez@example.com", "Partido A"));
        
        Departamento departamento5 = new Departamento("SANTANDER", new Persona("Pedro Martinez", "111222333", "pedro.martinez@example.com", "Partido B"));
        departamento5.NuevoMunicipio(new Municipio("BUCARAMANGA", 600000, 150.5f));
        departamento5.NuevoMunicipio(new Municipio("FLORIDABLANCA", 300000, 80.2f));
        departamento5.NuevoMunicipio(new Municipio("GIRON", 150000, 50.5f));
        departamento5.NuevoMunicipio(new Municipio("PIEDECUESTA", 200000, 60.8f));
        
        Departamentos.add(departamento1);
        Departamentos.add(departamento2);
        Departamentos.add(departamento3);
        Departamentos.add(departamento4);
        Departamentos.add(departamento5);
    }

}
