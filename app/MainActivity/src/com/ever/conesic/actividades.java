package com.ever.conesic;

import informacion.concursos_model;
import informacion.deportivo;
import informacion.gastronomica;
import informacion.megatours;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragment;

public class actividades extends SherlockFragment {
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
		tableView.addBasicItem("Campeonato Deportivo", "");
		tableView.addBasicItem("Feria Gastronomica", "");
		tableView.addBasicItem("MegaTours", "");
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
			switch (index) {
			case 0:
		        i = new Intent(getSherlockActivity(), deportivo.class);
		        startActivity(i);
				break;
			case 1:
				i = new Intent(getSherlockActivity(), gastronomica.class);
		        startActivity(i);
				break;
			case 2:
				i = new Intent(getSherlockActivity(), megatours.class);
		        startActivity(i);
				break;
			default:
				break;
			}
		}

	}
	
}
