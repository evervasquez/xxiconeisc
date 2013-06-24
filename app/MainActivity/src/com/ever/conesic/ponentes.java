package com.ever.conesic;

import utiles.fonts;
import informacion.info_ponentes;
import informacion.ponentes_model;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragment;

public class ponentes extends SherlockFragment {
	UITableView tableView;
	ponentes_model datos;
	int[] objeto;
	Intent i;
	String[] data;
	TextView titulo;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tableView = (UITableView) getView().findViewById(R.id.tableView);
		titulo =(TextView) getView().findViewById(R.id.titulo);
		titulo.setText("Lista de Ponentes");
		fonts.cambiarfont_actionbar(getSherlockActivity(), "fonts/ArtistMedium.ttf");
		fonts.cambiarfont(getSherlockActivity(), R.id.titulo, "fonts/ArtistMedium.ttf");
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
		View view = inflater.inflate(R.layout.ponentes, container, false);
		return view;
	}

	private void createList() {
		// ///
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);
		// //
		// tableView.setOnClickListener(this);
		tableView.addBasicItem(R.drawable.arturo_canez, "Arturo Cánez",
				"Director de Lima Valley");
		tableView.addBasicItem(R.drawable.manuel_bermudez,
				"P.h.D. Manuel Bermúdez",
				"Coor. de Relaciones con América Latina");
		tableView.addBasicItem(R.drawable.kemper_valverde,
				"DR. Nicolás Kemper Valverde", "Prof. Inteligencia Artificial");
		tableView.addBasicItem(R.drawable.roman_gonzales,
				"Mg. Avid Roman Gonzales ",
				"Mg. Automatización Industrial y Humana");
		tableView.addBasicItem(R.drawable.suarez_reymundo,
				"Ing.J.P. Suarez Reymundo", "Influencer de Microsoft Perú");
		tableView.addBasicItem(R.drawable.sanchez_rosas,
				"Ing. Juan Sánchez Rosas",
				"Soluciones de Código libre y abierto");
		tableView.addBasicItem(R.drawable.pedro_gonzales,
				"Ing. Msc. Pedro A. Gonzales Sanchez",
				"Mestrado em Ciências da Comunicação");
		tableView.addBasicItem(R.drawable.rodriguez_rivero,
				"Ing. Cristian Rodriguez Rivero",
				"Computational Intelligence Society (CIS)");
	}

	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			i = new Intent(getSherlockActivity(), info_ponentes.class);
			switch (index) {
			case 0:
				data = new String[] {
						"Arturo Cánez",
						"Director de Lima Valley",
						"Descargar",
						"https://www.facebook.com/arturocanez", 
						"https://twitter.com/arturocanez",
						"falta email",
						"http://pe.linkedin.com/in/arturocanez"};

				// imagenes = icono, img_lista,img_compartir
				objeto = new int[] { R.drawable.arturo_canez};
				// coordenadas = new
				// double[]{-6.513434965802698,-76.37042999267578};
				datos = new ponentes_model();
				datos.setData(data);
				datos.setObjeto(objeto);
				// datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
			case 1:
				
				data = new String[] { 
						"Dr. Manuel E. Bermudez",
						"University of Florida - USA",
						"Descargar",
						"no aye",
						"no aye",
						"manuel@cise.ufl.edu",
						"no aye"
				};
				
				objeto = new int[] { R.drawable.manuel_bermudez};

				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); 
				startActivity(i);
				break;
			case 2:
				// data para armar la vista
				
				data = new String[] { 
				"DR. Nicolás Kemper Valverde",
				"Doctor Inteligencia Artificial",
				"http://www.josoull.com/Asesoria/Projects/201015/CV1.pdf", 
				"no aye",
				"no aye",
				"no aye",
				"no aye"};
				
				objeto = new int[] { R.drawable.kemper_valverde};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
			case 3:
				// data para armar la vista
				
				data = new String[] { 
				"Mg. Avid Roman Gonzalez",
				"Mg. Automatización Industrial Humana",
				"https://7otzja.bay.livefilestore.com/y2ppjRHNRd9BGnyixi0pnv72jXCH4Z6bVzpPcerdKgYmyrRmyEGvQmfYwyUhaGAtxT063GGAs8VjcXQgcPQaVfNxCNP3pa75zboixyJxsvcUl4/CV_Avid_Roman_Gonzalez.pdf?download&psid=1", 
				"https://www.facebook.com/avid.romangonzalez",
				"https://twitter.com/Avid_RG",
				"avid.roman-gonzales@ieee.org",
				"http://pe.linkedin.com/pub/avid-roman-gonzalez/2a/a74/9"};
				
				objeto = new int[] { R.drawable.roman_gonzales};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
			
			case 4:
				// data para armar la vista
				
				data = new String[] { 
				"Msc.Ing. J.P. Suarez Reymundo",
				"Mg. Ingenieria con Mención en Gestión de TI",
				"Descargar", 
				"https://www.facebook.com/johnsuarezr",
				"https://twitter.com/johnsuarezr",
				"johnsuarezr@hotmail.com",
				"no aye"};
				
				objeto = new int[] { R.drawable.suarez_reymundo};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
				
			case 5:
				// data para armar la vista
				
				data = new String[] { 
				"Ing. Juan Sánchez Rosas",
				"Soluciones de Código libre y abierto",
				"Descargar", 
				"https://www.facebook.com/juaneladio",
				"https://twitter.com/juaneladio",
				"jesanchez@mozilla.pe",
				"http://pe.linkedin.com/in/juaneladio"};
				
				objeto = new int[] { R.drawable.suarez_reymundo};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
				
			case 6:
				// data para armar la vista
				
				data = new String[] { 
				"Ing. Msc. Pedro A. Gonzales Sanchez",
				"Mestrado em Ciências da Comunicação",
				"Descargar", 
				"https://www.facebook.com/pedroantonio.gonzales.9",
				"no aye",
				"no aye",
				"no aye"};
				
				objeto = new int[] { R.drawable.pedro_gonzales};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
			
			case 7:
				// data para armar la vista
				
				data = new String[] { 
				"Ing. Cristian Rodriguez Rivero",
				"Computational Intelligence Society (CIS)",
				"http://cristianrodriguezrivero.blogspot.com/", 
				"https://www.facebook.com/pedroantonio.gonzales.9",
				"no aye",
				"crodriguezrivero@ieee.org",
				"http://ar.linkedin.com/pub/cristian-rodriguez-rivero/18/b6a/74"};
				
				objeto = new int[] { R.drawable.pedro_gonzales};
				
				datos = new ponentes_model(); 
				datos.setData(data);
				datos.setObjeto(objeto); //datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos); startActivity(i);
				
				break;
			default:
				break;
			}
		}

	}

}
