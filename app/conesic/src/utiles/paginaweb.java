package utiles;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class paginaweb {
	Intent intent;
	
	public void paginaWeb(Activity activity, String pagina) {
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri
				.parse(pagina));
		activity.startActivity(intent);
	}
}
