package com.ever.conesic;

import informacion.informacion;
import informacion.modelo;
import main.java.com.u1aryz.android.lib.newpopupmenu.MenuItem;
import main.java.com.u1aryz.android.lib.newpopupmenu.PopupMenu;
import main.java.com.u1aryz.android.lib.newpopupmenu.PopupMenu.OnItemSelectedListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragment;

public class concursos extends SherlockFragment implements OnItemSelectedListener {
	private final static int VISUALIZAR_DOCUMENTO = 0;
    private final static int DESCARGAR_DOCUMENTO = 1;
    private final static int SEARCH = 2;
	UITableView tableView;
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
		tableView.setOnClickListener(this);
		tableView.addBasicItem(R.drawable.papers, "", "");
		tableView.addBasicItem(R.drawable.programacion, "", "");
		tableView.addBasicItem("Concurso de Proyectos", "");
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
	
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // Create Instance
        PopupMenu menu = new PopupMenu(getActivity());
        menu.setHeaderTitle("Titulo");
        // Set Listener
        menu.setOnItemSelectedListener(this);
        // Add Menu (Android menu like style)
        menu.add(VISUALIZAR_DOCUMENTO, R.string.play).setIcon(
                getResources().getDrawable(R.drawable.ic_action_select_all_dark));
        menu.add(DESCARGAR_DOCUMENTO, R.string.add_to_playlist).setIcon(
                getResources().getDrawable(R.drawable.ic_action_refresh_dark));
        menu.add(SEARCH, R.string.search).setIcon(
                getResources().getDrawable(R.drawable.ic_menu_moreoverflow_normal_holo_light));
        menu.show(v);
    }
    
	@Override
	public void onItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
        switch (item.getItemId()) {
        case VISUALIZAR_DOCUMENTO:
            break;

        case DESCARGAR_DOCUMENTO:
            break;

        case SEARCH:
            break;

        }
	}
	
	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			
			switch (index) {
			case 0:
				
				break;
			case 1:
				
				break;
			case 2:
				//data para armar la vista
				
				break;
			default:
				break;
			}
		}

	}
}
