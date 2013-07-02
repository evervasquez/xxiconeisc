package com.ever.conesic;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragment;

public class conocenos extends SherlockFragment {
	@SuppressLint("InlinedApi")
	WebView webView;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.activity_xxiconeisc, container, false);
		return root;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		String webPage_es ="<html><head><meta charset=utf-8><style type='text/css'>"+
						   "body {padding: 4px ;font-size: 15px }</style></head><body><div style=text-align:justify><h3>XXI CONEISC TARAPOTO 2013</h3> El Vig�simo Primer " +
						   "Congreso Nacional de Estudiantes de Ingenier�a de Sistemas y Computaci�n en este a�o 2013 ser� organizado por la Facultad de Ingener�a " +
						   "de Sistemas e Inform�tica de la Universidad Nacional de San Martin - Tarapoto desde el 12 al 17 de Agosto.</br>"+
						   "<h3>EVENTOS</h3>El XXI CONEISC TARAPOTO 2013 ser� un evento muy enriquecedor para cada uno de los participantes, " +
						   "brindando los informaci�n de los �ltimos avances en la computaci�n y sistemas, adem�s integrando y confraternizando " +
						   "a los participantes.</br>Dentro de los eventos principales se encuentran las conferencias magistrales a cargo de " +
						   "reconocidos ponentes; talleres, minicursos, concurso de programaci�n, concurso de proyectos cient�ficos e innovadores, " +
						   "feria tecnol�gica, feria gastron�mica y artesanal; as� como eventos culturales y deportivos.</br><h3>TARAPOTO</h3>Tarapoto es una hermosa " +
						   "ciudad de la Amazon�a peruana, las v�as de acceso son diversas y accesibles. As� como por medio de las L�neas A�reas STAR PER�, LAN Per�, " +
						   "Taca Per�; terrestre como: M�vil Tours, Cial, Civa, Sol Peruano, GH BUSS entre otros, tambi�n se puede tomar el transporte fluvial para los " +
						   "visitantes del departamento Loreto.</div></body></html>";
		webView  = (WebView) getView().findViewById(R.id.text_xxiconeisc);
		webView.setBackgroundColor(Color.WHITE);
		webView.setVerticalScrollBarEnabled(true);
		webView.setVerticalFadingEdgeEnabled(true);
		webView.setVerticalScrollbarOverlay(true);
		webView.loadDataWithBaseURL(null,webPage_es, "text/html", "UTF-8",null);
	
		ImageView paper = (ImageView) getView().findViewById(R.id.image_header);
		Resources res = getResources();
		Drawable drawable = res.getDrawable(R.drawable.tarapoto);
		if(paper!=null){
		paper.setImageDrawable(drawable);
		}
		super.onActivityCreated(savedInstanceState);
	}


}