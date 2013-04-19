/*
 * Copyright 2013 Taeho Kim (jyte82@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
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
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ever.conesic.R;
public class mapa extends FragmentActivity {

	SupportGoogleMap mGoogleMap;
	SupportMarker mMarker;
	 
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mapa1);
	    
	    // Get an instance of the SupportGoogleMap
	    try {
			mGoogleMap = SupportGoogleMap.newInstance(getApplicationContext(), 
					(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map));
			mMarker = mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-6.513434965802698,-76.37042999267578)).title("Taca Peru").snippet("Aereopuerto Tarapoto"));
			//mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(mMarker.getMarker().getPosition()));
			mGoogleMap.setInitialCameraPosition(mMarker.getMarker().getPosition());
			mGoogleMap.setMyLocationEnabled(true);
			mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.513434965802698,-76.37042999267578), 2));
	    } catch (NoPlayServicesFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		//Toast.makeText(getApplicationContext(), ""+mGoogleMap.getMapType(), Toast.LENGTH_SHORT).show();
		//mGoogleMap.setMapType(2);
		
		super.onStart();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		mGoogleMap.animateTo(new LatLng(-6.513434965802698,-76.37042999267578));
		//mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.513434965802698,-76.37042999267578), 13));
		mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(13),2000,null);
		mGoogleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
		super.onResume();
		
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

}
