package com.eulersolutions.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class ProblemSummary implements Parcelable{
	private String name;
	private int id;
	private Intent problem;
	
	public ProblemSummary(int newId, String newName, Intent newProblem)
	{
		name = newName;
		id = newId;
		problem = newProblem;
	}
	
	public ProblemSummary(Parcel source)
	{
		//TODO: fill in after reformating the internal data.
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

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel destination, int flags) {
		//TODO: implement after updating the Summary information.
	}
	
	public static final Parcelable.Creator<ProblemSummary> CREATOR = 
			new Parcelable.Creator<ProblemSummary>() {
		public ProblemSummary createFromParcel(Parcel in) {
			return new ProblemSummary(in);
		}

		public ProblemSummary[] newArray(int size) {
			return new ProblemSummary[size];
		}
	};
}


