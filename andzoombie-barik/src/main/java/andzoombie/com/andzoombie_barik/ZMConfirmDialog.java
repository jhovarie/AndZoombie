package andzoombie.com.andzoombie_barik;

/**
 * Created by jhovarie on 12/1/18.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;

public abstract class ZMConfirmDialog {
    public ZMConfirmDialog(Context context, String message, String yesoption, String nooption) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        TextView label = new TextView(context);
        label.setText(message);
        //alert.setMessage(message);
        alert.setView(label);
        alert.setPositiveButton(yesoption, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                yesoption();
            }
        });
        alert.setNegativeButton(nooption, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nooption();
            }
        });
        alert.show();
    }

    public abstract void yesoption();
    public abstract void nooption();
}
