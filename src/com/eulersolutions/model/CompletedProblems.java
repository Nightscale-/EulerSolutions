package com.eulersolutions.model;

import java.util.ArrayList;

import com.eulersolutions.controllers.MultiplesAB;

public class CompletedProblems {

	public static ArrayList<ProblemSummary> createCompletedProblems()
	{
		ArrayList<ProblemSummary> toReturn = new ArrayList<ProblemSummary>();
		
		ProblemSummary newItem = new ProblemSummary(1, "Multiples of A and B", MultiplesAB.class);
		toReturn.add(newItem);
		
		return toReturn;
	}
}
