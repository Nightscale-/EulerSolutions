package com.eulersolutions.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class ProblemSummary implements Parcelable{
	
	public final static int NAME_INDEX = 0;
	public final static int DESCRIPTION_INDEX = 1;
	public final static int EXAMPLE_INDEX = 2;
	public final static int SOLUTION_INDEX = 3;
	public final static int FIRST_INPUT_INDEX = 4;
	
	private ArrayList<String> mTextStrings;
	private ProblemCalculator mCalculator;
	private int mNumberOfInputs;
	private int mId;
	
	public ProblemSummary(ArrayList<String>textStrings, ProblemCalculator calculator,
			int numberOfInputs, int id)
	{
		if(textStrings.size() < FIRST_INPUT_INDEX + 1)
		{
			return;
		}
		mTextStrings = textStrings;
		mCalculator = calculator;
		mNumberOfInputs = numberOfInputs;
		mId = id;
	}
	
	@SuppressWarnings("unchecked")
	public ProblemSummary(Parcel source)
	{
		mTextStrings = (ArrayList<String>) source.readSerializable();
		mCalculator = source.readParcelable(ProblemCalculator.class.getClassLoader());
		mNumberOfInputs = source.readInt();
		mId = source.readInt();
	}
	
	public String getName()
	{
		return mTextStrings.get(NAME_INDEX);
	}
	
	public String getDescription()
	{
		return mTextStrings.get(DESCRIPTION_INDEX);
	}
	
	public String getExample()
	{
		return mTextStrings.get(EXAMPLE_INDEX);
	}
	
	public String getSolution()
	{
		return mTextStrings.get(SOLUTION_INDEX);
	}
	
	public ArrayList<String> getInputStrings()
	{
		return new ArrayList<String>(mTextStrings.subList(
				FIRST_INPUT_INDEX, mTextStrings.size()));
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
		
		destination.writeSerializable(mTextStrings);
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


