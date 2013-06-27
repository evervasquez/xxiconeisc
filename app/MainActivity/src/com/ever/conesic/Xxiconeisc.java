package com.ever.conesic;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
//import android.webkit.WebView;
//import android.widget.LinearLayout;

public class Xxiconeisc extends SherlockFragment {
	@SuppressLint("InlinedApi")
	WebView webView;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
		//getSherlockActivity().setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
	//	getSherlockActivity().getSupportActionBar().setTitle("XXICONEISC");
		View root = inflater.inflate(R.layout.activity_xxiconeisc, container, false);
		return root;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		String webPage_es ="<html><head><meta charset=utf-8><style type='text/css'>"+
						   "body {padding: 4px ;font-size: 15px }</style></head><body><div style=text-align:justify>EL <strong>XXI CONEISC TARAPOTO 2013</strong> El Vigésimo Primer " +
						   "Congreso Nacional de Estudiantes de Ingeniería de Sistemas y Computación, XXI CONEISC, " +
						   "es el evento de índole nacional que reúne a los estudiantes de las carreras de Ingeniería de Sistemas, " +
						   "Informática, Computación y afines, promovido por la <strong>Asociación Peruana de Estudiantes de ingeniería de Sistemas y Computación (APEISC)</strong>; " +
						   "este año 2013 la organización está a cargo de la Facultad de ingeniería de Sistemas e Informática de la Universidad Nacional de San Martin de Tarapoto, " +
						   "a partir del día 12 al 17 de Agosto.</br>"+
							"La Facultad de <strong>Ingeniería de Sistemas e Informática de la Universidad Nacional de San Martin</strong>, tiene el privilegio de organizar múltiples " +
							"eventos de índole académica con el objetivo de capacitar y actualizar a nuestros estudiantes y docentes catedráticos, que son el eje motor " +
							"del desarrollo de nuestra universidad, para que esta siga siendo líder en el departamento de San Martin y una de las mejores a nivel nacional; " +
							"por tal razón asumimos el reto de desarrollar el XXI CONEISC Tarapoto 2013.</div></body></html>";
		webView  = (WebView) getView().findViewById(R.id.text_xxiconeisc);
		webView.setBackgroundColor(Color.WHITE);
		webView.setVerticalScrollBarEnabled(true);
		webView.setVerticalFadingEdgeEnabled(true);
		webView.setVerticalScrollbarOverlay(true);
		webView.loadData(webPage_es, "text/html", "UTF-8");
	
		ImageView paper = (ImageView) getView().findViewById(R.id.image_header);
		Resources res = getResources();
		Drawable drawable = res.getDrawable(R.drawable.portada);
		if(paper!=null){
		paper.setImageDrawable(drawable);
		}
		super.onActivityCreated(savedInstanceState);
	}


}