package informacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import utiles.paginaweb;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import br.com.dina.ui.model.BasicItem;
import br.com.dina.ui.widget.UIButton;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.ever.conesic.R;

public class info_ponentes extends SherlockFragmentActivity {
	UITableView tableView;
	UIButton mButton1;
	Intent intent;
	paginaweb pagina;
	String[] data;
	int[] objetos;
	// double[] coordenadas;
	ponentes_model datos;
	private static final String SHARED_FILE_NAME = "shared.png";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		datos = (ponentes_model) getIntent().getExtras().getParcelable("datos");
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
		data = datos.getData();
		objetos = datos.getObjeto();
		// coordenadas = datos.getCoordenadas();
		getSupportActionBar().setIcon(objetos[0]);
		getSupportActionBar().setTitle(data[0]);
		setContentView(R.layout.info_ponentes);

		mButton1 = (UIButton) findViewById(R.id.myButton1);
		UIButton.setTitle(data[1]);
		UIButton.setSubTitle("Biografia");
		CustomClickListener1 listener = new CustomClickListener1();
		mButton1.addClickListener(listener);

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
			inputStream = getResources().openRawResource(objetos[0]);// edite
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
		tableView.addBasicItem(R.drawable.docx, "C.V", data[2]);
		if (data[3] != null) {
			tableView.addBasicItem(new BasicItem(R.drawable.facebook,
					"Facebook", data[3]));
		}
		if (data[4] != null) {
			tableView.addBasicItem(R.drawable.twitter, "Twitter", data[4]);
		}
		if (data[5] != null) {
			tableView.addBasicItem(R.drawable.email, "Email", data[5]);
		}
		if (data[6] != null) {
			tableView.addBasicItem(R.drawable.in, "Linkedin", data[6]);
		}

	}

	private class CustomClickListener implements ClickListener {
		@Override
		public void onClick(int index) {
			Log.d("MainActivity", "item clicked: " + index);
			if (index == 0) {
				pagina = new paginaweb();
				pagina.paginaWeb(info_ponentes.this, data[2]);
			} else if (index == 1) {
				if (data[3] != null) {
					pagina = new paginaweb();
					pagina.paginaWeb(info_ponentes.this, data[3]);
				}
			} else if (index == 2) {
				if (data[4] != null) {
					pagina = new paginaweb();
					pagina.paginaWeb(info_ponentes.this, data[4]);
				}
			} else if (index == 3) {

			} else if (index == 4) {
				if (data[6] != null) {
					pagina = new paginaweb();
					pagina.paginaWeb(info_ponentes.this, data[6]);
				}
			} else if (index == 5) {

			}
		}

	}

	private class CustomClickListener1 implements
			br.com.dina.ui.widget.UIButton.ClickListener {

		public void onClick(View view) {
			Toast.makeText(getApplicationContext(), "Aquí la Biografia", Toast.LENGTH_SHORT).show();
		}

	}

}