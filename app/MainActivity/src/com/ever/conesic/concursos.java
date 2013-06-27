package com.ever.conesic;

import utiles.fonts;
import informacion.concursos_model;
import informacion.info_concursos;
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

public class concursos extends SherlockFragment {
	UITableView tableView;
	concursos_model datos;
	int[] objeto;
	Intent i;
	String[] data;
	TextView titulo;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tableView = (UITableView) getView().findViewById(R.id.tableView);
		titulo =(TextView) getView().findViewById(R.id.titulo);
		titulo.setText("Lista de Concursos");
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
		View view = inflater.inflate(R.layout.concursos, container, false);
		return view;
	}
	private void createList() {
		/////
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);
	
		tableView.addBasicItem(R.drawable.papers, "", "");
		tableView.addBasicItem(R.drawable.programacion, "", "");
		tableView.addBasicItem(R.drawable.proyectos,"Concurso de Proyectos", "");

	}
	
	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			i = new Intent(getSherlockActivity(), info_concursos.class);
			switch (index) {
			case 0:
				data = new String[] { "Concurso de Papers", "http://es.wikipedia.org/wiki/Art%C3%ADculo_cient%C3%ADfico",
						"http://coneisc.pe/assets/docs/bases%20call%20for%20papers.pdf", "08-08-2013",
						"http://coneisc.pe/web/papers" };

				// imagenes = icono, img_lista,img_compartir
				objeto = new int[] { R.drawable.papers, R.drawable.paperstitle,
						R.drawable.papers };
				//coordenadas = new double[]{-6.513434965802698,-76.37042999267578};
				datos = new concursos_model();
				datos.setData(data);
				datos.setObjeto(objeto);
				//datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
			case 1:
				data = new String[] { "Concurso de Programación", "http://coneisc.pe/web/concurso_programacion",
						"http://tarapotoventas.tk/descargas/concursos/bases_concursos_de_programacion.pdf", "08-08-2013",
						"http://coneisc.pe/web/concurso_programacion" };
				
				objeto = new int[] { R.drawable.programacion, R.drawable.programaciontitle,
						R.drawable.programacion };
				
				datos = new concursos_model();
				datos.setData(data);
				datos.setObjeto(objeto);
				//datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
			case 2:
				//data para armar la vista
				data = new String[] { "Proyecto de Investigación", "http://coneisc.pe/web/concurso_proyectos_investigacion",
						"http://tarapotoventas.tk/descargas/concursos/bases_concursos_de_proyectos.pdf", "08-08-2013",
						"http://coneisc.pe/web/concurso_proyectos_investigacion" };
				
				objeto = new int[] { R.drawable.proyectos, R.drawable.proyectostitle,
						R.drawable.proyectos };
				
				datos = new concursos_model();
				datos.setData(data);
				datos.setObjeto(objeto);
				//datos.setCoordenadas(coordenadas);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
			default:
				break;
			}
		}

	}
	
}
