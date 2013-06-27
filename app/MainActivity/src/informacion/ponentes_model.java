package informacion;

import android.os.Parcel;
import android.os.Parcelable;

public class ponentes_model implements Parcelable {

	private String[] data;
	private int[] objetos;
	//private double[] coordenadas;
	public ponentes_model() {
		objetos = new int[2];
		data = new String[8];
		//coordenadas = new double[2];
	}

	public ponentes_model(Parcel in) {
		objetos = new int[2];
		data = new String[8];
		//coordenadas = new double[2];
		readFromParcel(in);
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public void setObjeto(int[] objeto) {
		this.objetos = objeto;
	}
/*	public void setCoordenadas(double[] coordenadas){
		this.coordenadas = coordenadas;
	}*/
	public String[] getData() {
		return this.data;
	}

	public int[] getObjeto() {
		return this.objetos;
	}
	/*public double[] getCoordenadas(){
		return this.coordenadas;
	}*/
	public static final Parcelable.Creator<ponentes_model> CREATOR = new Parcelable.Creator<ponentes_model>() {
		public ponentes_model createFromParcel(Parcel in) {
			return new ponentes_model(in);
		}

		public ponentes_model[] newArray(int size) {
			return new ponentes_model[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int arg1) {
		// TODO Auto-generated method stub
		dest.writeStringArray(data);
		dest.writeIntArray(objetos);
		//dest.writeDoubleArray(coordenadas);
	}

	private void readFromParcel(Parcel in) {
		in.readStringArray(data);
		in.readIntArray(objetos);
		//in.readDoubleArray(coordenadas);
	}

}
