package com.ever.conesic;

import com.actionbarsherlock.app.SherlockFragment;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;
import aerea.taca;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class aerea extends SherlockFragment {
    
	UITableView tableView;
	
	 @Override
	 public void onActivityCreated(Bundle savedInstanceState) {
	  super.onActivityCreated(savedInstanceState);
	  getSherlockActivity().getSupportActionBar().setTitle("XXICONEISC - aerea");
	  tableView = (UITableView) getView().findViewById(R.id.tableView);        
      createList();
      tableView.commit();
	 }
	 
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	   Bundle savedInstanceState) {
	  Log.v("ListFragment", "onCreateView()");
	  Log.v("ListContainer", container == null ? "true" : "false");
	  Log.v("ListsavedInstanceState", savedInstanceState == null ? "true" : "false");
	  if (container == null) {
	            return null;
	        }
	  View view = inflater.inflate(R.layout.aerea, container, false);
	  return view;
	 }
    private void createList() {
    	CustomClickListener listener = new CustomClickListener();
    	tableView.setClickListener(listener);
    	tableView.addBasicItem(R.drawable.taca,"", "");
    	tableView.addBasicItem(R.drawable.lan,"", "");
    	tableView.addBasicItem(R.drawable.starperu,"", "");
    	/*tableView.addBasicItem(R.drawable.piedra,"Example 4 - UITableView", "only one item");
    	tableView.addBasicItem("Example 5 - UITableViewActivity", "a sample activity");
    	tableView.addBasicItem("Example 6 - UITableViewActivity temp", "item with custom view");
    	tableView.addBasicItem("Example 7 - UIButton", "some floating buttons");
    	tableView.addBasicItem("Example 8 - Clear List", "this button will clear the list");*/
    	
    }
    
    private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			if(index == 0) {
				Intent i = new Intent(getSherlockActivity(), taca.class);
				startActivity(i);	
			}
			else if(index == 1) {
								
			}
			else if(index == 2) {
								
			}
			else if(index == 3) {
								
			}
			else if(index == 4) {
								
			}
			else if(index == 5) {
								
			}
			else if(index == 6) {
							
			}
			else if(index == 7) {
				tableView.clear();		
			}
			
		}
    	
    }
    
}