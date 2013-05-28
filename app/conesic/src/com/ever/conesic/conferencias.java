package com.ever.conesic;

import br.com.dina.ui.model.BasicItem;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import br.com.dina.ui.widget.UIButton;
import br.com.dina.ui.widget.UITableView;
import calendario.CalendarPickerView;

import com.actionbarsherlock.app.SherlockFragment;

import utiles.fechas;
import utiles.fonts;

public class conferencias extends SherlockFragment {
	fechas fecha;
	Point p;
	UITableView tableView;
	String[] titulos, subtitulos;
	int largo;
	int ancho;
	private static final String TAG = "SampleTimesSquareActivity";

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getActivity().setRequestedOrientation(
				ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		fecha = new fechas();
		View root = inflater.inflate(R.layout.conferencias, container, false);
		final CalendarPickerView calendar = (CalendarPickerView) root.findViewById(R.id.conferenciasView);

		calendar.init(fecha.retornaFecha(2013, 7, 12),
				fecha.retornaFecha(2013, 7, 1), fecha.retornaFecha(2013, 7, 31));
		root.findViewById(R.id.done_button).setOnClickListener(
				new OnClickListener() {
					@SuppressWarnings("deprecation")
					@Override
					public void onClick(View view) {
						Log.d(TAG, "Selected time in millis: "
								+ calendar.getSelectedDate().getTime());

						switch (calendar.getSelectedDate().getDate()) {
						case 12:
							titulos = new String[] { "Programación",
									"Entrega de Materiales",
									"Inauguración XXICONEISC",
									"Conferencia Internacional 1",
									"Noches de Confraternidad" };
							subtitulos = new String[] { "Lunes 12 de Agosto",
									"8am - 3pm", "4pm - 5pm", "6pm - 7p,",
									"9pm+" };
							showPopup(getActivity(), p, titulos, subtitulos);
							break;
						case 13:
							titulos = new String[] { "Programación",
									"Conferencia Nacional 1",
									"Conferencia Internacional 2",
									"Feria Tegnológica",
									"Concurso de Proy. Cientifico",
									"Conferencia Nacional 2",
									"Conferencia Internacional 3",
									"Noches de Confraternidad" };
							subtitulos = new String[] { "Martes 13 de Agosto",
									"8am - 9am", "10am - 11am", "12am - 1pm",
									"2pm - 3pm", "4pm - 5pm", "6pm - 7pm",
									"9pm+" };
							showPopup(getActivity(), p, titulos, subtitulos);
							break;
						case 14:
							titulos = new String[] { "Programación",
									"Conferencia Nacional 3",
									"Conferencia Internacional 4",
									"Feria Tegnológica",
									"Concurso de Proy. Cientifico",
									"Conferencia Internacional 5",
									"Conferencia Internacional 6",
									"Noches de Confraternidad" };
							subtitulos = new String[] {
									"Miercoles 14 de Agosto", "8am - 9am",
									"10am - 11am", "12am - 1pm", "2pm - 3pm",
									"4pm - 5pm", "6pm - 7pm", "9pm+" };
							showPopup(getActivity(), p, titulos, subtitulos);
							break;
						case 15:
							titulos = new String[] { "Programación",
									"Conferencia Nacional 4",
									"Conferencia Internacional 7",
									"Feria Tegnológica",
									"Concurso de Proy. Cientifico",
									"Conferencia Nacional 5",
									"Conferencia Internacional 8",
									"Noches de Confraternidad" };
							subtitulos = new String[] { "Jueves 15 de Agosto",
									"8am - 9am", "10am - 11am", "12am - 1pm",
									"2pm - 3pm", "4pm - 5pm", "6pm - 7pm",
									"9pm+" };
							showPopup(getActivity(), p, titulos, subtitulos);
							break;
						case 16:
							titulos = new String[] { "Programación",
									"Conferencia Nacional 6",
									"Conferencia Internacional 9",
									"Feria Tegnológica",
									"Concurso de Proy. Cientifico",
									"Conferencia Nacional 7",
									"Conferencia Internacional 10",
									"Clausura - Fiesta de Gala" };
							subtitulos = new String[] { "Viernes 16 de Agosto",
									"8am - 9am", "10am - 11am", "12am - 1pm",
									"2pm - 3pm", "4pm - 5pm", "6pm - 7pm",
									"9pm+" };
							showPopup(getActivity(), p, titulos, subtitulos);
							break;
						case 17:
							titulos = new String[] { "Programación",
									"MegaTours" };
							subtitulos = new String[] { "Sabado 17 de Agosto",
									"Todo el día" };
							showPopup(getActivity(), p, titulos, subtitulos);
							break;
						default:
							break;
						}
					}
				});
		fonts.cambiarfont(getActivity(), root, R.id.conf,
				"fonts/ArtistMedium.ttf");
		
		//obtenemos medidas de la pantalla en pixeles
		Display display = getActivity().getWindowManager().getDefaultDisplay();
		largo = display.getWidth();
		ancho = display.getHeight();
		

		return root;
	}

	// The method that displays the popup.
	@SuppressWarnings("deprecation")
	private void showPopup(final Activity context, Point p, String[] titulos,
			String[] subtitulos) {

		int[] location = new int[2];
		// Button button = (Button) findViewById(R.id.show_popup);

		// Get the x, y location and store it in the location[] array
		// location[0] = x, location[1] = y.
		// button.getLocationOnScreen(location);

		// Initialize the Point with x, and y positions
		p = new Point();
		p.x = location[0];
		p.y = location[1];
		
		int popupWidth = largo;
		int popupHeight = ancho;

		Toast.makeText(getSherlockActivity(), "el largo es " + popupWidth, Toast.LENGTH_SHORT).show();
		// Inflate the popup_layout.xml
		LinearLayout viewGroup = (LinearLayout) context
				.findViewById(R.id.popup);
		LayoutInflater layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = layoutInflater.inflate(R.layout.info, viewGroup);

		// Creating the PopupWindow
		final PopupWindow popup = new PopupWindow(context);
		popup.setContentView(layout);
		popup.setWidth(popupWidth);
		popup.setHeight(popupHeight);
		popup.setFocusable(true);

		// Some offset to align the popup a bit to the right, and a bit down,
		// relative to button's position. "fonts/ArtistMedium.ttf"
		int OFFSET_X = 21;
		int OFFSET_Y = 60;

		// Clear the default translucent background
		popup.setBackgroundDrawable(new BitmapDrawable());

		// Displaying the popup at the specified location, + offsets.
		popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y
				+ OFFSET_Y);

		tableView = (UITableView) layout.findViewById(R.id.tablapopup);
		for (int i = 0; i <= this.titulos.length - 1; i++) {
			if (i == 0) {
				UIButton.setTitle(this.titulos[i]);
				UIButton.setSubTitle(this.subtitulos[i]);
			} else {
				// Toast.makeText(getActivity(),
				// ""+this.titulos.length,Toast.LENGTH_SHORT).show();
				tableView.addBasicItem(new BasicItem(this.titulos[i],
						this.subtitulos[i], false));
			}
		}
		tableView.commit();

	}

}