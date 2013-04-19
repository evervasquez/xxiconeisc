package informacion;

import android.os.Parcel;
import android.os.Parcelable;

public class modelo implements Parcelable {

	private String[] data;
	private int[] objetos;

	public modelo() {
		objetos = new int[3];
		data = new String[8];
	}

	public modelo(Parcel in) {
		objetos = new int[3];
		data = new String[8];
		readFromParcel(in);
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public void setObjeto(int[] objeto) {
		this.objetos = objeto;
	}

	public String[] getData() {
		return this.data;
	}

	public int[] getObjeto() {
		return this.objetos;
	}

	public static final Parcelable.Creator<modelo> CREATOR = new Parcelable.Creator<modelo>() {
		public modelo createFromParcel(Parcel in) {
			return new modelo(in);
		}

		public modelo[] newArray(int size) {
			return new modelo[size];
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
	}

	private void readFromParcel(Parcel in) {
		in.readStringArray(data);
		in.readIntArray(objetos);
	}

}
