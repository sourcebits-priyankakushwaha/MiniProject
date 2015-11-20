package com.sourcebits.studentdatabasecrudcontentprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class View1Activity extends Activity implements OnClickListener {

	Button v_btn = (Button) findViewById(R.id.fetch_btn);

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view1);

		v_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		EditText etext = (EditText) findViewById(R.id.et_idno);
		Intent vIntent = new Intent(this, View2Activity.class);
		vIntent.putExtra(StudentDetailsProvider.STUD_ID, etext.getText().toString());
		startActivityForResult(vIntent, 0);

	}

	protected void onActivityResult(int requestCode, int resultCode) {

		super.onActivityResult(requestCode, resultCode, null);

		if (resultCode == RESULT_OK) {

			Log.i("hi", "deleted");

		}
	}
}
