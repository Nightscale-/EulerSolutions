package com.eulersolutions.controllers;

import com.eulersolutions.interfaces.ISelectionListener;
import com.eulersolutions.interfaces.ISolutionHandler;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SolutionSelectFragment extends ListFragment {

	private static final String TAG = "EulerSolutions-SolutionSelectFragment";
	
	private ISelectionListener selectionCallback;
	private ISolutionHandler solutionCallback;
	private ArrayAdapter<String> adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Log.i(TAG, "entered onCreate");
		super.onCreate(savedInstanceState);
		
		adapter = new ArrayAdapter<String>(this.getActivity(), 
				android.R.layout.simple_list_item_activated_1);
		this.setListAdapter(adapter);
	}
	
	@Override
	public void onAttach(Activity activity)
	{
		Log.i(TAG, "entered onAttach");
		super.onAttach(activity);
		if((activity instanceof ISelectionListener) && (activity instanceof ISolutionHandler))
		{
			selectionCallback = (ISelectionListener) activity;
			solutionCallback = (ISolutionHandler) activity;
			adapter.addAll(solutionCallback.getSolutionTitles());
		}
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		Log.i(TAG, "entered onActivityCreated");
		super.onActivityCreated(savedInstanceState);
		this.getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}
	
	@Override
	public void onListItemClick(ListView l, View view, int position, long id)
	{
		Log.i(TAG, "entered onListItemClicked");
		if(selectionCallback != null)
			selectionCallback.onItemSelected(position);
	}
}
