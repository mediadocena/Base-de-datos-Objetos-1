package modelos;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Centros {
	private int codCentro;
	private String nomCentro;
	private Profesores director;
	private String direccion;
	private String localidad;
	private String provincia;
	public Centros(int codCentro, String nomCentro, Profesores director, String direccion, String localidad,
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
	
	@Override
	public String toString() {
		return "Centros [codCentro=" + codCentro + ", nomCentro=" + nomCentro + ", director=" + director
				+ ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia + "]";
	}
	public Integer getCodCentro() {
		return codCentro;
	}
	public void setCodCentro(Integer codCentro) {
		this.codCentro = codCentro;
	}
	public String getNomCentro() {
		return nomCentro;
	}
	public void setNomCentro(String nomCentro) {
		this.nomCentro = nomCentro;
	}
	public Profesores getDirector() {
		return director;
	}
	public void setDirector(Profesores director) {
		this.director = director;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public boolean ExisteCentros(Centros c) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(c);
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
	public void insertarCentros(Centros c) {
		if(!ExisteCentros(c)) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		
		bd.store(c);
		bd.close();
		}else {
			System.out.println("EL elemento ya existe:"+ c);
		}
	}
	public void borrarCentros(Centros c) {
		if(ExisteCentros(c)) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(c);
		Centros as = (Centros)res.next();
		bd.delete(as);
		bd.close();
		}else {
			System.out.println("El elemento no existe");
		}
	}
	public void modificarCentros(Centros c,String direccion,String loc,String nom,String prov) {
        ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
        ObjectSet res = bd.queryByExample(c);
        Centros a1=(Centros)res.next();
        a1.setDireccion(direccion);
        a1.setLocalidad(loc);
        a1.setNomCentro(nom);
        a1.setProvincia(prov);
        bd.store(a1);
        bd.close();
	}
	public void VerProfesoresCentros(int cod) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		Centros c = new Centros(cod,null,null,null,null,null);
		ObjectSet res = bd.queryByExample(c);
		
		c = (Centros) res.next();
		Profesores p = new Profesores(0,null,null,null,null,c);
		ObjectSet res1 = bd.queryByExample(p);
		while(res1.hasNext()) {
			System.out.println(res1.next());
		}
		bd.close();
	}
	public Centros obtenerCentros(int id) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		Centros c = new Centros(id,null,null,null,null,null);
		 ObjectSet res = bd.queryByExample(c);
		if(!res.isEmpty()) {
		Centros c1 = (Centros)res.next();
			bd.close();
			return c1;
		}else {
			System.out.println("Centro no encontrado");
			bd.close();
			return null;	
		}
	}
	
}
