package informacion;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import utiles.fonts;
import utiles.paginaweb;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

public class info_edecanes extends SherlockFragmentActivity {
	private UITableView tableView;
	private UIButton mButton1;
	paginaweb pagina;
	long id;
	basedatos objetoBD = null;
	String[] dataBD;
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
		// poner todo el código
		setContentView(R.layout.info_concursos);
		fonts.cambiarfont_actionbar(this, "fonts/ArtistMedium.ttf");
		getSupportActionBar().setTitle("Edecan");
		mButton1 = (UIButton) findViewById(R.id.myButton1);
		try {
			objetoBD = new basedatos(getApplicationContext());
			dataBD = objetoBD.getEdecan(id);
			UIButton.setTitle(dataBD[0]);
			UIButton.setSubTitle("");
			// CustomClickListener1 listener = new CustomClickListener1();
			// mButton1.addClickListener(listener);
			// recuperar imagen

			//

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
	private void copyPrivateRawResuorceToPubliclyAccessibleFile()
			throws UnsupportedEncodingException {
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new ByteArrayInputStream(dataBD[9].getBytes("UTF-8"));
			// inputStream = getResources().openRawResource(dataBD[9]);//edite
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
		tableView.addBasicItem(R.drawable.celular, "Telefono", dataBD[1]);
		tableView.addBasicItem(R.drawable.facebook, "Facebook", dataBD[2]);
		tableView.addBasicItem(new BasicItem("Universidad", dataBD[3],
				false));
	}

	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			if (index == 0) {
				// pagina = new paginaweb();
				// pagina.paginaWeb(info_estadias.this, data[1]);
				// http://www.scribd.com/document_downloads/140723306?extension=pdf&from=embed&source=embed
			} else if (index == 1) {
				// startActivity(new Intent(Intent.ACTION_VIEW,
				// Uri.parse(data[2])));
			} else if (index == 2) {

			} else if (index == 3) {
				// pagina = new paginaweb();
				// pagina.paginaWeb(info_estadias.this, data[4]);
			}

		}

	}
}