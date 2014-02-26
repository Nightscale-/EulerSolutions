package com.eulersolutions.model;

import java.util.List;

public abstract class ProblemCalculator {
	
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
