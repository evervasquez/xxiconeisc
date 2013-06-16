package com.ever.conesic;

import informacion.informacion;
import utiles.fonts;

import com.actionbarsherlock.app.SherlockFragment;

import br.com.dina.ui.model.BasicItem;
import br.com.dina.ui.widget.UIButton;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class inversion extends SherlockFragment {

	UITableView tableView;
	UIButton mButton1;

	@SuppressLint("InlinedApi")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
		mButton1 = (UIButton) getSherlockActivity().findViewById(R.id.myButton1);

		fonts.cambiarfont(getActivity(), R.id.precios, "fonts/ArtistMedium.ttf");
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
		View view = inflater.inflate(R.layout.inversion, container, false);
		return view;
	}

	private void createList() {
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);
		tableView.addBasicItem(new BasicItem("Mes de Mayo", "Estudiantes - S/.95 || Profesionales - S/.100",false));
		tableView.addBasicItem(new BasicItem("Mes de Junio", "Estudiantes - S/.100 || Profesionales - S/.115",false));
		tableView.addBasicItem(new BasicItem("Mes de Julio", "Estudiantes - S/.115 || Profesionales - S/.125",false));
		tableView.addBasicItem(new BasicItem("Mes de Agosto", "Estudiantes - S/.125 || Profesionales - S/.135",false));
	}

	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			if (index == 0) {
				Intent i = new Intent(getSherlockActivity(), informacion.class);
				startActivity(i);
			} else if (index == 1) {

			} else if (index == 2) {

			} else if (index == 3) {

			} else if (index == 4) {

			} else if (index == 5) {

			} else if (index == 6) {

			} else if (index == 7) {
				tableView.clear();
			}

		}

	}

}