package com.eulersolutions.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class ProblemSolutionActivity extends Activity implements 
	ISelectionListener, ISolutionHandler
{

	public static final String MY_SOLUTION_NAME = "mySolution";
	public static final String EULER_SOLUTION_NAME = "eulerSolution";
	
	private static final String[] solutionTitles = {"My Solution", "Euler Solution"};
	
	private ISolutionDisplay solutionDisplay = null;
	private ArrayList<String> solutions = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
