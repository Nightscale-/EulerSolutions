package com.eulersolutions.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class ProblemCalculator implements Parcelable{
	
	protected abstract boolean validInput(List<Number> values);
	protected abstract Number calculate(List<Number> values);
	
	public ProblemCalculator(Parcel source)
	{
	}
	
	public Number findAnswer(List<Number> values){
		
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
