package app.glintcarwash.com.glintapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ForgotPasswordActvity extends BaseActivity implements
		OnClickListener {

	Button btnSignin;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_forgotpassword);
		btnSignin = (Button) findViewById(R.id.btnSend);
		btnSignin.setOnClickListener(this);
		action = getActionBar();
	}

	@Override
	public void onClick(View v) {

	}
}