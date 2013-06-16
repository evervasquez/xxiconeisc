package utiles;

import java.util.Calendar;
import java.util.Date;

public class fechas {

	public Date retornaFecha(int anio,int mes, int dia){
		Calendar nextYear = Calendar.getInstance();
		nextYear.set(anio, mes, dia);
		Date fecha = nextYear.getTime();
		nextYear.clear();
		return fecha;
	}
}
