package modelos;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Profesores {
	private int codProf;
	private String nombreApe;
	private String nombreEspe;
	private String fechaNac;
	private String sexo;
	private Centros Centros;
	public Profesores(int codProf, String nombreApe, String nombreEspe, String fechaNac, String sexo,
			modelos.Centros centros) {
		super();
		this.codProf = codProf;
		this.nombreApe = nombreApe;
		this.nombreEspe = nombreEspe;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		Centros = centros;
	}
	
	@Override
	public String toString() {
		return "Profesores [codProf=" + codProf + ", nombreApe=" + nombreApe + ", nombreEspe=" + nombreEspe
				+ ", fechaNac=" + fechaNac + ", sexo=" + sexo + ", Centros=" + Centros + "]";
	}

	public Integer getCodProf() {
		return codProf;
	}

	public void setCodProf(Integer codProf) {
		this.codProf = codProf;
	}

	public String getNombreApe() {
		return nombreApe;
	}

	public void setNombreApe(String nombreApe) {
		this.nombreApe = nombreApe;
	}

	public String getNombreEspe() {
		return nombreEspe;
	}

	public void setNombreEspe(String nombreEspe) {
		this.nombreEspe = nombreEspe;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Centros getCentros() {
		return Centros;
	}

	public void setCentros(Centros centros) {
		Centros = centros;
	}

	public Profesores(){}
	
	public boolean ExisteProfesores(Profesores p) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(p);
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
	public void insertarProfesores(Profesores p) {
		
		if(!ExisteProfesores(p)) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		bd.store(p);
		bd.close();
		}else {
			System.out.println("EL elemento ya existe:"+ p);
		}
		
	}
	public void borrarProfesores(Profesores p) {
		if(ExisteProfesores(p)) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		ObjectSet res = bd.queryByExample(p);
		Profesores as = (Profesores)res.next();
		bd.delete(as);
		bd.close();
		}else {
			System.out.println("El elemento no existe");
		}
		
	}

	public void modificarProfesores(Profesores p,String fechaNac,String nombre,String esp,String se,Centros cent) {
        ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
        try {
            ObjectSet res = bd.queryByExample(new Profesores(p.getCodProf(),null,null, null, null, null));
            Profesores a=(Profesores)res.next();
            a.setNombreApe(nombre);
            a.setNombreEspe(esp);
            a.setFechaNac(fechaNac);
            a.setSexo(sexo);
            a.setCentros(cent);
            bd.store(a);
            System.out.println("Profesor modificado");
        }catch(IllegalStateException ex) {

        }
            bd.close();
        }
	public void consultarAsignaturas(Profesores p) {
        Asignaturas a = new Asignaturas(null,null,null);
        Profesores pa;
        ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
        ObjectSet res = bd.queryByExample(p);
        while(res.hasNext()) {
            pa=(Profesores)res.next();
            ObjectSet resa= bd.queryByExample(a);
            while(resa.hasNext()) {
                Asignaturas a1 = (Asignaturas)resa.next();
                    if(a1.getSetprofesores().contains(pa)) {
                        System.out.println(a1.getNombreAsi());
                    }
            }
        }
        bd.close();
    }
	public Profesores obtenerProfesor(int id) {
		ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Colegio.db4o");
		Profesores c = new Profesores(id,null,null,null,null,null);
		ObjectSet res = bd.queryByExample(c);
		if(!res.isEmpty()) {
		Profesores c1 = (Profesores)res.next();
		bd.close();
			return c1;
		}else {
			System.out.println("No se ha encontrado el profesor");
			return null;
		}
	
	}
}
