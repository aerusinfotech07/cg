package com.cg.service;

import java.util.List;

import com.cg.model.Tutorial;

public interface TutorialService {
	
	public List<Tutorial> getAllTutorials();
	public List<Tutorial> getAllTutorialsByType(String type);
	public List<Tutorial> findAllPublishedTutorials();
	public Tutorial saveTutorial(Tutorial tutorial);
	public Tutorial updateTutorial(long tutorialId,Tutorial tutorial);
	public boolean deleteTutorial(long tutorialId);
	

}
