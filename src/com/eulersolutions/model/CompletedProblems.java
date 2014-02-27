package com.eulersolutions.model;

import java.util.ArrayList;

public class CompletedProblems {
	
	public CompletedProblems()
	{
	}
	
	public ArrayList<ProblemSummary> createCompletedProblems()
	{
		String name;
		String description;
		String example;
		String solution;
		ProblemCalculator calculator;
		int numberOfInputs;
		int id;
		
		ArrayList<ProblemSummary> toReturn = new ArrayList<ProblemSummary>();
		
		name = "Multiples of A and B";
		description = "Given a maximum value and two multiples (all positive), find the sum of the all of the multiples.";
		example = "For example, consider a max value of 17 and the multiples 3 and 4. The multiples of 3 and 4 less than 17 are 3, 4, 6, 8, 9, 12, 15, and 16. Their sum is 73.";
		solution = "";
		calculator = new MultiplesABCalculator();
		numberOfInputs = 3;
		id = 1;
		ProblemSummary newItem = new ProblemSummary(name, description, example, solution, calculator, numberOfInputs, id);
		toReturn.add(newItem);
		
		return toReturn;
	}
}
