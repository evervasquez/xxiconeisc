package com.ever.conesic;

import static android.widget.Toast.LENGTH_SHORT;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Toast;

import calendario.CalendarPickerView;

import com.actionbarsherlock.app.SherlockFragment;
import utiles.fechas;

public class conferencias extends SherlockFragment {
	fechas fecha;
	private static final String TAG = "SampleTimesSquareActivity";
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getSherlockActivity().getSupportActionBar().setTitle("XXICONEISC - Conferencias");
		fecha = new fechas();
	    View root = inflater.inflate(R.layout.conferencias, container, false);
	    final CalendarPickerView calendar = (CalendarPickerView) root.findViewById(R.id.conferenciasView);
	    //Toast.makeText(getActivity(), ""+new Date(), Toast.LENGTH_LONG).show();
	    calendar.init(fecha.retornaFecha(2013,7,12), fecha.retornaFecha(2013,7,1),fecha.retornaFecha(2013,7,31));
	    root.findViewById(R.id.done_button).setOnClickListener(new OnClickListener() {
	        @Override public void onClick(View view) {
	          Log.d(TAG, "Selected time in millis: " + calendar.getSelectedDate().getTime());
	          String toast = "Selected: " + calendar.getSelectedDate().getTime();
	          Toast.makeText(getActivity(), toast, LENGTH_SHORT).show();
	        }
	      });
	    return root;
	}

}
