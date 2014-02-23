package com.eulersolutions.controllers;

import com.euler.eulersolutions.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
	
	public void startCalculation (View view)
	{
		EditText textReader;
		TextView textSolution;
		int firstMultiple = 0;
		int secondMultiple = 0;
		int maxValue = 0;
		long answer = 0;
		
		textReader = (EditText) this.findViewById(R.id.prob1FirstMultipleEditText);
		firstMultiple = Integer.parseInt(textReader.getText().toString());
		
		textReader = (EditText) this.findViewById(R.id.prob1SecondMultipleEditText);
		secondMultiple = Integer.parseInt(textReader.getText().toString());
		
		textReader = (EditText) this.findViewById(R.id.prob1MaxEditText);
		maxValue = Integer.parseInt(textReader.getText().toString());
		
		answer = calculate(firstMultiple, secondMultiple, maxValue);
		textSolution = (TextView) this.findViewById(R.id.prob1SolutionTextView);
		textSolution.setText( answer + "");
	}
	
	//No need for a model in this case because the entire solution is
	//    one straight forward formula
	public long calculate(int firstMultiple, int secondMultiple, int maxValue)
	{
		int toReturn = 0;
		
		return toReturn;
	}

}
