package com.eulersolutions.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MultiplesABCalculator extends ProblemCalculator{
	
	private static final String TAG = "EulerSolutions-MultABCalc";
	
	public MultiplesABCalculator()
	{
		super();
	}
	
	public MultiplesABCalculator(Parcel source)
	{
		super(source);
	}
	
	protected List<Number> parseInput(List<String> values)
	{
		Log.i(TAG, "entered Parse Input");
		ArrayList<Number> toReturn = new ArrayList<Number>();
		if(values.size() != 3)
		{
			return null;
		}
		try
		{
			toReturn.add(Integer.parseInt(values.get(0)));
			toReturn.add(Integer.parseInt(values.get(1)));
			toReturn.add(Integer.parseInt(values.get(2)));
		}
		catch(NumberFormatException error)
		{
			return null;
		}
		return toReturn;
	}
	
	protected boolean validInput(List<Number> values)
	{
		Log.i(TAG, "entered Valid Input");
		if(values == null || values.size() != 3)
		{
			return false;
		}
		
		if(values.get(0).intValue() <= 0 || values.get(1).intValue() <= 0
				|| values.get(2).intValue() <= 0)
		{
			return false;
		}
		return true;
	}
	
	protected Number calculate(List<Number> values)
	{
		Log.i(TAG, "entereing Calculate");
		int firstMult = values.get(0).intValue();
		int secondMult = values.get(1).intValue();
		int maxValue = values.get(2).intValue();
		
		long firstSum = 0;
		long secondSum = 0;
		long duplicateSum = 0;

		if(firstMult > secondMult)
		{
			int temp = firstMult;
			firstMult = secondMult;
			secondMult = temp;
		}
		firstSum = generateSum(firstMult, maxValue);
		if(!sameMultiples(firstMult, secondMult))
		{
			secondSum = generateSum(secondMult, maxValue);
			
			//There is duplication where both multiples match.
			duplicateSum = generateSum(firstMult * secondMult, maxValue);
		}
		return firstSum + secondSum - duplicateSum;
	}
	
	protected long generateSum(int multiple, int maxValue)
	{
		Log.i(TAG, "entering Generate Sum");
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
	
	protected boolean sameMultiples(int first, int second)
	{
		Log.i(TAG, "entering Same Multiples");
		if(first <= second)
		{
			if(second % first == 0)
			{
				return true;
			}
		}
		else
		{
			if(first % second == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public static final Parcelable.Creator<MultiplesABCalculator> CREATOR = 
			new Parcelable.Creator<MultiplesABCalculator>() {
		public MultiplesABCalculator createFromParcel(Parcel in) {
			return new MultiplesABCalculator(in);
		}

		public MultiplesABCalculator[] newArray(int size) {
			return new MultiplesABCalculator[size];
		}
	};
}
