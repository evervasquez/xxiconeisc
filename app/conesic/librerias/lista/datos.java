package lista;

public class datos {

	private String datos;
	private String subdatos;
	private int imagenes;
	public datos() {
	}

	public datos(String a, String b, int c) {
		setdatos(a);
		setsubdatos(b);
		setimagenes(c);
	}

	public String getdatos() {
		return datos;
	}

	public void setdatos(String a) {
		this.datos = a;
	}

	public String getsubdatos() {
		return subdatos;
	}

	public void setsubdatos(String b) {
		this.subdatos = b;
	}
	
	public int getimagenes(){
		return imagenes;
	}
	
	public void setimagenes(int c){
		this.imagenes = c;
	}
}