package informacion;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import progress.ProgressActivity;
import utiles.fonts;
import utiles.paginaweb;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import basedatos.basedatos;
import br.com.dina.ui.model.BasicItem;
import br.com.dina.ui.widget.UIButton;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.ever.conesic.R;
import com.ever.mapas.mapa;

public class info_estadias extends SherlockFragmentActivity {
	private UITableView tableView;
	private UIButton mButton1;
	paginaweb pagina;
	long id;
	basedatos objetoBD = null;
	String[] dataBD;
	double[] coordenadas;
	private static final String SHARED_FILE_NAME = "shared.png";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = getIntent().getExtras();
		id = bundle.getLong("id");
		setTheme(R.style.Theme_Sherlock_Light);
	}

	@Override
	protected void onStart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// poner todo el cÃ³digo
		setContentView(R.layout.info_concursos);
		fonts.cambiarfont_actionbar(this, "fonts/ArtistMedium.ttf");
		getSupportActionBar().setTitle("Descripción");
		mButton1 = (UIButton) findViewById(R.id.myButton1);
		try {
			objetoBD = new basedatos(getApplicationContext());
			dataBD = objetoBD.getDescripcion(id);
			UIButton.setTitle(dataBD[0]);
			UIButton.setSubTitle("fotografia");
			CustomClickListener1 listener = new CustomClickListener1();
			mButton1.addClickListener(listener);
			tableView = (UITableView) findViewById(R.id.tableView);
			createList();
			tableView.commit();
			objetoBD.cerrar();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"Hubo un Error al recuperar los datos", Toast.LENGTH_SHORT)
					.show();
		}
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

	@SuppressLint("WorldReadableFiles")
	private void copyPrivateRawResuorceToPubliclyAccessibleFile() throws UnsupportedEncodingException {
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new ByteArrayInputStream(dataBD[9].getBytes("UTF-8"));
			//inputStream = getResources().openRawResource(dataBD[9]);//edite
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

		coordenadas = new double[]{Double.parseDouble(dataBD[10]),Double.parseDouble(dataBD[11])};
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);
		tableView.addBasicItem(R.drawable.celular, "Telefono", dataBD[7]);
		tableView.addBasicItem(R.drawable.ubicacion, "Ubicación", dataBD[8]);
		if (dataBD[1] != null) {
			tableView.addBasicItem(new BasicItem("Costo de Habitación simple",
					"S/." + dataBD[1], false));
		}
		if (dataBD[2] != null) {
			tableView.addBasicItem(new BasicItem("Costo de Habitación doble",
					"S/." + dataBD[2], false));
		}
		if (dataBD[4] != null) {
			tableView.addBasicItem(new BasicItem("Costo de Habitación triple",
					"S/." + dataBD[4], false));
		}
		if (dataBD[3] != null) {
			tableView
					.addBasicItem(new BasicItem(
							"Costo de Habitación matrimonial", "S/."
									+ dataBD[3], false));
		}
		if (dataBD[5] != null) {
			tableView.addBasicItem(new BasicItem(
					"Costo de Habitacion cuadruple", "S/." + dataBD[5], false));
		}
		if (dataBD[6] != null) {
			tableView.addBasicItem(new BasicItem("Costo de Habitación CX",
					"S/." + dataBD[6], false));
		}

	}

	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			if (index == 0) {
				Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+dataBD[7]));
				startActivity(intent);
			} else if (index == 1) {
				Intent i = new Intent(info_estadias.this, mapa.class);
				i.putExtra("coordenadas", coordenadas);
				i.putExtra("estadia", dataBD[0]);
				i.putExtra("direccion", dataBD[8]);
				//Toast.makeText(getApplicationContext(), ""+coordenadas.length, Toast.LENGTH_SHORT).show();
				startActivity(i);
			} else if (index == 2) {

			} else if (index == 3) {
				pagina = new paginaweb();
				// pagina.paginaWeb(info_estadias.this, data[4]);
			}

		}
	}


	private class CustomClickListener1 implements
			br.com.dina.ui.widget.UIButton.ClickListener {

		public void onClick(View view) {
			Intent intent = new Intent(getApplicationContext(), ProgressActivity.class);
			intent.putExtra("url_imagen",dataBD[9] );
			startActivity(intent);
		}

	}
}