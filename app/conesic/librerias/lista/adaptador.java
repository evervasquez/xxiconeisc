package lista;

import java.util.ArrayList;
import java.util.List;
import lista.datos;
import com.ever.conesic.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class adaptador extends BaseAdapter {
	Context context;
	/**
	 * 
	 */
	datos[] da;
	private LayoutInflater li;
	private List<datos> datos = new ArrayList<datos>();

	public adaptador(Context context, List<datos> items) {
		this.context = context;
		li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		datos = items;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	public Object getItem(int location) {
		return datos.get(location);
	}

	public long getItemId(int location) {
		return location;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;
		final datos user = datos.get(position);
		if (v == null) {
			v = li.inflate(R.layout.lista_row, null);
		}
		final ImageView mLogo = (ImageView) v.findViewById(R.id.list_image);
		mLogo.setImageResource(user.getimagenes());

		final TextView nameTv = (TextView) v.findViewById(R.id.curso);
		nameTv.setText(user.getdatos());

		final TextView genderTv = (TextView) v.findViewById(R.id.docente);
		genderTv.setText(user.getsubdatos());

		return v;

	}
}
