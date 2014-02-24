package com.eulersolutions.model;

public class MultiplesABCalculator {

	public String findAnswer(int firstMult, int secondMult, int maxValue)
	{
		long answer = 0;
		String toReturn = "";
		
		if(!validInput(firstMult, secondMult, maxValue))
		{
			return "undetermined. Invalid input detected. All inputs must be integers greater than 0.";
		}
		
		answer = calculate(firstMult, secondMult, maxValue);
		toReturn = "" + answer;
		
		return toReturn;
	}
	
	public boolean validInput(int firstMult, int secondMult, int maxValue)
	{
		if(firstMult <= 0 || secondMult <= 0 || maxValue <= 0)
		{
			return false;
		}
		return true;
	}
	
	public long calculate(int firstMult, int secondMult, int maxValue)
	{
		return 42;
	}
}
