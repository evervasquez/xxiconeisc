package informacion;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import progress.ProgressFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ever.conesic.R;

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
		if (args != null) {
			url_imagen = args.getString("url_imagen");
		}
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
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

	@SuppressWarnings("unchecked")
	private void obtainData() {
		AsyncTasks_imagenes tarea = new AsyncTasks_imagenes(url_imagen);
		tarea.execute();
	}

	@SuppressWarnings("rawtypes")
	private class AsyncTasks_imagenes extends AsyncTask {
		private String url_image;
		private ImageView imageView;
		private HttpGet request;
		private HttpResponse response;
		private static final int REGISTRATION_TIMEOUT = 3 * 1000;
		private static final int WAIT_TIMEOUT = 30 * 1000;
		private final HttpClient httpclient = new DefaultHttpClient();
		final HttpParams params = httpclient.getParams();
		private String content = null;
		private boolean error = false;

		public AsyncTasks_imagenes(String url) {
			this.url_image = url;
			imageView = (ImageView) getView().findViewById(R.id.image_view);
		}

		@Override
		protected Object doInBackground(Object... params) {

			request = new HttpGet(this.url_image);

			try {
				HttpConnectionParams.setConnectionTimeout(this.params,
						REGISTRATION_TIMEOUT);
				HttpConnectionParams.setSoTimeout(this.params, WAIT_TIMEOUT);
				ConnManagerParams.setTimeout(this.params, WAIT_TIMEOUT);

				response = httpclient.execute(request);
				StatusLine statusLine = response.getStatusLine();
				if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
					BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(
							response.getEntity());
					loadedImage = BitmapFactory.decodeStream(bufHttpEntity
							.getContent());
				} else {
					Log.w("HTTP1:", statusLine.getReasonPhrase());
					response.getEntity().getContent().close();
					throw new IOException(statusLine.getReasonPhrase());
				}

			} catch (ClientProtocolException e) {
				Log.w("HTTP2:", e);
				this.content = "verifique su conexión a internet error: "
						+ e.getMessage();
				this.error = true;
				cancel(true);
			} catch (IOException e) {
				Log.w("HTTP3:", e);
				this.content = "verifique su conexión a internet error: "
						+ e.getMessage();
				this.error = true;
				cancel(true);
			} catch (Exception e) {
				Log.w("HTTP4:", e);
				this.content = "verifique su conexión a internet error: "
						+ e.getMessage();
				this.error = true;
				cancel(true);
			} finally {

			}
			return 1;
		}

		protected void onPreExecute() {
			// inicia imagen de cargando
			try {
				setContentShown(false);
			} catch (Exception e) {
				getSherlockActivity().finish();
			}
		}

		protected void onPostExecute(Object res) {
			try {
				setContentShown(true);
				if (!error) {
					imageView.setImageBitmap(loadedImage);
				} else {
					Toast.makeText(getSherlockActivity(), "" + this.content,
							Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {

			}

		}

	}
}