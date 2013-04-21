package com.ever.conesic;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.webkit.WebView;
//import android.widget.LinearLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class Xxiconeisc extends SherlockFragment {
	//private WebView view;
	@SuppressLint("InlinedApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
		getSherlockActivity().getSupportActionBar().setTitle("XXICONEISC");
		//view = new WebView(getSherlockActivity());
		View root = inflater.inflate(R.layout.activity_xxiconeisc, container, false);
		//((LinearLayout)root.findViewById(R.id.LblEtiqueta)).addView(view);
		//view.loadData(getString(R.string.data), "text/html", "utf-8");
		//fonts.cambiarfont(getSherlockActivity(),root, R.id.LblEtiqueta, "fonts/calibri.ttf");
		return root;
	}
	
}