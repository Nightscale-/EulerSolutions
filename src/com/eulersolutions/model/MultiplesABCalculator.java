package com.eulersolutions.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class MultiplesABCalculator extends ProblemCalculator{
	
	public MultiplesABCalculator()
	{
		super();
	}
	
	public MultiplesABCalculator(Parcel source)
	{
		super(source);
	}
	
	protected boolean validInput(List<Number> values)
	{
		if(values.size() != 3)
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
		int firstMult = values.get(0).intValue();
		int secondMult = values.get(1).intValue();
		int maxValue = values.get(2).intValue();
		
		long firstSum = 0;
		long secondSum = 0;
		long duplicateSum = 0;

		firstSum = generateSum(firstMult, maxValue);
		secondSum = generateSum(secondMult, maxValue);
		
		//There is duplication where both multiples match.
		duplicateSum = generateSum(firstMult * secondMult, maxValue);
		
		return firstSum + secondSum - duplicateSum;
	}
	
	protected long generateSum(int multiple, int maxValue)
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
