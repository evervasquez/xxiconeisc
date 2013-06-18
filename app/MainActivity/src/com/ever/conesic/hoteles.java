package com.ever.conesic;

import informacion.hoteles_model;
import informacion.info_hospedajes;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragment;

public class hoteles extends SherlockFragment {
	UITableView tableView;
	hoteles_model datos;
	int[] objeto;
	Intent i;
	String[] data, estadias, precios;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tableView = (UITableView) getView().findViewById(R.id.tableView);
		createList();
		tableView.commit();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v("ListFragment", "onCreateView()");
		Log.v("ListContainer", container == null ? "true" : "false");
		Log.v("ListsavedInstanceState", savedInstanceState == null ? "true"
				: "false");
		if (container == null) {
			return null;
		}
		View view = inflater.inflate(R.layout.concursos, container, false);
		return view;
	}

	private void createList() {
		// ///
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);

		tableView.addBasicItem("Hospedajes", "");
		tableView.addBasicItem("Hostales", "");
		tableView.addBasicItem("Alojamientos", "");
		tableView.addBasicItem("Hoteles", "");
		tableView.addBasicItem("Hosterias", "");
	}

	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			i = new Intent(getActivity(),info_hospedajes.class);
			Log.d("MainActivity", "item clicked: " + index);
			switch (index) {
			case 0:
				estadias = new String[] { "Las Palmeras", "La Patarashca",
						"El Paso Texas", "Miguelito", "Trujillano",
						"Gran Chimu", "Costa Verde", "Viluz", "Misti",
						"El Encanto", "El Peregrino", "El Milenio",
						"Vista Verde", "Gold Tarapoto Hospedaje",
						"Heliconias Gran Hospedaje", "La Novia",
						"Sol de Piura", "Turismo Sol y Luna" };

				precios = new String[] { "Habitación simple S/.20",
						"Habitación simple S/.65", "Habitación simple S/.25",
						"Habitación simple S/.25", "Habitación simple S/.25",
						" Habitación simpleS/.25", "Habitación simple S/.20",
						"Habitación simple S/.25", "Habitación simple S/.30",
						"Habitación simple S/.25", "Habitación simple S/.15",
						"Habitación simple S/.50", "Habitación doble S/.40",
						"Habitación doble S/.100", "Habitación simple S/.35",
						"Habitación simple S/.45", "Habitación simple S/.25",
						"Habitación simple S/.25" };

				objeto = new int[] { R.string.hospedajes, R.drawable.paperstitle,
						R.drawable.papers };
				datos = new hoteles_model(18,18,3);
				datos.setEstadias(estadias);
				datos.setPrecios(precios);
				datos.setObjeto(objeto);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
				
			case 1:
				estadias = new String[] { "Hostal Casa Blanca", "Hostal Sol de Selva",
						"Hostal Marbella", "Hostal Victor Manuel", "Hostal Santa Rosa",
						"Hostal La Posada Inn"};

				precios = new String[] { "Habitación Simple S/.40",
						"Habitación simple S/.50", "Habitación simple S/.40",
						"Habitación simple S/.35", "Habitación simple S/.40",
						" Habitación simpleS/.60"};
				objeto = new int[] { R.string.hostales, R.drawable.paperstitle,
						R.drawable.papers };
				datos = new hoteles_model(6,6,3);
				datos.setEstadias(estadias);
				datos.setPrecios(precios);
				datos.setObjeto(objeto);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
			case 2:
				estadias = new String[] { "Melendez", "El Mirador",
						"July", "San Luis", "Miami",
						"Grau", "Luis Fernando", "D & F", "Viajero Wassi",
						"Fernando", "Oriente", "La Posada del Mirador",
						"San Martín","Alojamiento y Restaurant Santa Mónica", "Copacabana",
						" Lima", "El Pueblo",
						"La Siesta", "Alí","La Inolvidable","Ahuashiyacu",
						"La Florida Inn","Mary House","Gran Pajaten","Morales Beach"};

				precios = new String[] { "Habitación simple S/.10",
						"Habitación simple S/.60", "Habitación simple S/.30",
						"Habitación simple S/.20", "Habitación simple S/.30",	
						"Habitación simple S/.30", "Habitación simple S/.40",				
						"Habitación simple S/.25", "Habitación simple S/.30",
						"Habitación simple S/.20", "Habitación simple S/.20",
						"Habitación simple S/.25", "Habitación doble S/.25",
						"Habitación soble S/.15", "Habitación simple S/.35",
						"Habitación simple S/.20", "Habitación simple S/.20",	
						"Habitación simple S/.30", "Habitación simple S/.30",
						"Habitación simple S/.30", "Habitación Doble S/.50",
						"Habitación simple S/.40","Habitación simple S/.25",
						"Habitación simple S/.50", "Habitación Doble S/.25"};

				objeto = new int[] { R.string.alojamientos, R.drawable.paperstitle,
						R.drawable.papers };
				datos = new hoteles_model(25,25,3);
				datos.setEstadias(estadias);
				datos.setPrecios(precios);
				datos.setObjeto(objeto);
				i.putExtra("datos", datos);
				startActivity(i);

				break;
				
			case 3:
				estadias = new String[] { "Riosol Tarapoto Hotel", 
						"Cerro Verde Tarapoto Hotel","Luna Azul", 
						"Cielo", "Rio Cumbaza",
						"Cumbaza", "Tarapoto Inn", 
						"Nilas", "Pacifico Tarapoto Hotel",
						"Tarapoto Hotel and Suites", "Boca Raton", 
						"San Antonio","Monte Azul", 
						"Firenze"
						};

				precios = new String[] { "Habitación simple S/.105",
						"Habitación simple S/.70", "Habitación simple S/.75",
						"Habitación simple S/.55", "Habitación simple S/.90",
						"Habitación simple S/.80", "Habitación simple S/.50",
						"Habitación simple S/.80", "Habitación doble S/.30",
						"Habitación simple S/.60", "Habitación simple S/.80",
						"Habitación simple S/.35", "Habitación doble S/.50",
						"Habitación soble S/.50"
						};

				objeto = new int[] { R.string.hoteles, R.drawable.paperstitle,
						R.drawable.papers };
				datos = new hoteles_model(14,14,3);
				datos.setEstadias(estadias);
				datos.setPrecios(precios);
				datos.setObjeto(objeto);
				i.putExtra("datos", datos);
				startActivity(i);

				break;
			
			case 4:
				estadias = new String[] { "Residencial Amazonas"};
				precios = new String[] { "Habitación simple S/.35"};
				
				objeto = new int[] { R.string.hosterias, R.drawable.paperstitle,
						R.drawable.papers };
				datos = new hoteles_model(1,1,3);
				datos.setEstadias(estadias);
				datos.setPrecios(precios);
				datos.setObjeto(objeto);
				i.putExtra("datos", datos);
				startActivity(i);

				break;

			default:
				break;
			}
		}

	}

}
