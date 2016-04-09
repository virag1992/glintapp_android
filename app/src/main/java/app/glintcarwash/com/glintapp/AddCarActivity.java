package app.glintcarwash.com.glintapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Virag kuvadia on 09-04-2016.
 */
public class AddCarActivity extends Activity {
    LinearLayout llCarColor;
    RelativeLayout imgcolor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_car);
        llCarColor = (LinearLayout) findViewById(R.id.llCarColor);
        imgcolor = (RelativeLayout) findViewById(R.id.rlColor);
        llCarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent color_picker = new Intent(getApplicationContext(), ColorPickerActivity.class);
                startActivityForResult(color_picker, 111);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111) {
            if (resultCode == RESULT_OK) {
                String col = data.getStringExtra("color");
                imgcolor.setBackgroundColor(Color.parseColor(col));
            }
        }
    }
}