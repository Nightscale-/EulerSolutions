package com.eulersolutions.controllers;

import com.eulersolutions.model.ProblemCalculator;
import com.eulersolutions.model.ProblemSummary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProblemPresentationActivity extends Activity {

	public static final String PARCEL_NAME = "problem";
	
	ProblemSummary problem;
	
	//view inputs
	EditText inputOne;
	EditText inputTwo;
	EditText inputThree;
	EditText inputFour;
	EditText inputFive;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_problem_presentation);
		Intent intent = this.getIntent();
		problem = intent.getParcelableExtra(PARCEL_NAME);
		
		//set up the view text
		this.setTitle(problem.getName());
		
		TextView toModify = (TextView) this.findViewById(R.id.problemDescriptionTextView);
		toModify.setText(problem.getDescription());
		
		toModify = (TextView) this.findViewById(R.id.problemExampleTextView);
		toModify.setText(problem.getExample());
		
		//TODO: handle the solution.
		
		//TODO: handle dynamic number of inputs
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.problem_presentation, menu);
		return true;
	}
	
	public void startCalculation (View view)
	{
		ProblemCalculator calculator = problem.getCalculator();
	}
}
