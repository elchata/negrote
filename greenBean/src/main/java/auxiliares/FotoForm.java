package auxiliares;

import java.io.File; 

public class FotoForm  { 
	private File imagen;  
	private long idFoto; 

	public long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(long idFoto) {
		this.idFoto = idFoto;
	}

	public File getImagen() {
		return imagen;
	}

	public void setImagen(File imagen) {
		this.imagen = imagen;
	}
	
	public FotoForm(){
		
	}

}
