package modelos;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Centros {
	private Integer codCentro;
	private String nomCentro;
	private Profesores director;
	private String direccion;
	private String localidad;
	private String provincia;
	public Centros(Integer codCentro, String nomCentro, Profesores director, String direccion, String localidad,
			String provincia) {
		super();
		this.codCentro = codCentro;
		this.nomCentro = nomCentro;
		this.director = director;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	public Centros() {}
	
	public void ExisteCentros(Centros c) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(c);
		if(res.isEmpty()) {
			System.out.println("No existe el elemento");
		}else {
			System.out.println("El elemento existe:"+res.next());
		}
		bd.close();
	}
	public void insertarCentros(Centros c) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		bd.store(c);
		bd.close();
	}
	public void borrarCentros(Centros c) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(c);
		Centros as = (Centros)res.next();
		bd.delete(as);
		bd.close();
	}
	
}
