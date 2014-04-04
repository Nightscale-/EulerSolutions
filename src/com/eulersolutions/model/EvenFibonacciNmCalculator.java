package com.eulersolutions.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class EvenFibonacciNmCalculator extends ProblemCalculator {
	
	private static final String TAG = "EulerSolutions-EvenFibNmCalc";

	public EvenFibonacciNmCalculator()
	{
		super();
	}
	
	public EvenFibonacciNmCalculator(Parcel source)
	{
		super(source);
	}
	
	@Override
	protected boolean validInput(List<Number> values) {
		Log.i(TAG, "entered Valid Input");
		if(values == null || values.size() != 1)
		{
			return false;
		}
		
		if(values.get(0).longValue() <= 0)
		{
			return false;
		}
		return true;
	}

	@Override
	protected List<Number> parseInput(List<String> values) {
		Log.i(TAG, "entered parse input");
		ArrayList<Number> toReturn = new ArrayList<Number>();
		
		if(values.size() != 1)
		{
			return null;
		}
		
		try
		{
			toReturn.add(Long.parseLong(values.get(0)));
		}
		catch(NumberFormatException error)
		{
			return null;
		}
		
		return toReturn;
	}

	@Override
	protected Number calculate(List<Number> values) {
		Log.i(TAG, "entered Calculate");
		Long toReturn = Long.valueOf(0);
		long maxValue = (Long) values.get(0);
		long sum = 0;
		int currentFibSequence = 0;
		long currentFibNm = 0;
		
		if(maxValue == 1)
		{
			toReturn = Long.valueOf(0);
		}
		else if(maxValue <= 8)
		{
			toReturn = Long.valueOf(2);
		}
		else
		{
			currentFibNm = 2;
			sum = 0;
			currentFibSequence = 3;
			while(currentFibNm < maxValue)
			{
				sum = sum + currentFibNm;
				currentFibSequence = currentFibSequence + 3;
				currentFibNm = calculateNFibNm(currentFibSequence);
			}
			toReturn = Long.valueOf(sum);
		}
		return toReturn;
	}
	
	private long calculateNFibNm(int sequenceNm)
	{
		Log.i(TAG, "entered CalculateNFibNm");
		double firstComponent = 0;
		double secondComponent = 0;
		double tempInternal = 0;
		double constant = (1/Math.sqrt(5));
		
		tempInternal = (1 + Math.sqrt(5))/2;
		firstComponent = Math.pow(tempInternal, sequenceNm);
		
		tempInternal = (1 - Math.sqrt(5))/2;
		secondComponent = Math.pow(tempInternal, sequenceNm);
		
		return (long) ((firstComponent - secondComponent) * constant);
	}
	
	public static final Parcelable.Creator<EvenFibonacciNmCalculator> CREATOR = 
			new Parcelable.Creator<EvenFibonacciNmCalculator>() {
		public EvenFibonacciNmCalculator createFromParcel(Parcel in) {
			return new EvenFibonacciNmCalculator(in);
		}

		public EvenFibonacciNmCalculator[] newArray(int size) {
			return new EvenFibonacciNmCalculator[size];
		}
	};
}