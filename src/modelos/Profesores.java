package modelos;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Profesores {
	private Integer codProf;
	private String nombreApe;
	private String nombreEspe;
	private String fechaNac;
	private String sexo;
	private Centros Centros;
	public Profesores(Integer codProf, String nombreApe, String nombreEspe, String fechaNac, String sexo,
			modelos.Centros centros) {
		super();
		this.codProf = codProf;
		this.nombreApe = nombreApe;
		this.nombreEspe = nombreEspe;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		Centros = centros;
	}
	
	public Profesores(){}
	
	public void ExisteProfesores(Profesores p) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(p);
		if(res.isEmpty()) {
			System.out.println("No existe el elemento");
		}else {
			System.out.println("El elemento existe:"+res.next());
		}
		bd.close();
	}
	public void insertarProfesores(Profesores p) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		bd.store(p);
		bd.close();
	}
	public void borrarProfesores(Profesores p) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(p);
		Profesores as = (Profesores)res.next();
		bd.delete(as);
		bd.close();
	}
}
