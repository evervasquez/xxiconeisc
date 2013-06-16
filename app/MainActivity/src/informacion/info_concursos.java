package informacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;

import br.com.dina.ui.model.BasicItem;
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

public class info_concursos extends SherlockFragmentActivity {
	UITableView tableView;
	UIButton mButton1;
	Intent intent;
	paginaweb pagina ;
	String[] data;
	int[] objetos;
	//double[] coordenadas;
	concursos_model datos;
	private static final String SHARED_FILE_NAME = "shared.png";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		datos = (concursos_model)getIntent().getExtras().getParcelable("datos");
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setTheme(R.style.Theme_Sherlock_Light);
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		//Toast.makeText(getApplicationContext(), ""+Taca Peru, Toast.LENGTH_SHORT).show();
		super.onRestart();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		data = datos.getData();
		objetos = datos.getObjeto();
		//coordenadas = datos.getCoordenadas();
		getSupportActionBar().setIcon(objetos[0]);
		getSupportActionBar().setTitle("");
		setContentView(R.layout.info_concursos);
		
		mButton1 = (UIButton) findViewById(R.id.myButton1);
		UIButton.setTitle(data[0]);
		UIButton.setSubTitle("");
		UIButton.setImage(objetos[1]);

		//mButton3 = (UIButton) findViewById(R.id.myButton3);*/
		tableView = (UITableView) findViewById(R.id.tableView);        
	    createList();
	    tableView.commit();
	    
	    //((TextView)findViewById(R.id.text)).setText(R.string.share_action_providers_content);
        copyPrivateRawResuorceToPubliclyAccessibleFile();
		//Log.i("datos",datos.getData().toString());
		//Toast.makeText(getApplicationContext(), ""+Arrays.toString(datos.getData()),Toast.LENGTH_LONG).show();
		super.onResume();
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate your menu.
        getSupportMenuInflater().inflate(R.menu.share_action_provider, menu);

        // Set file with share history to the provider and set the share intent.
        MenuItem actionItem = menu.findItem(R.id.menu_item_share_action_provider_action_bar);
        ShareActionProvider actionProvider = (ShareActionProvider) actionItem.getActionProvider();
        actionProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
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
            inputStream = getResources().openRawResource(objetos[2]);//edite
            outputStream = openFileOutput(SHARED_FILE_NAME,
                    Context.MODE_WORLD_READABLE );
            byte[] buffer = new byte[1024];
            int length = 0;
            try {
                while ((length = inputStream.read(buffer)) > 0){
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
    	tableView.addBasicItem(R.drawable.informacion,"Información", "Wikipedia");
    	tableView.addBasicItem(new BasicItem(R.drawable.pdf,"Bases de Concurso", "Descargar"));
    	tableView.addBasicItem(R.drawable.calendario,"Fechas Importantes", data[3]);
    	tableView.addBasicItem(R.drawable.firefox,"Coneisc Web", data[4]);
    	//tableView.addBasicItem(R.drawable.twitter,"Twitter", data[5]);
    	//tableView.addBasicItem(R.drawable.google,"Google+", data[6]);
    	//tableView.addBasicItem(R.drawable.email,"Correo", data[7]);
    	//tableView.addBasicItem("Costos", "");
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
				pagina = new paginaweb();
				pagina.paginaWeb(info_concursos.this, data[1]);
				//http://www.scribd.com/document_downloads/140723306?extension=pdf&from=embed&source=embed
			}
			else if(index == 1) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(data[2])));
			}
			else if(index == 2) {
					
			}
			else if(index == 3) {
				pagina = new paginaweb();
				pagina.paginaWeb(info_concursos.this, data[4]);				
			}
			
			
		}
    	
		}
    

}