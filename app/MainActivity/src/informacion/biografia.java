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
	int biografia;
	String ponente;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		Bundle bundle = getIntent().getExtras();
	    biografia = bundle.getInt("biografia");
	    ponente = bundle.getString("ponente");
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
		String webPage_es = "<html><head><meta charset=utf-8><style type='text/css'>"
				+ "body {font-size: 15px }</style></head><body><div style=text-align:justify><h2>Extract</h2>Entrepreneur with 10+ years of experience engaged " +
				"in the development, creation and implementation of web-based projects, with relevant experience " +
				"in travel companies. Director Lima Valley, Co-Founder & Mentor @Startup Academy, Organizer & Advisor " +
				"Startup World, Wayra Perú Mentor Especialidades:entrepreneurship, internet business development, " +
				"startups, digital marketing, digital analytics, seo, sem ecommerce, innovation, mobile</br>" +
				"<h2>Experiencia</h2><strong>Co-Fundador</strong></br>Startup Academy LA</br>Startup Academy is a program that provides business " +
				"model training and mentoring to help entrepreneurs on their road to success.<br>" +
				"</br><strong>Director</strong></br>Lima Valley</br>Lima Valley is a non-profit organization in Peru that " +
				"focuses on growing a community that promotes an entrepreneurial and innovative environment for the peruvian " +
				"tech ecosystem.</div></body></html>";
		webView = (WebView) findViewById(R.id.biografia);
		webView.setBackgroundColor(Color.WHITE);
		webView.setVerticalScrollBarEnabled(true);
		webView.setVerticalFadingEdgeEnabled(true);
		webView.setVerticalScrollbarOverlay(true);
		webView.loadData(webPage_es, "text/html", "UTF-8");
		
		ImageView paper = (ImageView) findViewById(R.id.image_header);
		Resources res = getResources();
		Drawable drawable = res.getDrawable(biografia);
		paper.setImageDrawable(drawable);
		super.onResume();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getSupportMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}
}
