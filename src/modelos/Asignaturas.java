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
	public void ExisteAsignatura(Asignaturas a) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(a);
		if(res.isEmpty()) {
			System.out.println("No existe el elemento");
		}else {
			System.out.println("El elemento existe:"+res.next());
		}
		bd.close();
	}
	
	public void insertarAsignatura(Asignaturas a) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"colegio.db4o");
		bd.store(a);
		bd.close();
	}
	public void borrarAsignatura(Asignaturas a) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(a);
		Asignaturas as = (Asignaturas)res.next();
		bd.delete(as);
		bd.close();
	}
	
}
