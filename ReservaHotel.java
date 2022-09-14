package hotel;
//librerias
import java.util.Scanner;
public class ReservaHotel {
 // variables detección en
    static Scanner scanner = new Scanner ( System.in ) ;
    static int select = -1 ;
    static int selectz ;
    static int select3 ;

 // estamos utlizando el metodo scanner el cual permite que el usuario interactue con la consola
 // variables globales de tipo entero
    public static int HabSencilla ;
    public static int HabDoble ;
    public static int HabFamiliar ;
    public static int CanHuesped = 0 ;
 // variable global base de datos de tipo aray string
    public static String [ ] [ ] BD= new String [ 100 ] [ 4 ] ;
    public static String ID;
    public static void main ( String [] args ) {
     // variable de habitaciones
        HabSencilla= 10;
        HabDoble= 10;
        HabFamiliar= 10;
     // mend general
        while ( select != 0 ) {
        try {
             // impresión de opciones del menú
                System.out.println ( " Elige opción : "
                        + "\n1. - Verificar Disponibilidad"
                        + "\n2.- Consultar Huésped "
                        + "\n3.- Registar Reserva"
                        + "\n4.- Eliminar Reserva"
                        + "\n5.- Mostrar Reservas "
                        + "\n0.- Salir " ) ;
                select= Integer.parseInt(scanner.nextLine ( ) ) ;
             //seleccion menu
                switch (select) {
                case 1: ValDisponibilidad();
                break;
                case 2: CanHuesped();
                break;
                case 3: RegHuesped();
                break;
                case 4: Eliminar();
                break;
                case 5: MosReserva();
                break;
                case 0:
            
				System.out.println("Adiós!");
            break;
                default: 
            	 //opcion para ingresos erroneos
            
				System.out.println("Opción no válida");
            break;
            }
                System.out.println("\n");
        }
        catch (NumberFormatException e) {
        System.out.println("Error!");
            }
        }
    }
 //función para validar disponibilidad
    public static void ValDisponibilidad() {
	System.out.println("\n\n Disponibilidad Habitaciones: ");
	System.out.println("\nHabitaciones Sencillas Registradas: " + HabSencilla);
	System.out.println("Habitaciones Dobles Registradas: " + HabDoble);
	System.out.println("Habitaciones Familiares Registradas: " + HabFamiliar);
	
	 //Mostrar un salto de linea en Java
	System.out.println("\n");
}
 //función para consultar clientes
        public static void CanHuesped() {
	System.out.println("Ingresar Numero Identificación A Consultar: ");
	ID = scanner.nextLine();
	
	for (int i = 0; i <= 99; i++) {
		if (BD[i][0] == null ) {
			
		} else {
			if (BD[i][0].contains(ID)) {
				System.out.println("\n\nCliente Registrado: ");
				System.out.println("ID: " + BD[i][0]);
				System.out.println("Nombre: " + BD[i][1]);
				System.out.println("Tipo De Habitación: " + BD[i][2]);
				System.out.println("Desayuno: " + BD[i][3]);
			}
		}
	}
}

 //Función para eliminar clientes
public static void Eliminar() {
	System.out.println("Ingresar Numero Identificación A Eliminar: ");
	ID = scanner.nextLine();
	
	for (int i = 0; i <= 99; i++) {
		if (BD[i][0] == null) {
			
		} else {
			if (BD[i][0].contains(ID)) {
				System.out.println("\n\nReserva Eliminada Con éxito ");
				System.out.println("ID: " + BD[i][0]);
				System.out.println("Nombre: " + BD[i][1]);
				System.out.println("Tipo de Habitación: " + BD[i][2]);
				System.out.println("Desayuno: " + BD[i][3]);
				
				BD[i][0] = "";
				BD[i][1] = "";
				BD[i][2] = "";
				BD[i][3] = "";
			}
		}
    }
}

 //Función para Registro de Huesped
public static void RegHuesped() {
	 //ingreso selecciones de clientes
	System.out.println("Ingresar Numero Identificación Huesped: ");
	BD[CanHuesped][0] = scanner.nextLine();
	System.out.println("Ingresar Nombre Huesped: ");
	BD[CanHuesped][1] = scanner.nextLine();
	
	 //menú selección de habitación
	System.out.println("Ingresar Tipo Habitación: ");
	System.out.println("Tipo Habitación:"
			+ "\n1.- Habitación Sencilla"
			+ "\n2.- Habitación Doble"
			+ "\n3.- Habitación Familiar");
	
	 //Captura de selección
	int select2 = Integer.parseInt(scanner.nextLine());
	if (select2 == 1) {
		BD[CanHuesped][2] = "Habitación Sencilla";
		HabSencilla = HabSencilla - 1;
	}
	else {
		if(select2 == 2) {
			BD[CanHuesped][2] = "Habitación Doble";
			HabDoble = HabDoble - 1;
	} else {
		if (select2 == 3) {
			BD[CanHuesped][2] = "Habitación Familiar";
			HabFamiliar = HabFamiliar - 1;
		} else {
			System.out.println("Ha Ingresado una opción NO válida, Registro Inválido ");
		}
		}
	}
	
	 //consulta de desayuno
	System.out.println("Desayuno: "
			+ "\n1.- Si"
			+ "\n2.- No");
	select3 = Integer.parseInt(scanner.nextLine());
	if (select3 == 1) {
		BD[CanHuesped][3] = "Si";
	} else {
		if (select3 == 2) {
			BD[CanHuesped][3] = "No";
		} else {
			System.out.println("Ha Ingresado una opción NO válida, Registro Inválido ");
		}
	}
	
	 //variable que se autoincrementa aumentando la cantidad de clientes en el hotel
	CanHuesped = CanHuesped + 1;
}
 //Función mostrar base de datos reserva array BD
public static void MosReserva() {
	System.out.println("\n\nBase De Datos Reservas: \n");
	
	 //Dos ciclos for para mostrar array de dos dimensiones
	for (int i = 0; i <= 99; i++) {
	for (int j = 0; j <= 3; j++); {
			if (BD[i][j] == null) {
				
			} else {
				System.out.println(BD[i][j] + " ");
			}
		}
		//se valida si la posición está vacia para no mostrar valores nulos
		if (BD[i][0] == null) {
			
		} else {
			System.out.println("\n");
		}
	}
}
}