package com.ever.conesic;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

////////////////////////////////////
import java.util.ArrayList;
import java.util.List;
import lista.datos;
import lista.adaptador;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
//import android.view.View.OnClickListener;
import android.widget.ListView;
//import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class ponentes extends SherlockFragment{
	 OnURLSelectedListener mListener;
	 List<datos> datoss;
	 String[] ponentes;
	 String[] descripcion;
	 int[] imagenes; 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  Log.v("ListFragment", "onCreate()");
	 }
	 
	 @Override
	 public void onActivityCreated(Bundle savedInstanceState) {
	  super.onActivityCreated(savedInstanceState);
	  //getSherlockActivity().getSupportActionBar().setTitle("XXICONEISC - Ponentes");
	  Log.v("ListFragment", "onActivityCreated().");
	  Log.v("ListsavedInstanceState", savedInstanceState == null ? "true" : "false");
	  
	  ponentes = new String[] { "Dr. Richard Stallman", "Fernanda Weiden", "Jon 'maddog' Hall",
			        "Dr. Nelson Piedra", "Mgtr. Marcela Varas Contreras", "Mgtr. Paula Angeleri", 
			        "Mgtr. Michael Arias Chaves", "Msc. Daan Dekker"
			         };
			
	  descripcion = new String[] { "Presidente de Free Software Foundation - USA", 
					"Gerente de Operaciones de Ingeniería - FACEBOOK IRLANDA", 
					"Director Ejecutivo de Linux International",
			        "Director de la Escuela de Ciencias de la Computación - Ecuador",
			        "Jefa de la Unidad de Investigación y Desarrollo Docente de la Universidad de Concepción de Chile",
			        "Directora de Carrera de Tecnología Informática de la Universidad de Belgrano de Argentina",
			        "Director de la Carrera de Informática Empresarial de la Universidad de Costa Rica",
			        "Máster of science por la Universidad de Utrecht"
			         };
	  imagenes = new int[]{R.drawable.stallman,R.drawable.weiden,R.drawable.maddog,
			  R.drawable.piedra,R.drawable.varas,R.drawable.angeleri,
			  R.drawable.arias,R.drawable.daan	  };
	  
	  //Generate list View from ArrayList
	  displayListView();
	   
	 }
	 
	 @SuppressLint("InlinedApi")
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	   Bundle savedInstanceState) {
	 getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
	  Log.v("ListFragment", "onCreateView()");
	  Log.v("ListContainer", container == null ? "true" : "false");
	  Log.v("ListsavedInstanceState", savedInstanceState == null ? "true" : "false");
	  if (container == null) {
	            return null;
	        }
	  View view = inflater.inflate(R.layout.ponentes, container, false);
	  return view;
	 }
	  
	  
	 // Container Activity must implement this interface
	    public interface OnURLSelectedListener {
	        public void onURLSelected(String URL);
	    }
	     
	    @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        try {
	            mListener = (OnURLSelectedListener) activity;
	        } catch (ClassCastException e) {
	            //throw new ClassCastException(activity.toString() + " must implement OnURLSelectedListener");
	        }
	    }
	  
	 private void displayListView() {
	 
	  //Array list of countries
	datoss = new ArrayList<datos>();
	for (int i = 0; i < ponentes.length; i++) {
		
		datoss.add(new datos(ponentes[i], descripcion[i], imagenes[i]));
	}
	  //create an ArrayAdaptar from the String Array
	 // ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),R.layout.lista_row, datoss);
	  ListView listView = (ListView) getView().findViewById(R.id.listofURLs);
	  // Assign adapter to ListView
	  listView.setAdapter(new adaptador(getActivity(), datoss));
	   
	  //enables filtering for the contents of the given ListView
	  listView.setTextFilterEnabled(true);
	 
	  listView.setOnItemClickListener(new OnItemClickListener() {
	   public void onItemClick(AdapterView<?> parent, View view,
	     int position, long id) {
	    // Send the URL to the host activity
	          Toast.makeText(getActivity(), "la posicion "+position, Toast.LENGTH_LONG).show();
	     
	   }
	  });
	   
	 }
}
