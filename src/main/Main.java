package main;
import java.util.ArrayList;

import Utiles.Salieri;
import modelos.Asignaturas;
import modelos.Centros;
import modelos.Profesores;

public class Main {

	public static void main(String[] args) {
		Asignaturas a ;
		Profesores p = new Profesores();
		Centros c= new Centros();
		int opcion =0;
		Salieri ex = new Salieri();
		do {
			opcion= ex.controlaenteroSt("1-Comprobar objeto existente \n"
					+ "2-Insertar. \n"
					+ "3-Borrar. \n"
					+ "4-Modificar \n"
					+ "5-Profesores en un centro \n"
					+ "6-Asignaturas de un profesor\n"
					+ "7-Salir");
			switch(opcion) {
			case 1:
				int op = ex.controlaenteroSt("¿Que desea comprobar? \n"
						+ "1-Asignaturas \n"
						+ "2-Profesores \n"
						+ "3-Centros");
				
				if(op == 1) {
					a= new Asignaturas(ex.controlaStringSt("Codigo:"),null,null);
					a.ExisteAsignatura(a);
				}else if(op ==2) {
					p= new Profesores(ex.controlaenteroSt("Codigo:"),null,null,null,null,null);
					p.ExisteProfesores(p);
				}else if(op ==3) {
					c = new Centros(ex.controlaenteroSt("Codigo:"),null,null,null,null,null);
					c.ExisteCentros(c);
				}
				break;
			case 2:
				op = ex.controlaenteroSt("¿Que desea insertar? \n"
						+ "1-Asignaturas \n"
						+ "2-Profesores \n"
						+ "3-Centros");
				if(op == 1) {
					ArrayList<Profesores> temp = new ArrayList();
					String nom="";
					do {
						temp.add(p.obtenerProfesor(ex.controlaenteroSt("Codigo del profesor:")));
						nom=ex.controlaStringSt("Desea continuar insertando profesores en asignaturas? Y/N");
					}while(nom.equalsIgnoreCase("y"));
					a= new Asignaturas(ex.controlaStringSt("Codigo Asignatura:"),ex.controlaStringSt("Nombre Asignatura:"),temp);
					a.insertarAsignatura(a);
				}else if(op ==2) {
					p= new Profesores(ex.controlaenteroSt("Codigo:"),ex.controlaStringSt("Nombre:"),ex.controlaStringSt("Especialidad:"),ex.controlaStringSt("Fecha nacimiento:"),ex.controlaStringSt("Sexo:"),c.obtenerCentros(ex.controlaenteroSt("Id del centro:")));
					p.insertarProfesores(p);
				}else if(op ==3) {
					c = new Centros(ex.controlaenteroSt("Codigo:"),ex.controlaStringSt("Nombre:"),p.obtenerProfesor(ex.controlaenteroSt("Introduzca el codigo del director:")),ex.controlaStringSt("Direccion:"),ex.controlaStringSt("Localidad:"),ex.controlaStringSt("Provincia:"));
					c.insertarCentros(c);
				}
				break;
			case 3:
				op = ex.controlaenteroSt("¿Que desea borrar? \n"
						+ "1-Asignaturas \n"
						+ "2-Profesores \n"
						+ "3-Centros");
				if(op == 1) {
					a= new Asignaturas(ex.controlaStringSt("Codigo Asignatura:"),null,null);
					a.borrarAsignatura(a);
				}else if(op ==2) {
					p= new Profesores(ex.controlaenteroSt("Codigo:"),null,null,null,null,null);
					p.borrarProfesores(p);
				}else if(op ==3) {
					c = new Centros(ex.controlaenteroSt("Codigo:"),null,null,null,null,null);
					c.borrarCentros(c);
				}
				break;
			case 4:
				op = ex.controlaenteroSt("¿Que desea Modificar? \n"
						+ "1-Asignaturas \n"
						+ "2-Profesores \n"
						+ "3-Centros");
				if(op == 1) {
					a= new Asignaturas(ex.controlaStringSt("Codigo Asignatura:"),null,null);
					ArrayList<Profesores> temp = new ArrayList();
					String nom="";
					do {
						temp.add(new Profesores(ex.controlaenteroSt("Codigo profesor:"),ex.controlaStringSt("Nombre:"),ex.controlaStringSt("Especialidad:"),ex.controlaStringSt("Fecha nacimiento:"),ex.controlaStringSt("Sexo:")
								,c.obtenerCentros(ex.controlaenteroSt("Id del centro:"))));
						nom=ex.controlaStringSt("Desea continuar insertando profesores en asignaturas? Y/N");
					}while(nom.equalsIgnoreCase("y"));
					a.modificarAsignatura(a,a.getCodAsig(),ex.controlaStringSt("Nuevo nombre de asignatura:"),temp);
				}else if(op ==2) {
					p= new Profesores(ex.controlaenteroSt("Codigo:"),null,null,null,null,null);
					p.modificarProfesores(p,ex.controlaStringSt("Nueva fecha de nacimiento:"),ex.controlaStringSt("Nuevo nombre:"),ex.controlaStringSt("Nueva especialidad:"),ex.controlaStringSt("Nuevo sexo:"),c.obtenerCentros(ex.controlaenteroSt("Codigo de centro:")));
				}else if(op ==3) {
					c = new Centros(ex.controlaenteroSt("Codigo:"),null,null,null,null,null);
					c.modificarCentros(c,ex.controlaStringSt("nueva direccion:"),ex.controlaStringSt("Nueva localidad:"),ex.controlaStringSt("Nuevo nombre"),ex.controlaStringSt("Nueva provincia:"));
				}
				break;
			case 5:
				c.VerProfesoresCentros(ex.controlaenteroSt("Codigo de centro:"));
				;
				break;
			case 6:
				p.consultarAsignaturas(p.obtenerProfesor(ex.controlaenteroSt("Codigo del profesor:")));
				break;
			}
		}while(opcion!=7);
		


}
}