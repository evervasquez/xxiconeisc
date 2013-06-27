package com.ever.conesic;

import utiles.fonts;
import informacion.deportivo;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragment;

public class actividades extends SherlockFragment {
	UITableView tableView;
	Intent i;
	TextView titulo;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tableView = (UITableView) getView().findViewById(R.id.tableView);
		titulo =(TextView) getView().findViewById(R.id.titulo);
		titulo.setText("Lista de Actividades");
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
		////
		//tableView.setOnClickListener(this);
		tableView.addBasicItem("Campeonato Deportivo", "");
		tableView.addBasicItem("Feria Tecnologica", "");
		tableView.addBasicItem("Feria Gastronomica", "");
		tableView.addBasicItem("MegaTours", "");
	}
	
	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			switch (index) {
			case 0:
		        i = new Intent(getSherlockActivity(), deportivo.class);
		        startActivity(i);
				break;
			case 1:
				//i = new Intent(getSherlockActivity(), gastronomica.class);
		        //startActivity(i);
				Toast.makeText(getSherlockActivity(), "Muy Pronto Colocaremos la Información", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				//i = new Intent(getSherlockActivity(), megatours.class);
		        //startActivity(i);
				Toast.makeText(getSherlockActivity(), "Muy Pronto Colocaremos la Información", Toast.LENGTH_SHORT).show();
				break;
			case 3:
				//i = new Intent(getSherlockActivity(), megatours.class);
		        //startActivity(i);
				Toast.makeText(getSherlockActivity(), "Muy Pronto Colocaremos la Información", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}

	}
	
}
