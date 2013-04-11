package com.ever.conesic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class eventos extends SherlockFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle saveInstanceState) {
		getSherlockActivity().getSupportActionBar().setTitle("XXICONEISC - Eventos");
		return inflater.inflate(R.layout.activity_eventos, container, false);
	}
}
