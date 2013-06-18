package informacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;

import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import utiles.paginaweb;
import br.com.dina.ui.widget.UIButton;
import com.ever.conesic.R;

public class info_hospedajes extends SherlockFragmentActivity {
	UITableView tableView;
	UIButton mButton1;
	Intent intent;
	paginaweb pagina;
	String[] estadias, precios;
	int[] objetos;
	// double[] coordenadas;
	hoteles_model datos;
	private static final String SHARED_FILE_NAME = "shared.png";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		datos = (hoteles_model) getIntent().getExtras().getParcelable("datos");
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setTheme(R.style.Theme_Sherlock_Light);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub

		// Toast.makeText(getApplicationContext(), ""+Taca Peru,
		// Toast.LENGTH_SHORT).show();
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		estadias = datos.getEstadias();
		precios = datos.getPrecios();
		objetos = datos.getObjeto();
		// coordenadas = datos.getCoordenadas();
		//getSupportActionBar().setIcon(objetos[0]);
		//getSupportActionBar().setTitle("");
		setContentView(R.layout.concursos);

		mButton1 = (UIButton) findViewById(R.id.myButton1);
		//UIButton.setTitle(estadias[0]); 
		//UIButton.setSubTitle("");
		//UIButton.setImage(objetos[1]);
		

		// mButton3 = (UIButton) findViewById(R.id.myButton3);*/
		tableView = (UITableView) findViewById(R.id.tableView);
		createList();
		tableView.commit();

		// ((TextView)findViewById(R.id.text)).setText(R.string.share_action_providers_content);
		copyPrivateRawResuorceToPubliclyAccessibleFile();
		// Log.i("datos",datos.getData().toString());
		// Toast.makeText(getApplicationContext(),
		// ""+Arrays.toString(datos.getData()),Toast.LENGTH_LONG).show();
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate your menu.
		getSupportMenuInflater().inflate(R.menu.share_action_provider, menu);

		// Set file with share history to the provider and set the share intent.
		MenuItem actionItem = menu
				.findItem(R.id.menu_item_share_action_provider_action_bar);
		ShareActionProvider actionProvider = (ShareActionProvider) actionItem
				.getActionProvider();
		actionProvider
				.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
		actionProvider.setShareIntent(createShareIntent());
		return true;
	}

	private Intent createShareIntent() {
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("image/*");
		Uri uri = Uri.fromFile(getFileStreamPath("shared.png"));
		shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
		return shareIntent;
	}

	@SuppressWarnings("deprecation")
	@SuppressLint("WorldReadableFiles")
	private void copyPrivateRawResuorceToPubliclyAccessibleFile() {
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = getResources().openRawResource(objetos[2]);// edite
			outputStream = openFileOutput(SHARED_FILE_NAME,
					Context.MODE_WORLD_READABLE);
			byte[] buffer = new byte[1024];
			int length = 0;
			try {
				while ((length = inputStream.read(buffer)) > 0) {
					outputStream.write(buffer, 0, length);
				}
			} catch (IOException ioe) {
				/* ignore */
			}
		} catch (FileNotFoundException fnfe) {
			/* ignore */
		} finally {
			try {
				inputStream.close();
			} catch (IOException ioe) {
				/* ignore */
			}
			try {
				outputStream.close();
			} catch (IOException ioe) {
				/* ignore */
			}
		}
	}

	private void createList() {
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);

		for (int i = 0; i < estadias.length; i++) {
			tableView.addBasicItem(estadias[i], precios[i]);
		}

	}

	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			if (index == 0) {

			} else if (index == 1) {

			} else if (index == 2) {

			} else if (index == 3) {

			}

		}

	}

}