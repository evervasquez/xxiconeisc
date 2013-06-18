package com.ever.conesic;

import informacion.concursos_model;
import informacion.info_concursos;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragment;

public class concursos extends SherlockFragment {
	UITableView tableView;
	concursos_model datos;
	int[] objeto;
	Intent i;
	String[] data;
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
		/////
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);
		////
		//tableView.setOnClickListener(this);
		tableView.addBasicItem(R.drawable.papers, "", "");
		tableView.addBasicItem(R.drawable.programacion, "", "");
		tableView.addBasicItem(R.drawable.proyectos,"Concurso de Proyectos", "");
		/*
		 * tableView.addBasicItem(R.drawable.piedra,"Example 4 - UITableView",
		 * "only one item");
		 * tableView.addBasicItem("Example 5 - UITableViewActivity",
		 * "a sample activity");
		 * tableView.addBasicItem("Example 6 - UITableViewActivity temp",
		 * "item with custom view");
		 * tableView.addBasicItem("Example 7 - UIButton",
		 * "some floating buttons");
		 * tableView.addBasicItem("Example 8 - Clear List",
		 * "this button will clear the list");
		 */

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
						"http://www.scribd.com/document_downloads/140723306?extension=pdf&from=embed&source=embed", "08-08-2013",
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
						"http://www.scribd.com/document_downloads/140721071?extension=pdf&from=embed&source=embed", "08-08-2013",
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
