package com.eulersolutions.controllers;

import com.eulersolutions.controllers.R;
import com.eulersolutions.model.MultiplesABCalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MultiplesAB extends Activity {

	MultiplesABCalculator calculator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiples_ab);
		calculator = new MultiplesABCalculator();
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
		String output = "0";
		
		textReader = (EditText) this.findViewById(R.id.prob1FirstMultipleEditText);
		firstMultiple = Integer.parseInt(textReader.getText().toString());
		
		textReader = (EditText) this.findViewById(R.id.prob1SecondMultipleEditText);
		secondMultiple = Integer.parseInt(textReader.getText().toString());
		
		textReader = (EditText) this.findViewById(R.id.prob1MaxEditText);
		maxValue = Integer.parseInt(textReader.getText().toString());
		
		output = calculator.findAnswer(firstMultiple, secondMultiple, maxValue);
		textSolution = (TextView) this.findViewById(R.id.prob1SolutionTextView);
		textSolution.setText(output);
	}
}
