package com.eulersolutions.controllers;

import java.util.ArrayList;

import com.euler.eulersolutions.R;
import com.eulersolutions.model.CompletedProblems;
import com.eulersolutions.model.ProblemSelectArrayAdapter;
import com.eulersolutions.model.ProblemSummary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayList<ProblemSummary> problems = CompletedProblems.createCompletedProblems();
		ProblemSelectArrayAdapter problemAdapter = new ProblemSelectArrayAdapter(this, 
				R.layout.layout_problem_select_row, R.id.problemName, problems);
		
		setContentView(R.layout.activity_main);
		ListView problemListView = (ListView) this.findViewById(R.id.problemSelectListview);
		
		problemListView.setAdapter(problemAdapter);
		problemListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				ProblemSelectArrayAdapter adapter = (ProblemSelectArrayAdapter) parent.getAdapter();
				ProblemSummary item = adapter.getItem(position);
				Intent editItemIntent = new Intent(adapter.getContext(), item.getClass());
				adapter.getContext().startActivity(editItemIntent);
			}
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
