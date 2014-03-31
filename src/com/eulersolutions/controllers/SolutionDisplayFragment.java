package com.eulersolutions.controllers;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SolutionDisplayFragment extends Fragment implements ISolutionDisplay{

	private TextView solutionDisplay;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_solution_display, container, false);
	}
	
	@Override
	public void onAttach(Activity activity)
	{
		ISolutionHandler handler;
		
		super.onAttach(activity);
		
		if(activity instanceof ISolutionHandler)
		{
			handler = (ISolutionHandler) activity;
			handler.setSolutionDisplay(this);
		}
	}
	
	@Override
	public void setSolution(String solution) {
		solutionDisplay = (TextView) this.getView().findViewById(R.id.solutionDisplayTextView);
		solutionDisplay.setText(solution);
	}

}
