package com.sourcebits.studentdatabasecrudcontentprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button bAdd = (Button) findViewById(R.id.btn_add);
	Button bDelete = (Button) findViewById(R.id.btn_delete);
	Button bUpdate = (Button) findViewById(R.id.btn_update);
	Button bView = (Button) findViewById(R.id.btn_view);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bAdd.setOnClickListener(this);
		bDelete.setOnClickListener(this);
		bUpdate.setOnClickListener(this);
		bView.setOnClickListener(this);
	}

	public void onClick(View view) {
		if (view == bAdd) {

			Intent addIntent = new Intent(this, AddActivity.class);
			startActivityForResult(addIntent, 0);

		}

		if (view == bDelete) {
			Intent deleteIntent = new Intent(this, DeleteActivity.class);
			startActivityForResult(deleteIntent, 1);
		}
		if (view == bUpdate) {
			Intent updateIntent = new Intent(this, Update1Activity.class);
			startActivityForResult(updateIntent, 2);

		}
		if (view == bView) {
			Intent viewIntent = new Intent(this, View1Activity.class);
			startActivityForResult(viewIntent, 3);

		}

	}

	protected void onActivityResult(int requestCode, int resultCode) {

		super.onActivityResult(requestCode, resultCode, null);
		if (requestCode == 0) {

			if (resultCode == RESULT_OK) {

				Log.i("hi", "hello");

			}

		} else if (requestCode == 1) {
			if (resultCode == RESULT_OK) {

				Toast.makeText(MainActivity.this, null, Toast.LENGTH_LONG).show();
			}

		} else if (requestCode == 2) {
			if (resultCode == RESULT_OK) {

			}

		} else if (requestCode == 3) {
			if (resultCode == RESULT_OK) {

			}

		}

	}

}

/*
 * bAdd.setOnClickListener(new OnClickListener() {
 * 
 * public void onClick(View v) { // go to new activity Intent addIntent = new
 * Intent(this, AddActivity.class); } });
 * 
 * bDelete.setOnClickListener(new OnClickListener() {
 * 
 * public void onClick(View v) { // go to new activity Intent deleteIntent = new
 * Intent(getBaseContext(),DeleteActivity.class);
 * 
 * startActivity(deleteIntent ); } }); bView.setOnClickListener(new
 * OnClickListener() {
 * 
 * public void onClick(View v) { // go to new activity Intent viewIntent = new
 * Intent(getBaseContext(),View1Activity.class);
 * 
 * startActivity(viewIntent); } }); bAdd.setOnClickListener(new
 * OnClickListener() {
 * 
 * public void onClick(View v) { // go to new activity Intent updateIntent = new
 * Intent(getBaseContext(),Update1Activity.class);
 * 
 * startActivity( updateIntent); } });
 * 
 * }
 */
