package com.eulersolutions.controllers;

import java.util.ArrayList;

import com.eulersolutions.model.ProblemCalculator;
import com.eulersolutions.model.ProblemSummary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProblemPresentationActivity extends Activity {

	public static final String PARCEL_NAME = "problem";
	public static final int MAX_INPUTS = 3;
	
	private static final String TAG = "EulerSolutions-ProblemPresentationActivity";
	
	private ProblemSummary problem;
	private int[] textViewInputIds;
	private int[] editTextInputIds;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Entered onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_problem_presentation);
		Intent intent = this.getIntent();
		problem = intent.getParcelableExtra(PARCEL_NAME);
		
		//setup the id arrays
		setupGuiIds();
		
		//set up the view text
		setupInputs(problem);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.problem_presentation, menu);
		return true;
	}
	
	public void startCalculation (View view)
	{
		Log.i(TAG, "Entered Start Calculation");
		boolean validGUI = true;
		String toAdd = "";
		EditText textReader;
		TextView textSolution = (TextView) this.findViewById(R.id.problemSolutionTextView);
		Number answer = Integer.valueOf(0);
		ArrayList<String> values = new ArrayList<String>();
		ProblemCalculator calculator = problem.getCalculator();
		
		for(int index = 0; index < problem.getNumberOfInputs(); index++)
		{
			textReader = (EditText) this.findViewById(editTextInputIds[index]);
			toAdd = textReader.getText().toString();
			if(toAdd.isEmpty())
			{
				validGUI = false;
				index = problem.getNumberOfInputs();
				textReader.setError("Please enter a positive number");
			}
			values.add(toAdd);
		}
		
		if(validGUI)
		{
			answer = calculator.findAnswer(values);
			if(answer == null)
			{
				textSolution.setText("Invalid");
			}
			else
			{
				textSolution.setText(answer.toString());
			}
		}
		else
		{
			textSolution.setText("Invalid");
		}
	}
	
	public void showSolution(View view)
	{
		Log.i(TAG, "Entered Show Solution");
		Intent solutionIntent = new Intent(this, ProblemSolutionActivity.class);
		
		solutionIntent.putExtra(ProblemSolutionActivity.MY_SOLUTION_NAME, problem.getSolution());
		solutionIntent.putExtra(ProblemSolutionActivity.EULER_SOLUTION_NAME, problem.getEulerSolution());
		
		this.startActivity(solutionIntent);
	}
	
	private void setupGuiIds()
	{
		Log.i(TAG, "Entered Gui ID Setup");
		textViewInputIds = new int[MAX_INPUTS];
		editTextInputIds = new int[MAX_INPUTS];
		
		textViewInputIds[0] = R.id.problemInputOneDescription;
		textViewInputIds[1] = R.id.problemInputTwoDescription;
		textViewInputIds[2] = R.id.problemInputThreeDescription;
		
		editTextInputIds[0] = R.id.problemInputOneEditText;
		editTextInputIds[1] = R.id.problemInputTwoEditText;
		editTextInputIds[2] = R.id.problemInputThreeEditText;
	}
	
	private void setupInputs(ProblemSummary newProblem)
	{
		Log.i(TAG, "Entered Input Setup");
		TextView toModifyText;
		EditText toModifyInput;
		ArrayList<String> inputStrings = newProblem.getInputStrings();
		
		this.setTitle(newProblem.getName());
		
		toModifyText = (TextView) this.findViewById(R.id.problemDescriptionTextView);
		toModifyText.setText(newProblem.getDescription());
		
		toModifyText = (TextView) this.findViewById(R.id.problemExampleTextView);
		toModifyText.setText(newProblem.getExample());
		
		for(int index = 0; index < MAX_INPUTS; index++)
		{
			toModifyText = (TextView) this.findViewById(textViewInputIds[index]);
			toModifyInput = (EditText) this.findViewById(editTextInputIds[index]);
			
			if(index < newProblem.getNumberOfInputs())
			{
				toModifyText.setText(inputStrings.get(index));
			}
			else
			{
				toModifyText.setVisibility(View.GONE);
				toModifyInput.setVisibility(View.GONE);
			}
		}
	}
}
