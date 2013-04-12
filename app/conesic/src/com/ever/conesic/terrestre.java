package com.ever.conesic;

import com.actionbarsherlock.app.SherlockFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class terrestre extends SherlockFragment {

	private GoogleMap mMap;
	private UiSettings mUiSettings;
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  Log.v("ListFragment", "onCreate()");
	  
	 }
	 
	 @Override
	 public void onActivityCreated(Bundle savedInstanceState) {
	  super.onActivityCreated(savedInstanceState);
	  getSherlockActivity().getSupportActionBar().setTitle("XXICONEISC - Mapa");
	  Log.v("ListFragment", "onActivityCreated().");
	  Log.v("ListsavedInstanceState", savedInstanceState == null ? "true" : "false");
	  setUpMapIfNeeded();
      mMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {			
			@Override
			public void onInfoWindowClick(Marker marker) {
				// TODO Auto-generated method stub
				Toast.makeText(
						getActivity(), 
						"Click en infoWindow",
						Toast.LENGTH_SHORT).show();
			}
		});
	 }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
			   Bundle savedInstanceState) {
			  if (container == null) {
			            return null;
			        }
			  View view = inflater.inflate(R.layout.terrestre, container, false);
			  return view;
			 }

    @Override
	public void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }
    
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSherlockActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
    
    private void setUpMap() {
    	mMap.setMyLocationEnabled(true);
        mUiSettings = mMap.getUiSettings();
        mUiSettings.setMyLocationButtonEnabled(true);
        
    	mostrarMarcador(-6.484854474746015,-76.37905530631542,"FISI, UNSM","Population: 4,137,400");
		mostrarMarcador(-6.487659429495001,-76.36801600456238,"Complejo UNSM","Population: 4,137,400");
		
		mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
		
    }
    
    class CustomInfoWindowAdapter implements InfoWindowAdapter {

        // These a both viewgroups containing an ImageView with id "badge" and two TextViews with id
        // "title" and "snippet".
        private final View mWindow;
        private final View mContents;
        

        CustomInfoWindowAdapter() {
        	mWindow = getActivity().getLayoutInflater().inflate(R.layout.custom_info_window, null);
            mContents = getActivity().getLayoutInflater().inflate(R.layout.custom_info_contents, null);
            //mostrarMarcador(-6.487659429495001,-77.36801600456238,"Otro","Population: 4,137,400");
        }

        @Override
        public View getInfoWindow(Marker marker) {
            render(marker, mWindow);
            return mWindow;
        }

        @Override
        public View getInfoContents(Marker marker) {
            render(marker, mContents);
            return mContents;
        }

        private void render(Marker marker, View view) {
            int badge;
            badge = R.drawable.badge_qld;
            // Use the equals() method on a Marker to check for equals.  Do not use ==.
            /*if (marker.equals(mBrisbane)) {
                badge = R.drawable.badge_qld;
            } else if (marker.equals(mAdelaide)) {
                badge = R.drawable.badge_sa;
            } else if (marker.equals(mSydney)) {
                badge = R.drawable.badge_nsw;
            } else if (marker.equals(mMelbourne)) {
                badge = R.drawable.badge_victoria;
            } else if (marker.equals(mPerth)) {
                badge = R.drawable.badge_wa;
            } else {
                // Passing 0 to setImageResource will clear the image view.
                badge = 0;
            }*/
            ((ImageView) view.findViewById(R.id.badge)).setImageResource(badge);

            String title = marker.getTitle();
            TextView titleUi = ((TextView) view.findViewById(R.id.title));
            if (title != null) {
                // Spannable string allows us to edit the formatting of the text.
                SpannableString titleText = new SpannableString(title);
                titleText.setSpan(new ForegroundColorSpan(Color.RED), 0, titleText.length(), 0);
                titleUi.setText(titleText);
            } else {
                titleUi.setText("");
            }

            String snippet = marker.getSnippet();
            TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
            if (snippet != null && snippet.length() > 12) {
                SpannableString snippetText = new SpannableString(snippet);
                snippetText.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, 10, 0);
                snippetText.setSpan(new ForegroundColorSpan(Color.BLUE), 12, snippet.length(), 0);
                snippetUi.setText(snippetText);
            } else {
                snippetUi.setText("");
            }
            
        }
    }
    
    /*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{	
		switch(item.getItemId())
		{
			case R.id.menu_marcadores:
				mostrarMarcador(-6.47994918865121,-76.37666637245957,"Coliseo Tarapoto","Deporte:fulbito");
				break;
		}
		
		return super.onOptionsItemSelected(item);
	}*/
    
    private void mostrarMarcador(double lat, double lng, String title, String snippet){
		mMap.addMarker(new MarkerOptions()
		.position(new LatLng(lat, lng))
		.title(title)
		.snippet(snippet)
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
	}
        
}
