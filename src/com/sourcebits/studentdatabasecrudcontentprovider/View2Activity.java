package com.sourcebits.studentdatabasecrudcontentprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class View2Activity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view2);
		Intent resultIntent = new Intent();
		setResult(RESULT_OK, resultIntent);
		finish();
	}

}
