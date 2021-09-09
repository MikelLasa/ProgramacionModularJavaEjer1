package accesoaDatosEjer1;

import java.util.Scanner;

public class ejer1 {

	public static void main(String[] args) {
		int cantidad=pedirCantidad();
		double media;
		int edadAlumnos[];
		String nomAlumnos[];

		edadAlumnos=edadAlumno(cantidad);
		nomAlumnos=nombreAlumno(cantidad);
		imprimirInfo(edadAlumnos, nomAlumnos);
		imprimirMedia(edadAlumnos, cantidad);
		mayorEdad(edadAlumnos, nomAlumnos);
		menorEdad(edadAlumnos, nomAlumnos);
		nomLargo(nomAlumnos);
	}

	public static int pedirCantidad() {
		int cantidad = 0;
		Scanner sc=new Scanner(System.in);
		boolean repetir=true;
		while(repetir || cantidad<=0) {
			System.out.println("Introduce el numero de alumnos de la aula");
			try {
				cantidad=sc.nextInt();
				repetir=false;
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("error");
			}
			
		}
		return cantidad;
	}

	public static String []nombreAlumno(int cantidad){
		String []nombreAlumno=new String[cantidad];
		String nombre;
		Scanner sc=new Scanner(System.in);

		for(int i=0;i<nombreAlumno.length;i++) {
			System.out.println("Introduce el nombre");
			nombre=sc.nextLine();
			nombreAlumno[i]=nombre;
		}
		return nombreAlumno;
	}
	
	public static int []edadAlumno(int cantidad){
		int []edadAlumno=new int[cantidad];
		int edad = 0;
		boolean val;
		
		Scanner sc=new Scanner(System.in);

		for(int i=0;i<edadAlumno.length;i++) {
			val=true;
			while(val || edad<=0 || edad>100) {
				System.out.println("Introduce la edad");
				try {
					edad=sc.nextInt();
					val=false;
				}catch(Exception e) {
					sc.nextLine();
					System.out.println("error");
				}
			}
			edadAlumno[i]=edad;
		}
		return edadAlumno;
	}


	public static void imprimirInfo(int edadAlumnos[], String nomAlumnos[]) {
		for(int i=0;i<edadAlumnos.length;i++) {
			System.out.println("El alumno se llama "+nomAlumnos[i]+" y tiene "+edadAlumnos[i]+" años");
		}
	}

	public static void imprimirMedia(int edadAlumno[], int cantidad) {
		int suma=0;
		double media;

		for(int i=0;i<edadAlumno.length;i++) {
			suma=suma+edadAlumno[i];
		}
		media=(double)suma/cantidad;
		System.out.println("La media de años es "+media);
	}

	public static void mayorEdad(int edad[], String nombre[]) {
		int edadMayor=0;
		int posicion=0;
		for(int i=0;i<edad.length;i++) {
			if(edadMayor<edad[i]) {
				edadMayor=edad[i];
				posicion=i;
			}
		}
		System.out.println(nombre[posicion]+" tiene la mayor edad, que es "+edad[posicion]);
	}

	public static void menorEdad(int edad[], String nombre[]) {
		int edadMenor=edad[0];
		int posicion=0;
		for(int i=0;i<edad.length;i++) {
			if(edadMenor>edad[i]) {
				edadMenor=edad[i];
				posicion=i;
			}
		}
		System.out.println(nombre[posicion]+" tiene la menor edad, que es "+edad[posicion]);
	}
	
	public static void nomLargo(String nombre[]) {
		int largo=0;
		int posicion=0;
		for(int i=0;i<nombre.length;i++) {
			if(largo<nombre[i].length()) {
				largo=nombre[i].length();
				posicion=i;
			}
		}
		System.out.println(nombre[posicion]+" tiene el nombre mas largo");
	}
}
