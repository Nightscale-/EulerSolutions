package com.eulersolutions.model;

import java.util.ArrayList;

public class CompletedProblems {
	
	public static ArrayList<ProblemSummary> createCompletedProblems()
	{
		String name;
		String description;
		String example;
		String solution;
		String eulerSolution;
		ArrayList<String> inputStrings;
		ProblemCalculator calculator;
		int id;
		
		ArrayList<ProblemSummary> toReturn = new ArrayList<ProblemSummary>();
		
		//add problem one
		inputStrings = new ArrayList<String>();
		name = "Multiples of A and B";
		description = "Given a maximum value and two multiples (all positive),"
				+ " find the sum of the all of the multiples.";
		example = "For example, consider a max value of 17 and the multiples"
				+ " 3 and 4. The multiples of 3 and 4 less than 17 are 3, 4, 6, 8, "
				+ "9, 12, 15, and 16. Their sum is 73.";
		solution = "Using modulus division, we can find the greatest number that divides and move from there.";
		eulerSolution = "My solution matched the Euler Solution";
		inputStrings.add("First Multiple: ");
		inputStrings.add("Second Multiple:");
		inputStrings.add("Max Value: ");
		calculator = new MultiplesABCalculator();
		id = 1;
		ProblemSummary newItem = new ProblemSummary(name, description, example,
				solution, eulerSolution, inputStrings, calculator, inputStrings.size(), id);
		toReturn.add(newItem);
		
		return toReturn;
	}
}
