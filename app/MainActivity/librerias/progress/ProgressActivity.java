/*
 * Copyright (C) 2013 Evgeny Shishkin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package progress;

import informacion.mostrar_imagenes;
import utiles.internet;
import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.actionbarsherlock.R;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

/**
 * @author eveR
 */
public class ProgressActivity extends SherlockFragmentActivity {
	private String url_imagen;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		Bundle bundle = getIntent().getExtras();
		url_imagen = bundle.getString("url_imagen");
		
		if (internet.checkConex(getApplicationContext())) {
			Fragment fragment = getSupportFragmentManager().findFragmentById(
					android.R.id.content);
			if (fragment == null) {

				fragment = mostrar_imagenes.newInstance();
				Bundle args = new Bundle();
				args.putString("url_imagen", url_imagen);
				fragment.setArguments(args);
				getSupportFragmentManager().beginTransaction()
						.add(android.R.id.content, fragment).commit();
			}
			getSupportActionBar().setTitle("Regresar");
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}else{
			Toast.makeText(getApplicationContext(), "Verifique estar conectado a INTERNET", Toast.LENGTH_LONG).show();
			finish();
		}
		
		

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	// implementar fin de la actividad de la imagen
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * Helper for fix issue VerifyError on Android 1.6. On Android 1.6 virtual
	 * machine tries to resolve (verify) getActionBar function, and since there
	 * is no such function, Dalvik throws VerifyError.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private class ActionBarHelper {

		/**
		 * Set whether home should be displayed as an "up" affordance. Set this
		 * to true if selecting "home" returns up by a single level in your UI
		 * rather than back to the top level or front page.
		 * 
		 * @param showHomeAsUp
		 *            true to show the user that selecting home will return one
		 *            level up rather than to the top level of the app.
		 */
		private void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
			getActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
		}
	}

}
