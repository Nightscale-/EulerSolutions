package com.eulersolutions.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ProblemSummary implements Parcelable{
	private String mName;
	private String mDescription;
	private String mExample;
	private ProblemCalculator mCalculator;
	private int mNumberOfInputs;
	private int mId;
	
	public ProblemSummary(String name, String description, String example, ProblemCalculator calculator,
			int numberOfInputs, int id)
	{
		mName = name;
		mDescription = description;
		mExample = example;
		mCalculator = calculator;
		mNumberOfInputs = numberOfInputs;
		mId = id;
	}
	
	public ProblemSummary(Parcel source)
	{
		mName = source.readString();
		mDescription = source.readString();
		mExample = source.readString();
		mCalculator = source.readParcelable(ProblemCalculator.class.getClassLoader());
		mNumberOfInputs = source.readInt();
		mId = source.readInt();
	}
	
	public String getName()
	{
		return mName;
	}
	
	public String getDescription()
	{
		return mDescription;
	}
	
	public String getExample()
	{
		return mExample;
	}
	
	public ProblemCalculator getCalculator()
	{
		return mCalculator;
	}
	
	public int getNumberOfInputs()
	{
		return mNumberOfInputs;
	}
	
	public int getId()
	{
		return mId;
	}

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel destination, int flags) {
		
		destination.writeString(mName);
		destination.writeString(mDescription);
		destination.writeString(mExample);
		destination.writeParcelable(mCalculator, flags);
		destination.writeInt(mNumberOfInputs);
		destination.writeInt(mId);
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


