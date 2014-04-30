package com.eulersolutions.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class LargestPrimeFactorCalculator extends ProblemCalculator {

	private static final String TAG = "EulerSolutions-LargePrimeFactorCalc";
	
	private final int PRIME_ENTRIES = 168;
	private final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 
			43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 
			127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 
			199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 
			283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 
			383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 
			467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 
			577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 
			661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 
			769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 
			877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 
			983, 991, 997};
	
	public LargestPrimeFactorCalculator()
	{
		super();
	}
	
	public LargestPrimeFactorCalculator(Parcel source)
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
		
		if(values.get(0).longValue() <= 1)
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
		Log.i(TAG, "entered Calculations");
		long toReturn = 0;
		long value = values.get(0).longValue();
		
		toReturn = removeKnownPrimes(value);
		
		if(toReturn > PRIMES[PRIME_ENTRIES-1])
		{
			toReturn = unknownLargestPrimeSolver(toReturn);
		}
		return Long.valueOf(toReturn);
	}
	
	private long removeKnownPrimes(long value)
	{
		boolean stillPrunning = false;
		int index = 0;
		long toReturn = value;
		
		//use the theory that all numbers are composed of prime numbers
		
		for(index = 0; index < PRIME_ENTRIES && PRIMES[index] < toReturn; index++)
		{
			stillPrunning = true;
			while(stillPrunning)
			{
				if(toReturn != PRIMES[index] && toReturn % PRIMES[index] == 0)
				{
					toReturn = toReturn / PRIMES[index];
				}
				else
				{
					stillPrunning = false;
				}
			}
		}
		
		return toReturn;
	}
	
	private long unknownLargestPrimeSolver(long value)
	{
		Log.i(TAG, "entered Unknown Prime Solver");
		long toReturn = 0;
		Comparator<Long> comparer = new LargestFirstComparator();
		PriorityQueue<Long> factorSet = new PriorityQueue<Long>(10, comparer);
		long headValue = 0;
		long tempValue = 0;
		
		//using the remainder, I will brute force factor it to make a list
		//of factors. I think it should be a small list. Then, Starting at the
		//largest factor, I will factor again to prove if it is a prime or not.
		//repeat until a prime is found or the value itself is proven prime.
		
		factorSet.addAll(factor(value));
		if(factorSet.isEmpty())
		{
			toReturn = value;
		}
		else
		{
			do
			{
				headValue = factorSet.poll().longValue();
				tempValue = unknownLargestPrimeSolver(headValue);
				if(tempValue == headValue)
				{
					toReturn = headValue;
				}
			}while(toReturn == 0 && factorSet.size() > 0);
		}
		return toReturn;
	}
	
	private ArrayList<Long> factor(long value)
	{
		ArrayList<Long> toReturn = new ArrayList<Long>();
		long divisor = PRIMES[PRIME_ENTRIES-1];
		double stop = Math.sqrt(value);
		
		//using the remainder, I will brute force factor it to make a list
		//of factors. I think it should be a small list. Then, Starting at the
		//largest factor, I will factor again to prove if it is a prime or not.
		//repeat until a prime is found or the value itself is proven prime.
		
		while(divisor < stop)
		{
			if(value % divisor == 0)
			{
				toReturn.add(divisor);
				toReturn.add(value / divisor);
			}
			divisor = divisor + 2;
		}
		
		return toReturn;
	}

	public static final Parcelable.Creator<LargestPrimeFactorCalculator> CREATOR = 
			new Parcelable.Creator<LargestPrimeFactorCalculator>() {
		public LargestPrimeFactorCalculator createFromParcel(Parcel in) {
			return new LargestPrimeFactorCalculator(in);
		}

		public LargestPrimeFactorCalculator[] newArray(int size) {
			return new LargestPrimeFactorCalculator[size];
		}
	};
	
	public class LargestFirstComparator implements Comparator<Long>
	{
		@Override
		public int compare(Long lhs, Long rhs) {
			
			int toReturn = 0;
			
			if(lhs.equals(rhs))
			{
				toReturn = 0;
			}
			else if(lhs.longValue() < rhs.longValue())
			{
				toReturn = 1;
			}
			else
			{
				toReturn = -1;
			}
			return toReturn;
		}
		
	};
}
