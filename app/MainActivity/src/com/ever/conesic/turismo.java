package com.ever.conesic;
import com.ever.conesic.R;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ImageneGrid.StaggeredGridView;

import com.actionbarsherlock.app.SherlockFragment;

import adaptadores.StaggeredAdapter;

public class turismo extends SherlockFragment {
	@SuppressLint("InlinedApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
		View root = inflater.inflate(R.layout.turismo, container, false);
		String urls[] = { 
				"http://tarapotoventas.tk/descargas/imagenes/947324_171307729703092_62822340_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/13403_158174847683047_194121923_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/163591_155539917946540_1436521862_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/1764_171307869703078_2101888028_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/270140_171308396369692_5635780_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/321531_158175431016322_1011966733_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/382060_158559150977950_1693927373_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/389188_171310469702818_2090496589_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/431811_171305033036695_1505212896_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/44861_158173724349826_1430640036_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/532935_158175274349671_1845066702_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/536231_155540181279847_395350455_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/540752_155540111279854_740696340_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/547587_155540204613178_19777166_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/563626_155539571279908_595395162_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/580588_171305339703331_1152477549_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/600583_171304763036722_1458490274_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/600934_171308223036376_879035819_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/604122_155539891279876_1396135620_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/604158_155540147946517_2000273575_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/61943_158174974349701_274678002_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/934916_171305429703322_2026056933_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/935395_158175621016303_437102182_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/941707_171304956370036_452347033_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/945690_161431000690765_1025852949_n%20(1).jpg",
				"http://tarapotoventas.tk/descargas/imagenes/946571_171308453036353_56462876_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/954679_171310043036194_554263361_n.jpg",
				"http://tarapotoventas.tk/descargas/imagenes/969290_171305223036676_2018680480_n.jpg"
		};
		StaggeredGridView gridView = (StaggeredGridView) root.findViewById(R.id.staggeredGridView1);
		int margin = root.getResources().getDimensionPixelSize(R.dimen.margin);
		gridView.setItemMargin(margin);
		gridView.setPadding(margin, 0, margin, 0);
		StaggeredAdapter adapter = new StaggeredAdapter(getActivity(), R.id.imageView1, urls);
		gridView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		return root;
	}
	
}
