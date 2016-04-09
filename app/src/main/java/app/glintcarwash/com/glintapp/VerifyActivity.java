package app.glintcarwash.com.glintapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class VerifyActivity extends BaseActivity implements OnClickListener {

	Button btnSignin;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_verify);
		btnSignin = (Button) findViewById(R.id.btnVerify);
		btnSignin.setOnClickListener(this);
		action = getActionBar();
	}

	@Override
	public void onClick(View v) {
		if(v==btnSignin){
			Intent i = new Intent(VerifyActivity.this,
					MainActivity.class);
			startActivity(i);
		}

	}
}