package com.eulersolutions.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.eulersolutions.controllers.R;

import android.content.Context;
import android.util.Log;

public class CompletedProblems {
	
	private static final String TAG = "EulerSolutions-CompletedProblems";
	private static final int[] IDS = {R.raw.problem001,
									  R.raw.problem002,
									  R.raw.problem003};
	private ArrayList<ProblemSummary> problems = new ArrayList<ProblemSummary>();
	
	private Context parentContext;
	@SuppressWarnings("rawtypes")
	public CompletedProblems(Context newContext)
	{
		parentContext = newContext;
		for(int id : IDS)
		{
			InputStream inputStream = parentContext.getResources().openRawResource(id);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuffer buffer = new StringBuffer("");
			JSONObject object = null;
			int problemId = -1;
			String name = "";
			String description = "";
			String example = "";
			String solution = "";
			String eulerSolution = "";
			ArrayList<String> inputStrings = new ArrayList<String>();
			String calcName = "";
			ProblemCalculator calculator = null;
			ProblemSummary newItem = null;
			
			Class calcClass = null;
			
			try
			{
				String line = "";
				while((line = reader.readLine()) != null)
				{
					buffer.append(line);
				}
				
				object = (JSONObject) new JSONTokener(buffer.toString()).nextValue();
				problemId = object.getInt("id");
				name = object.getString("name");
				description = object.getString("description");
				example = object.getString("example");
				calcName = object.getString("calculator");
				
				JSONArray jsonArray = object.getJSONArray("solutions");
				solution = buildSolution(jsonArray.getJSONArray(0));
				eulerSolution = buildSolution(jsonArray.getJSONArray(1));
				
				jsonArray = object.getJSONArray("inputStrings");
				for(int index = 0; index < jsonArray.length(); index++)
				{
					inputStrings.add(jsonArray.getString(index));
				}
				
				calcClass = Class.forName("com.eulersolutions.model." + calcName);
				Constructor constructor = calcClass.getConstructor();
				calculator = (ProblemCalculator) constructor.newInstance();
				
				newItem = new ProblemSummary(name, description, example,
						solution, eulerSolution, inputStrings, calculator,
						inputStrings.size(), problemId);
				problems.add(newItem);
			}
			catch(IOException e)
			{
				Log.i(TAG, "IO Reading Error");
				e.printStackTrace();	
			}
			catch(JSONException e)
			{
				Log.i(TAG, "JSON read error");
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			{
				Log.i(TAG, "Calc class not found");
				e.printStackTrace();
			}
			catch(NoSuchMethodException e)
			{
				Log.i(TAG, "Calc class could not find constructor");
				e.printStackTrace();
			}
			catch (IllegalArgumentException e) 
			{
				Log.i(TAG, "Calc class Illegal argument in constructor");
				e.printStackTrace();
			}
			catch (InstantiationException e) 
			{
				Log.i(TAG, "Calc class instance exception");
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				Log.i(TAG, "Calc class illegal access");
				e.printStackTrace();
			}
			catch (InvocationTargetException e)
			{
				Log.i(TAG, "Calc class invocation target exception");
				e.printStackTrace();
			}
		}
	}
	
	private String buildSolution(JSONArray solutionArray) throws JSONException
	{
		StringBuilder builder = new StringBuilder();
		for(int index = 0; index < solutionArray.length(); index++)
		{
			builder.append("     ");
			builder.append(solutionArray.getString(index));
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}
	
	public ArrayList<ProblemSummary> getCompletedProblems()
	{
		return problems;
	}
	
	@Deprecated
	public static ArrayList<ProblemSummary> createCompletedProblems()
	{
		Log.i(TAG, "Entered createCompletedProblems");
		String name;
		String description;
		String example;
		String solution;
		String eulerSolution;
		ArrayList<String> inputStrings;
		ProblemCalculator calculator;
		ProblemSummary newItem;
		int id;
		
		ArrayList<ProblemSummary> toReturn = new ArrayList<ProblemSummary>();
		
		//add problem one
		inputStrings = new ArrayList<String>();
		name = "Multiples of A and B";
		description = "Given a maximum value and two multiples (all positive),"
				+ " find the sum of the all of the multiples.";
		example = "For example, consider a max value of 17 and the multiples"
				+ " 3 and 4. The multiples of 3 and 4 less than 17 are 3, 4, 6, 8, "
				+ "9, 12, 15, and 16. Their sum is 73.";
		solution = "Using modulus division, we can find the greatest number that divides and move from there.";
		eulerSolution = "My solution matched the Euler Solution";
		inputStrings.add("First Multiple: ");
		inputStrings.add("Second Multiple:");
		inputStrings.add("Max Value: ");
		calculator = new MultiplesABCalculator();
		id = 1;
		newItem = new ProblemSummary(name, description, example,
				solution, eulerSolution, inputStrings, calculator, inputStrings.size(), id);
		toReturn.add(newItem);
		
		//add problem two
		inputStrings = new ArrayList<String>();
		name = "Even Fibonnaci Numbers";
		description = "Given a maximum value, find the sum of all of the even "
				+ "Fibonnaci numbers less than that value";
		example = "For example, consider a max value of 9. The Fibonnaci numbers"
				+ " less than 9 are 1, 2, 3, 5, 8. Summing the even numbers, "
				+ "we get 8 + 2 = 10.";
		solution = "We can prove that starting at the second number, ever third term afterwards is even."
				+ " Then we use Binet's formula for finding the nth Fibonnaci value and sum the values.";
		eulerSolution = "Not sure if my solution matched Euler's yet";
		inputStrings.add("Maximum Value: ");
		calculator = new EvenFibonacciNmCalculator();
		id = 2;
		newItem = new ProblemSummary(name, description, example,
				solution, eulerSolution, inputStrings, calculator, inputStrings.size(), id);
		toReturn.add(newItem);
		
		return toReturn;
	}
}
