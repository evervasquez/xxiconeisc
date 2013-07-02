package informacion;

import java.io.InputStream;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.ever.conesic.R;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

public class biografia extends SherlockActivity {
	ImageView imagen;
	InputStream img_deportivo = null;
	private WebView webView;
	int biografia_imagen;
	String ponente, biografia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		Bundle bundle = getIntent().getExtras();
	    biografia_imagen = bundle.getInt("biografia_imagen");
	    ponente = bundle.getString("ponente");
	    biografia = bundle.getString("biografia");
	    getSupportActionBar().setTitle(ponente);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	protected void onResume() {
		// TODO Auto-generated method stub
		FadingActionBarHelper helper = new FadingActionBarHelper()
				.actionBarBackground(R.drawable.ab_background_light)
				.headerLayout(R.layout.header_light)
				.contentLayout(R.layout.biografia);
		setContentView(helper.createView(this));
		helper.initActionBar(this);
		webView = (WebView) findViewById(R.id.biografia);
		webView.setBackgroundColor(Color.WHITE);
		webView.setVerticalScrollBarEnabled(true);
		webView.setVerticalFadingEdgeEnabled(true);
		webView.setVerticalScrollbarOverlay(true);
		webView.loadDataWithBaseURL(null,biografia, "text/html", "UTF-8",null);
		
		ImageView paper = (ImageView) findViewById(R.id.image_header);
		Resources res = getResources();
		Drawable drawable = res.getDrawable(biografia_imagen);
		paper.setImageDrawable(drawable);
		super.onResume();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getSupportMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}
}
