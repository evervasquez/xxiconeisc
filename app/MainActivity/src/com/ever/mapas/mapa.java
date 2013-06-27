
package com.ever.mapas;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidhuman.google.maps.v2.support.NoPlayServicesFoundException;
import com.androidhuman.google.maps.v2.support.SupportGoogleMap;
import com.androidhuman.google.maps.v2.support.model.SupportMarker;
import com.ever.conesic.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
public class mapa extends FragmentActivity {

	SupportGoogleMap mGoogleMap;
	SupportMarker mMarker;
	double[] coordenadas;
	String estadia;
	String direccion;
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Bundle bundle = getIntent().getExtras();
	    coordenadas = bundle.getDoubleArray("coordenadas");
	    estadia =bundle.getString("estadia");
	    direccion =bundle.getString("direccion");   
	    setContentView(R.layout.mapa1);
	}
	
	@Override
	protected void onStart() {
	    try {
			mGoogleMap = SupportGoogleMap.newInstance(getApplicationContext(), 
					(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map));
			mMarker = mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(coordenadas[0],coordenadas[1])).title(estadia).snippet(direccion));
			//mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(mMarker.getMarker().getPosition()));
			mMarker.showInfoWindow();
			mGoogleMap.setInitialCameraPosition(mMarker.getMarker().getPosition());
			mGoogleMap.setMyLocationEnabled(true);
			mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(coordenadas[0],coordenadas[1]), 2));
	    } catch (NoPlayServicesFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onStart();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		mGoogleMap.animateTo(new LatLng(coordenadas[0],coordenadas[1]));
		//mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.513434965802698,-76.37042999267578), 13));
		mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(14),2000,null);
		mGoogleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
		super.onResume();
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.activity_marker, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.menu_activity_marker_add:
			// Add a marker to Map
			
			return true;
			
		case R.id.menu_activity_marker_update_title:
			// Update marker's title
			//mGoogleMap.updateMarker(mMarker, "new title");
			return true;
			
		case R.id.menu_activity_marker_update_position:
			//mGoogleMap.updateMarker(mMarker, new LatLng(37.503189,126.906509));
			//mGoogleMap.animateTo(new LatLng(37.503189,126.906509));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	class CustomInfoWindowAdapter implements InfoWindowAdapter {

        // These a both viewgroups containing an ImageView with id "badge" and two TextViews with id
        // "title" and "snippet".
        private final View mWindow;
        private final View mContents;
        

        CustomInfoWindowAdapter() {
        	mWindow = getLayoutInflater().inflate(R.layout.custom_info_window, null);
            mContents = getLayoutInflater().inflate(R.layout.custom_info_contents, null);
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
            badge = R.drawable.casa;
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

}
