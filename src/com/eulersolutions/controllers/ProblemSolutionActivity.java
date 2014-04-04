package com.eulersolutions.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.eulersolutions.interfaces.ISelectionListener;
import com.eulersolutions.interfaces.ISolutionDisplay;
import com.eulersolutions.interfaces.ISolutionHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class ProblemSolutionActivity extends Activity implements 
	ISelectionListener, ISolutionHandler
{
	
	private static final String[] solutionTitles = {"My Solution", "Euler Solution"};
	private static final String TAG = "EulerSolution-ProblemSolutionActivity";
	
	private ISolutionDisplay solutionDisplay = null;
	private ArrayList<String> solutions = null;

	public static final String MY_SOLUTION_NAME = "mySolution";
	public static final String EULER_SOLUTION_NAME = "eulerSolution";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Entered onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_problem_solution);
		solutions = new ArrayList<String>();
		
		Intent intent = this.getIntent();
		solutions.add(intent.getStringExtra(MY_SOLUTION_NAME));
		solutions.add(intent.getStringExtra(EULER_SOLUTION_NAME));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.problem_solution, menu);
		return true;
	}

	@Override
	public void onItemSelected(int position) {
		Log.i(TAG, "Entered onItemSelected");
		if(solutionDisplay != null)
		{
			solutionDisplay.setSolution(solutions.get(position));
		}
	}

	@Override
	public List<String> getSolutionTitles() {
		return Arrays.asList(solutionTitles);
	}

	@Override
	public List<String> getSolutions() {
		return solutions;
	}

	@Override
	public int numberOfSolutions() {
		return solutions.size();
	}

	@Override
	public void setSolutionDisplay(ISolutionDisplay newDisplay) {
		solutionDisplay = newDisplay;
	}
}
