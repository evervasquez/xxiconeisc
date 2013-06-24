package informacion;

import java.util.List;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import basedatos.basedatos;
import br.com.dina.ui.widget.UITableView;
import br.com.dina.ui.widget.UITableView.ClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import utiles.fonts;
import utiles.paginaweb;
import br.com.dina.ui.widget.UIButton;
import com.ever.conesic.R;

public class estadias extends SherlockFragmentActivity {
	UITableView tableView;
	UIButton mButton1;
	Intent intent;
	paginaweb pagina;
	String categoria;
	basedatos objetoBD;
	List<hoteles_model> dataBD;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
        categoria = bundle.getString("categoria");
		setTheme(R.style.Theme_Sherlock_Light);
	}

	@Override
	protected void onStart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		setContentView(R.layout.concursos2);
		fonts.cambiarfont_actionbar(this, "fonts/ArtistMedium.ttf");
		tableView = (UITableView) findViewById(R.id.tableView);
		createList();
		tableView.commit();
		super.onResume();
	}

	private void createList() {
		CustomClickListener listener = new CustomClickListener();
		tableView.setClickListener(listener);
		try {
			if (objetoBD == null) {
				objetoBD = new basedatos(getApplicationContext());
			}
				dataBD = objetoBD.getEstadias(categoria);
				for( int i = 0 ; i < dataBD.size() ; i++ ){
					tableView.addBasicItem(dataBD.get(i).getNombre(), dataBD.get(i).getRango()); 
					}
				getSupportActionBar().setTitle(categoria);
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"Hubo un Error al recuperar los datos", Toast.LENGTH_SHORT)
					.show();
		}

	}

	private class CustomClickListener implements ClickListener {

		@Override
		public void onClick(int index) {
			intent = new Intent(estadias.this, info_estadias.class);
			intent.putExtra("id", dataBD.get(index).getId());
			startActivity(intent);
		}

	}

}