package com.eulersolutions.model;

import java.util.ArrayList;

import android.util.Log;

public class CompletedProblems {
	
	private static final String TAG = "EulerSolutions-CompletedProblems";
	
	public static ArrayList<ProblemSummary> createCompletedProblems()
	{
		Log.i(TAG, "Entered createCompletedProblems");
		String name;
		String description;
		String example;
		String solution;
		String eulerSolution;
		ArrayList<String> inputStrings;
		ProblemCalculator calculator;
		ProblemSummary newItem;
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
		newItem = new ProblemSummary(name, description, example,
				solution, eulerSolution, inputStrings, calculator, inputStrings.size(), id);
		toReturn.add(newItem);
		
		//add problem two
		inputStrings = new ArrayList<String>();
		name = "Even Fibonnaci Numbers";
		description = "Given a maximum value, find the sum of all of the even "
				+ "Fibonnaci numbers less than that value";
		example = "For example, consider a max value of 9. The Fibonnaci numbers"
				+ " less than 9 are 1, 2, 3, 5, 8. Summing the even numbers, "
				+ "we get 8 + 2 = 10.";
		solution = "We can prove that starting at the second number, ever third term afterwards is even."
				+ " Then we use Binet's formula for finding the nth Fibonnaci value and sum the values.";
		eulerSolution = "Not sure if my solution matched Euler's yet";
		inputStrings.add("Maximum Value: ");
		calculator = new EvenFibonacciNmCalculator();
		id = 2;
		newItem = new ProblemSummary(name, description, example,
				solution, eulerSolution, inputStrings, calculator, inputStrings.size(), id);
		toReturn.add(newItem);
		
		return toReturn;
	}
}
