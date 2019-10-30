package main;
import Utiles.Salieri;
import modelos.Asignaturas;
import modelos.Centros;
import modelos.Profesores;

public class Main {

	public static void main(String[] args) {
		Asignaturas a ;
		Profesores p;
		Centros c;
		int opcion =0;
		Salieri ex = new Salieri();
		do {
			opcion= ex.controlaenteroSt("1-Comprobar objeto existente \n"
					+ "2-Insertar. \n"
					+ "3-Borrar. \n");
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
					
				}else if(op ==3) {
					c = new Centros(ex.controlaenteroSt("Codigo:"),null,null,null,null,null);
				}
				break;
			case 2:
				op = ex.controlaenteroSt("¿Que desea insertar? \n"
						+ "1-Asignaturas \n"
						+ "2-Profesores \n"
						+ "3-Centros");
				if(op == 1) {
					a= new Asignaturas(ex.controlaStringSt("Codigo Asignatura:"),ex.controlaStringSt("Nombre Asignatura:"),null);
					a.insertarAsignatura(a);
				}else if(op ==2) {
					p= new Profesores(ex.controlaenteroSt("Codigo:"),ex.controlaStringSt("Nombre:"),ex.controlaStringSt("Especialidad:"),ex.controlaStringSt("Fecha nacimiento:"),ex.controlaStringSt("Sexo:"),null);
					p.insertarProfesores(p);
				}else if(op ==3) {
					c = new Centros(ex.controlaenteroSt("Codigo:"),ex.controlaStringSt("Nombre:"),null,ex.controlaStringSt("Direccion:"),ex.controlaStringSt("Localidad:"),ex.controlaStringSt("Provincia:"));
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
			}
		}while(opcion!=8);
		


}
}