package com.sourcebits.studentdatabasecrudcontentprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Update1Activity extends Activity implements OnClickListener {

	Button u_btn = (Button) findViewById(R.id.update_btn);

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update1);
		u_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		EditText etext = (EditText) findViewById(R.id.et_idnoupdate);
		Intent u_Intent = new Intent(this, Update2Activity.class);
		u_Intent.putExtra(StudentDetailsProvider.STUD_ID, etext.getText().toString());
		startActivityForResult(u_Intent, 0);

	}

	protected void onActivityResult(int requestCode, int resultCode) {

		super.onActivityResult(requestCode, resultCode, null);

		if (resultCode == RESULT_OK) {

		}
	}
}
