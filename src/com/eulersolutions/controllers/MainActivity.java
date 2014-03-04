package com.eulersolutions.controllers;

import com.eulersolutions.controllers.R;
import com.eulersolutions.model.CompletedProblems;
import com.eulersolutions.model.ProblemSummary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ProblemSelectArrayAdapter problemAdapter = new ProblemSelectArrayAdapter(this, 
				R.layout.layout_problem_select_row, R.id.problemName, CompletedProblems.createCompletedProblems());
		
		setContentView(R.layout.activity_main);
		ListView problemListView = (ListView) this.findViewById(R.id.problemSelectListview);
		
		problemListView.setAdapter(problemAdapter);
		problemListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Context context;
				Intent displayProblem;
				
				ProblemSelectArrayAdapter adapter = (ProblemSelectArrayAdapter) parent.getAdapter();
				ProblemSummary problem = adapter.getItem(position);
				context = adapter.getContext();
				displayProblem = new Intent(context, ProblemPresentationActivity.class);
				displayProblem.putExtra(ProblemPresentationActivity.PARCEL_NAME, problem);
				context.startActivity(displayProblem);
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
