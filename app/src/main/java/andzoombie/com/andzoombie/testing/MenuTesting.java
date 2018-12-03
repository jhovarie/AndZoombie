package andzoombie.com.andzoombie.testing;

import android.app.ListActivity;

/**
 * Created by jhovarie.guiang on 12/3/2018.
 */

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import andzoombie.com.andzoombie.R;

public class MenuTesting extends ListActivity{
    static final String[] Food = new String[]{
            "Ice Cream","Bacon","Cheese","Sandwich","Ice Cream","Bacon","Cheese","Sandwich",
            "Ice Cream","Bacon","Cheese","Sandwich","Ice Cream","Bacon","Cheese","Sandwich"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.single_item, Food));
        ListView list = getListView();
        list.setTextFilterEnabled(true);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
