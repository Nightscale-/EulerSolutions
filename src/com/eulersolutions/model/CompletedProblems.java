package com.eulersolutions.model;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;

import com.eulersolutions.controllers.MultiplesAB;

public class CompletedProblems {

	private Context parentContext;
	
	public CompletedProblems(Context newContext)
	{
		parentContext = newContext;
	}
	public ArrayList<ProblemSummary> createCompletedProblems()
	{
		ArrayList<ProblemSummary> toReturn = new ArrayList<ProblemSummary>();
		
		Intent newIntent = new Intent(parentContext, MultiplesAB.class);
		ProblemSummary newItem = new ProblemSummary(1, "Multiples of A and B", newIntent);
		toReturn.add(newItem);
		
		return toReturn;
	}
}
