package com.ever.conesic;
import utiles.fonts;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import utiles.paginaweb;
import menuslide.MenuDrawer;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
//import adaptadores.ImageAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

//import android.widget.GridView;

public class MainActivity extends SherlockFragmentActivity implements
		View.OnClickListener {

	private static final String STATE_MENUDRAWER = "net.simonvt.menudrawer.samples.WindowSample.menuDrawer";
	private static final String STATE_ACTIVE_VIEW_ID = "net.simonvt.menudrawer.samples.WindowSample.activeViewId";
	private MenuDrawer mMenuDrawer;
	private int mActiveViewId;
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}
	@SuppressLint("NewApi") @Override
	public void onCreate(Bundle inState) {
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(inState);
		if (inState != null) {
			mActiveViewId = inState.getInt(STATE_ACTIVE_VIEW_ID);
		}

		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW);
		mMenuDrawer.setContentView(R.layout.activity_main);
		mMenuDrawer.setMenuView(R.layout.menu_scrollview);

		fonts.cambiarfont_actionbar(this, "fonts/ArtistMedium.ttf");

		getSupportActionBar().setTitle("XXICONEISC");
			
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		fonts.cambiarfont(this, R.id.xxiconeisc, "fonts/ArtistMedium.ttf");
		findViewById(R.id.xxiconeisc).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.conocenos, "fonts/ArtistMedium.ttf");
		findViewById(R.id.conocenos).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.ponentes, "fonts/ArtistMedium.ttf");
		findViewById(R.id.ponentes).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.conferencias, "fonts/ArtistMedium.ttf");
		findViewById(R.id.conferencias).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.talleres, "fonts/ArtistMedium.ttf");
		findViewById(R.id.talleres).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.concursos, "fonts/ArtistMedium.ttf");
		findViewById(R.id.concursos).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.inversion, "fonts/ArtistMedium.ttf");
		findViewById(R.id.inversion).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.actividades, "fonts/ArtistMedium.ttf");
		findViewById(R.id.actividades).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.terrestre, "fonts/ArtistMedium.ttf");
		findViewById(R.id.terrestre).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.aerea, "fonts/ArtistMedium.ttf");
		findViewById(R.id.aerea).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.fluvial, "fonts/ArtistMedium.ttf");
		findViewById(R.id.fluvial).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.hoteles, "fonts/ArtistMedium.ttf");
		findViewById(R.id.hoteles).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.restaurante, "fonts/ArtistMedium.ttf");
		findViewById(R.id.restaurante).setOnClickListener(this);
		fonts.cambiarfont(this, R.id.turismo, "fonts/ArtistMedium.ttf");
		findViewById(R.id.turismo).setOnClickListener(this);
		
		fonts.cambiarfont(this, R.id.favoritos, "fonts/ArtistMedium.ttf");
		fonts.cambiarfont(this, R.id.xxi, "fonts/ArtistMedium.ttf");
		fonts.cambiarfont(this, R.id.comollegar, "fonts/ArtistMedium.ttf");
		fonts.cambiarfont(this, R.id.tarapoto, "fonts/ArtistMedium.ttf");
		// This will animate the drawer open and closed until the user manually
		// drags it. Usually this would only be
		// called on first launch.
		mMenuDrawer.peekDrawer();

		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		logo logito = new logo();
		transaction.add(R.id.fragment_container, logito).commit();

		// GridView gv = (GridView)findViewById(R.id.gridview);
		// error mare
		// gv.setAdapter(new ImageAdapter(this));

	}

	@Override
	protected void onRestoreInstanceState(Bundle inState) {
		super.onRestoreInstanceState(inState);
		mMenuDrawer.restoreState(inState.getParcelable(STATE_MENUDRAWER));
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelable(STATE_MENUDRAWER, mMenuDrawer.saveState());
		outState.putInt(STATE_ACTIVE_VIEW_ID, mActiveViewId);
	}

	public void onBackPressed() {
		final int drawerState = mMenuDrawer.getDrawerState();
		if (drawerState == MenuDrawer.STATE_OPEN
				|| drawerState == MenuDrawer.STATE_OPENING) {
			mMenuDrawer.closeMenu();
			return;
		}

		super.onBackPressed();
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			mMenuDrawer.openMenu();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onClick(View v) {
		mMenuDrawer.setActiveView(v);
		mMenuDrawer.closeMenu();
		mActiveViewId = v.getId();
		paginaweb pagina;
		Fragment newFragment = null;
		FragmentTransaction transaccion = getSupportFragmentManager()
				.beginTransaction();

		switch (mActiveViewId) {
		case R.id.xxiconeisc:
			//newFragment = new Xxiconeisc();
			pagina = new paginaweb();
			pagina.paginaWeb(this, "http://coneisc.pe/");
			return;
		case R.id.conocenos:
			pagina = new paginaweb();
			pagina.paginaWeb(this, "http://coneisc.pe/web/presentacion");
			return;
		case R.id.ponentes:
			newFragment = new ponentes();
			break;
		case R.id.conferencias:
			newFragment = new conferencias();
			break;
		case R.id.talleres:
			newFragment = new talleres();
			break;
		case R.id.inversion:
			newFragment = new inversion();
			break;
		case R.id.concursos:
			newFragment = new concursos();
			break;
		case R.id.actividades:
			Toast.makeText(getApplicationContext(), "Pagina en Construcci�n", Toast.LENGTH_LONG).show();
			newFragment = new Xxiconeisc();
			break;
		case R.id.terrestre:
			//newFragment = new terrestre();
			Toast.makeText(getApplicationContext(), "Pagina en Construcci�n", Toast.LENGTH_LONG).show();
			newFragment = new Xxiconeisc();
			break;
		case R.id.aerea:
			newFragment = new aerea();
			break;
		case R.id.fluvial:
			Toast.makeText(getApplicationContext(), "Pagina en Construcci�n", Toast.LENGTH_LONG).show();
			newFragment = new Xxiconeisc();
			break;
		case R.id.hoteles:
			Toast.makeText(getApplicationContext(), "Pagina en Construcci�n", Toast.LENGTH_LONG).show();
			newFragment = new Xxiconeisc();
			break;
		case R.id.restaurante:
			Toast.makeText(getApplicationContext(), "Pagina en Construcci�n", Toast.LENGTH_LONG).show();
			newFragment = new Xxiconeisc();
			break;
		case R.id.turismo:
			newFragment = new turismo();
			break;
		default:
			break;
		}
		transaccion.replace(R.id.fragment_container, newFragment);
		transaccion.addToBackStack(null);
		transaccion.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		transaccion.commit();

	}

}