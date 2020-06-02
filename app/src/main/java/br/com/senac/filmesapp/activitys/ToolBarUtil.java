package br.com.senac.filmesapp.activitys;

import android.app.Activity;
import android.widget.TextView;

import br.com.senac.filmesapp.R;

public class ToolBarUtil {

    public static void setTitle(Activity activity, String titulo) {
        TextView toolBar = activity.findViewById(R.id.idTituloTop);
        toolBar.setText(titulo);
    }

    public static void setTitle(Activity activity, int resId) {
        TextView toolBar = activity.findViewById(R.id.idTituloTop);
        toolBar.setText(activity.getString(resId));
    }
}
