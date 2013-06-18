package informacion;

import android.os.Parcel;
import android.os.Parcelable;

public class hoteles_model implements Parcelable {

	private String[] estadias;
	private String[] precios;
	private int[] objetos;
	public static int num_objetos,num_estadias, num_precios;
	//private double[] coordenadas;
	public hoteles_model(int num1,int num2, int num3) {
		num_estadias = num1;
		num_precios = num2;
		num_objetos = num3;
		this.estadias = new String[num1];
		this.precios = new String[num2];
		this.objetos = new int[num3];
		//coordenadas = new double[2];
	}

	public hoteles_model(Parcel in,int num1,int num2,int num3) {
		this.objetos = new int[num3];
		this.estadias = new String[num1];
		this.precios = new String[num2];
		//coordenadas = new double[2];
		readFromParcel(in);
	}

	public void setEstadias(String[] estadias) {
		this.estadias = estadias;
	}
	
	public void setPrecios(String[] precios) {
		this.precios = precios;
	}
	
	public void setObjeto(int[] objeto) {
		this.objetos = objeto;
	}

	public String[] getEstadias() {
		return this.estadias;
	}
	
	public String[] getPrecios() {
		return this.precios;
	}
	
	public int[] getObjeto() {
		return this.objetos;
	}
	
	public static final Parcelable.Creator<hoteles_model> CREATOR = new Parcelable.Creator<hoteles_model>() {
		public hoteles_model createFromParcel(Parcel in) {
			return new hoteles_model(in, hoteles_model.num_estadias,hoteles_model.num_precios,hoteles_model.num_objetos);
		}

		public hoteles_model[] newArray(int size) {
			return new hoteles_model[size];
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
		dest.writeStringArray(this.estadias);
		dest.writeStringArray(this.precios);
		dest.writeIntArray(this.objetos);
	}

	private void readFromParcel(Parcel in) {
		in.readStringArray(this.estadias);
		in.readStringArray(this.precios);
		in.readIntArray(this.objetos);
	}
}
