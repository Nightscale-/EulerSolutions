package com.eulersolutions.model;

import java.util.List;

import android.os.Parcelable;

public abstract class ProblemCalculator implements Parcelable{
	
	protected abstract boolean validInput(List<Number> values);
	protected abstract Number calculate(List<Number> values);
	
	public Number findAnswer(List<Number> values){
		
		if(!validInput(values))
		{
			return null;
		}
		
		return calculate(values);
	}
}
