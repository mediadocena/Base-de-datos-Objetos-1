package modelos;

import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Asignaturas {
	private String codAsig;
	private String nombreAsi;
	private ArrayList<Profesores> setprofesores;
	public Asignaturas(String codAsig, String nombreAsi, ArrayList<Profesores> setprofesores) {
		super();
		this.codAsig = codAsig;
		this.nombreAsi = nombreAsi;
		this.setprofesores = setprofesores;
	}
	public Asignaturas() {}
	
	
	@Override
	public String toString() {
		return "Asignaturas [codAsig=" + codAsig + ", nombreAsi=" + nombreAsi + ", setprofesores=" + setprofesores+ "]";
	}
	public boolean ExisteAsignatura(Asignaturas a) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(a);
		boolean f = true;
		if(res.isEmpty()) {
			System.out.println("No existe el elemento");
			f=false;
		}else {
			System.out.println("El elemento existe:"+res.next());
			f=true;
		}
		bd.close();
		return f;
	}
	
	public void insertarAsignatura(Asignaturas a) {
		if(!ExisteAsignatura(a)) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		bd.store(a);
		bd.close();
		}else {
			System.out.println("EL elemento ya existe:"+ a);
		}
	}
	public void borrarAsignatura(Asignaturas a) {
		if(ExisteAsignatura(a)) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(a);
		Asignaturas as = (Asignaturas)res.next();
		
		bd.delete(as);
		bd.close();
		}else {
			System.out.println("El elemento no existe");
		}
		
	}
	public void modificarAsignatura(Asignaturas a,String cod,String nombre,ArrayList p) {
        ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
        ObjectSet res = bd.queryByExample(a);
        Asignaturas a1=(Asignaturas)res.next();
        a1.setCodAsig(cod);
        a1.setNombreAsi(nombre);
        a1.setSetprofesores(p);
        bd.store(a1);
        bd.close();
		
	}
	public String getCodAsig() {
		return codAsig;
	}
	public void setCodAsig(String codAsig) {
		this.codAsig = codAsig;
	}
	public String getNombreAsi() {
		return nombreAsi;
	}
	public void setNombreAsi(String nombreAsi) {
		this.nombreAsi = nombreAsi;
	}
	public ArrayList<Profesores> getSetprofesores() {
		return setprofesores;
	}
	public void setSetprofesores(ArrayList<Profesores> setprofesores) {
		this.setprofesores = setprofesores;
	}

	
}
