package com.eulersolutions.interfaces;

import java.util.List;

public interface ISolutionHandler {
	public List<String> getSolutionTitles();
	public List<String> getSolutions();
	public int numberOfSolutions();
	public void setSolutionDisplay(ISolutionDisplay newDisplay);
}
