package com.eulersolutions.controllers;

import com.eulersolutions.interfaces.ISolutionDisplay;
import com.eulersolutions.interfaces.ISolutionHandler;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SolutionDisplayFragment extends Fragment implements ISolutionDisplay{
	
	private static final String TAG = "EulerSolutions-SolutionDisplayFragment";
	
	private TextView solutionDisplay;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		Log.i(TAG, "Entered onCreateView");
		return inflater.inflate(R.layout.fragment_solution_display, container, false);
	}
	
	@Override
	public void onAttach(Activity activity)
	{
		Log.i(TAG, "entered onAttach");
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
		Log.i(TAG, "entered Set Solution");
		solutionDisplay = (TextView) this.getView().findViewById(R.id.solutionDisplayTextView);
		solutionDisplay.setText(solution);
	}
}
