package com.eulersolutions.model;

import android.content.Intent;

public class ProblemSummary {
	private String name;
	private int id;
	private Intent problem;
	
	public ProblemSummary(int newId, String newName, Intent newProblem)
	{
		name = newName;
		id = newId;
		problem = newProblem;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public Intent getProblem()
	{
		return problem;
	}
}
