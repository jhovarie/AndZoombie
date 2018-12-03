package andzoombie.com.andzoombie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import andzoombie.com.andzoombie.testing.MenuTesting;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void gotoTesting(View v) {
       startActivity(new Intent(this,MenuTesting.class));
    }
}
