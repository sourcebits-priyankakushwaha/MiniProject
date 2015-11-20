package com.sourcebits.studentdatabasecrudcontentprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Update2Activity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update2);
		ContentValues values = new ContentValues();

		values.put(StudentDetailsProvider.STUD_ID, ((EditText) findViewById(R.id.et1)).getText().toString());
		values.put(StudentDetailsProvider.STUD_NAME, ((EditText) findViewById(R.id.et2)).getText().toString());
		values.put(StudentDetailsProvider.MATHS_MARKS, ((EditText) findViewById(R.id.et3)).getText().toString());
		values.put(StudentDetailsProvider.ENGLISH_MARKS, ((EditText) findViewById(R.id.et4)).getText().toString());
		values.put(StudentDetailsProvider.SCIENCE_MARKS, ((EditText) findViewById(R.id.et5)).getText().toString());
		values.put(StudentDetailsProvider.HISTORY_MARKS, ((EditText) findViewById(R.id.et6)).getText().toString());
		values.put(StudentDetailsProvider.SOCIAL_SCIENCE_MARKS,
				((EditText) findViewById(R.id.et6)).getText().toString());

		int uri = getContentResolver().update(StudentDetailsProvider.CONTENT_URI, values, null, null);

		Intent resultIntent = new Intent();
		setResult(RESULT_OK, resultIntent);
		finish();
	}
}
