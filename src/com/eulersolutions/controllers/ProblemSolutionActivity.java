package com.eulersolutions.controllers;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ProblemSolutionActivity extends Activity {

	public static final String MY_SOLUTION_NAME = "mySolution";
	public static final String EULER_SOLUTION_NAME = "eulerSolution";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_problem_solution);
		
		Intent intent = this.getIntent();
		String mySolution = intent.getStringExtra(MY_SOLUTION_NAME);
		String eulerSolution = intent.getStringExtra(EULER_SOLUTION_NAME);
		setStrings(mySolution, eulerSolution);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.problem_solution, menu);
		return true;
	}
	
	private void setStrings(String solution1, String solution2)
	{
		TextView myText = (TextView) this.findViewById(R.id.problemMyProofTextView);
		TextView eulerText = (TextView) this.findViewById(R.id.problemEulerProofTextView);
		
		myText.setText(solution1);
		eulerText.setText(solution2);
	}

}
