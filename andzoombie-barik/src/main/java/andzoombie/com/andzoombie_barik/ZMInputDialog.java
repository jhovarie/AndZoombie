package andzoombie.com.andzoombie_barik;

/**
 * Created by jhovarie on 12/1/18.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

public abstract class ZMInputDialog {
    public ZMInputDialog(Context context,String title,String message,String yesoption, String nooption) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        final EditText edittext = new EditText(context);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setView(edittext);
        alert.setPositiveButton(yesoption, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                final String YouEditTextValue = edittext.getText().toString().trim();
                yesoption(YouEditTextValue);
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

    public ZMInputDialog(Context context,String message,String yesoption, String nooption) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        final EditText edittext = new EditText(context);
        alert.setMessage(message);
        alert.setView(edittext);
        alert.setPositiveButton(yesoption, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                final String YouEditTextValue = edittext.getText().toString().trim();
                yesoption(YouEditTextValue);
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

    public abstract void yesoption(String strinput);
    public abstract void nooption();
}
