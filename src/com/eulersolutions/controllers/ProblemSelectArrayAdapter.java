package com.eulersolutions.controllers;

import java.util.List;

import com.eulersolutions.model.ProblemSummary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ProblemSelectArrayAdapter extends ArrayAdapter<ProblemSummary> {

	private int layoutId;
	private int textViewId;
	
	private static final String TAG = "EulerSolution-ProblemSelectArrayAdapter";
	
	public ProblemSelectArrayAdapter(Context context, int resource, int textViewResourceId, List <ProblemSummary> newItems) {
		super(context, resource, textViewResourceId);
		Log.i(TAG, "Creating Object");
		layoutId = resource;
		textViewId = textViewResourceId;
		this.addAll(newItems);
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
		Log.i(TAG, "Building the View");
    	LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	View toReturn = inflater.inflate(layoutId, parent, false);
    	TextView problemName = (TextView) toReturn.findViewById(textViewId);
    	problemName.setText(buildString(this.getItem(position)));
	    return toReturn;
    }

	@Override
    public long getItemId(int position) {
      return this.getItem(position).getId();
    }

    @Override
    public boolean hasStableIds() {
      return true;
    }
    
    public String buildString(ProblemSummary item)
    {
    	Log.i(TAG, "Building the String");
    	return "Problem" + item.getId() + ": " + item.getName();
    }
}
