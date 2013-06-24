package informacion;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import com.ever.conesic.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import progress.ProgressFragment;

public class mostrar_imagenes extends ProgressFragment {
    private View mContentView;
    private String url_imagen;
    private Bitmap loadedImage;
    
    public static mostrar_imagenes newInstance() {
    	mostrar_imagenes fragment = new mostrar_imagenes();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Bundle args = getArguments();
    	if(args != null){
    		url_imagen = args.getString("url_imagen");
    	}
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.view_content, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setContentView(mContentView);
        obtainData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       // inflater.inflate(R.menu.refresh, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* switch (item.getItemId()) {
            case R.id.menu_refresh:
                obtainData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
    	return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unchecked")
	private void obtainData() {
    	AsyncTasks_imagenes tarea = new AsyncTasks_imagenes(url_imagen);
		tarea.execute();
    }
    
    @SuppressWarnings("rawtypes")
	private class AsyncTasks_imagenes extends AsyncTask {
    	private String url_image;
    	private ImageView imageView;

		public AsyncTasks_imagenes(String url) {
			this.url_image = url;
			imageView = (ImageView) getView().findViewById(R.id.image_view);
		}

		@Override
		protected Object doInBackground(Object... params) {
			// recupera la data
			URL imageUrl = null;
	        try {
	            imageUrl = new URL(this.url_image);
	            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
	            conn.connect();
	            loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
	        } catch (IOException e) {
	            Toast.makeText(getActivity(), "Error cargando la imagen: "+e.getMessage(), Toast.LENGTH_LONG).show();
	            e.printStackTrace();
	        }
			return 1;
		}

		protected void onPreExecute() {
			//inicia imagen de cargando
			setContentShown(false);
		}

		protected void onPostExecute(Object res) {
			//llenar
			setContentShown(true);
			imageView.setImageBitmap(loadedImage);
		}

	}
}
