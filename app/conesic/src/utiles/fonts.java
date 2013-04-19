package utiles;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class fonts {
	
	public static void cambiarfont_actionbar(Activity actividad, String fonts){
		LinearLayout viewGroup = (LinearLayout) actividad.findViewById(com.actionbarsherlock.R.id.title_u);
		LayoutInflater layoutInflater = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = layoutInflater.inflate(com.actionbarsherlock.R.layout.abs__action_bar_title_item, viewGroup);
		TextView custom = (TextView) layout.findViewById(com.actionbarsherlock.R.id.abs__action_bar_title);
		Typeface font = Typeface.createFromAsset(actividad.getAssets(), fonts);
		custom.setTypeface(font);
	}
	
	public static void cambiarfont(Activity actividad,View view,int textview, String fonts){
		TextView custom = (TextView) view.findViewById(textview);
		Typeface font = Typeface.createFromAsset(actividad.getAssets(), fonts);
		custom.setTypeface(font);
	}
	
	public static void cambiarfont(Activity actividad,int textview, String fonts){
		TextView custom = (TextView) actividad.findViewById(textview);
		Typeface font = Typeface.createFromAsset(actividad.getAssets(), fonts);
		custom.setTypeface(font);
	}
}
