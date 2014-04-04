package com.eulersolutions.model;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

@SuppressLint("ParcelCreator")
public abstract class ProblemCalculator implements Parcelable{
	
	private static final String TAG = "EulerSolutions-ProblemCalculator";
	
	protected abstract boolean validInput(List<Number> values);
	protected abstract List<Number> parseInput(List<String> values);
	protected abstract Number calculate(List<Number> values);
	
	public ProblemCalculator()
	{
	}
	
	public ProblemCalculator(Parcel source)
	{
	}
	
	public Number findAnswer(List<String> inputValues){
		
		Log.i(TAG, "entering Find Answer");
		List<Number> values = parseInput(inputValues);
		
		if(!validInput(values))
		{
			return null;
		}
		
		return calculate(values);
	}
	
	@Override
	public int describeContents() {
		return this.hashCode();
	}
	
	@Override
	public void writeToParcel(Parcel destination, int flags) {
		
	}
}
