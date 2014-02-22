package com.eulersolutions.model;

@SuppressWarnings("rawtypes")
public class ProblemSummary {
	private String name;
	private int id;
	private Class problem;
	
	public ProblemSummary(int newId, String newName, Class newProblem)
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
	
	public Class getProblem()
	{
		return problem;
	}
}
