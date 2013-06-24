package informacion;

import android.database.Cursor;

public class universidades_model {
	private long id;
	private String universidad;
	private String region;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	  @SuppressWarnings("unused")
	private universidades_model cursorToComment(Cursor cursor) {
		    universidades_model uni = new universidades_model();
		    uni.setId(cursor.getLong(0));
		    return uni;
		  }
}
