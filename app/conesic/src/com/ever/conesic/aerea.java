package com.ever.conesic;

import informacion.informacion;
import informacion.modelo;

import com.actionbarsherlock.app.SherlockFragment;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class aerea extends SherlockFragment {

	UITableView tableView;
	private modelo datos;
	private Intent i;
	private String[] data;
	private int[] objeto;

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
		View view = inflater.inflate(R.layout.aerea, container, false);
		return view;
	}

	private void createList() {
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);
		tableView.addBasicItem(R.drawable.taca, "", "");
		tableView.addBasicItem(R.drawable.lan, "", "");
		tableView.addBasicItem(R.drawable.starperu, "", "");
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
			i = new Intent(getSherlockActivity(), informacion.class);
			switch (index) {
			case 0:
				data = new String[] { "Taca Peru", "Aerolinea del Peru",
						"9428954114 - #245215", "http://www.taca.com/",
						"https://www.facebook.com/tacaairlines", "@tacaperu",
						"Taca Peru", "support@taca.com.pe" };

				// imagenes = icono, img_lista,img_compartir
				objeto = new int[] { R.drawable.taca, R.drawable.tacatitle,
						R.drawable.taca };
				datos = new modelo();
				datos.setData(data);
				datos.setObjeto(objeto);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
			case 1:
				data = new String[] { "Lan Peru", "Aerolinea del Peru",
						"9428954114 - #245215", "http://www.lan.com/",
						"https://www.facebook.com/lanairlines", "@lanperu",
						"Lan Peru", "support@lan.com.pe" };

				// imagenes = icono, img_lista,img_compartir
				objeto = new int[] { R.drawable.lan, R.drawable.lantitle,
						R.drawable.lan };
				datos = new modelo();
				datos.setData(data);
				datos.setObjeto(objeto);
				i.putExtra("datos", datos);
				startActivity(i);
				break;
			case 2:
				data = new String[] { "StarPeru", "Aerolinea del Peru",
						"9428954114 - #245215", "http://www.starperu.com/",
						"https://www.facebook.com/aerolineas.starperu", "@starperu_",
						"Starperu", "support@starperu.com.pe" };

				// imagenes = icono, img_lista,img_compartir
				objeto = new int[] { R.drawable.starperu, R.drawable.starperutitle,
						R.drawable.starperu };
				datos = new modelo();
				datos.setData(data);
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