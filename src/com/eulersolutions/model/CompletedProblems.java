package com.eulersolutions.model;

import java.util.ArrayList;

public class CompletedProblems {
	
	public static ArrayList<ProblemSummary> createCompletedProblems()
	{
		ArrayList<String> textStrings;
		ProblemCalculator calculator;
		int numberOfInputs;
		int id;
		
		ArrayList<ProblemSummary> toReturn = new ArrayList<ProblemSummary>();
		
		//add problem one
		textStrings = new ArrayList<String>();
		textStrings.add("Multiples of A and B");
		textStrings.add("Given a maximum value and two multiples (all positive),"
				+ " find the sum of the all of the multiples.");
		textStrings.add("For example, consider a max value of 17 and the multiples"
				+ " 3 and 4. The multiples of 3 and 4 less than 17 are 3, 4, 6, 8, "
				+ "9, 12, 15, and 16. Their sum is 73.");
		textStrings.add("");
		textStrings.add("First Multiple: ");
		textStrings.add("Second Multiple:");
		textStrings.add("Max Value: ");
		calculator = new MultiplesABCalculator();
		numberOfInputs = 3;
		id = 1;
		ProblemSummary newItem = new ProblemSummary(textStrings, calculator, numberOfInputs, id);
		toReturn.add(newItem);
		
		return toReturn;
	}
}
