package com.eulersolutions.controllers;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SolutionSelectFragment extends ListFragment {

	private static final String[] solutionTitles = {"My Solution", "Euler Solution"};
	private ISelectionListener selectionCallback;
	private ISolutionHandler solutionCallback;
	private ArrayAdapter<String> adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		adapter = new ArrayAdapter<String>(this.getActivity(), 
				android.R.layout.simple_list_item_activated_1, solutionTitles);
		this.setListAdapter(adapter);
	}
	
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		if((activity instanceof ISelectionListener) && (activity instanceof ISolutionHandler))
		{
			selectionCallback = (ISelectionListener) activity;
			solutionCallback = (ISolutionHandler) activity;
			//adapter.addAll(solutionCallback.getSolutionTitles());
		}
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		this.getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}
	
	@Override
	public void onListItemClick(ListView l, View view, int position, long id)
	{
		if(selectionCallback != null)
			selectionCallback.onItemSelected(position);
	}
}
