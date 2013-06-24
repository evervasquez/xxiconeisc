package informacion;

import java.io.InputStream;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.ever.conesic.R;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

public class deportivo extends SherlockActivity {
	ImageView imagen;
	InputStream img_deportivo = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		getSupportActionBar().setTitle("Campeonato Deportivo");

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
				.contentLayout(R.layout.deportivo);
		setContentView(helper.createView(this));
		helper.initActionBar(this);
		TextView text = (TextView) findViewById(R.id.text_deportivo);
		 
		text.setText(Html.fromHtml("<font color=\"blue\"><h3>Finalidad</h3></br>" +
									"<div>La presente base tiene por finalidad normar la organización y ejecución del campeonato deportivo entre las universidades participantes, promoviendo la confraternidad deportiva social.</div></br>" +
									"<h3>Objetivos</h3></br>" +
									"Fomentar las relaciones humanas con la práctica deportiva, " +
									"Promover la práctica de valores a través de la actividad deportiva y " +
									"Contribuir a una sana diversión y esparcimiento de la población estudiantil.</font>")); // NOTA: las barras invertidas sirven para anular el efecto de las comillas en el String.
		ImageView paper = (ImageView)findViewById(R.id.image_header);
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.deportivo);
        paper.setImageDrawable(drawable);
		super.onResume();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getSupportMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}
}
