package com.eulersolutions.controllers;

import com.euler.eulersolutions.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MultiplesAB extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiples_ab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.multiples_ab, menu);
		return true;
	}

}
