package com.sourcebits.studentdatabasecrudcontentprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends Activity implements OnClickListener {
	
	Button bDelete = (Button) findViewById(R.id.delete_btn);
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete);
		EditText etext = (EditText) findViewById(R.id.et_idnodelete);
		String ID = etext.getText().toString();
		
		int rowDeleted = getContentResolver().delete(StudentDetailsProvider.CONTENT_URI, ID, null);
		bDelete.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent resultIntent = new Intent();
		setResult(RESULT_OK, resultIntent);
		finish();

	}

}
