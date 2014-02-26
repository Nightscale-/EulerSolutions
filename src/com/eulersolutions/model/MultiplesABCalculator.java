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
		long firstSum = 0;
		long secondSum = 0;
		long duplicateSum = 0;

		firstSum = generateSum(firstMult, maxValue);
		secondSum = generateSum(secondMult, maxValue);
		
		//There is duplication where both multiples match.
		duplicateSum = generateSum(firstMult * secondMult, maxValue);
		
		return firstSum + secondSum - duplicateSum;
	}
	
	public long generateSum(int multiple, int maxValue)
	{
		long numOfValues = 0;
		long maxNm = 0;
		
		//find the largest evenly divisible value less than the max value. For 
		//   example, if multiple = 3 and maxValue = 1000, the largest value
		//   is 999, which is 3 * 333.
		maxNm = (maxValue - 1) / multiple;
		
		//Now we find the number of multiples less than the max value. Since
		//   we know 999 is the largest value divisible by 3 less than the max
		//   value, we know all the other multiples will be built with less 3's,
		//   i.e. 332*3, 331 * 3, etc. So Sum the values from 1 to 333 to find the
		//   total number of 3's less than the max value.
		numOfValues = (maxNm * (maxNm + 1))/2;
		
		//multiple by the multiple to get the sum of all the multiples. For
		//   example, 3 * the total number of 3's of the multiples less than the
		//   max value.
		return numOfValues * multiple;
	}
}
