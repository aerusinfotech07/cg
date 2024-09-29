package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Tutorial;
import com.cg.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService{

	@Autowired
	TutorialRepository tutorialRepository;
	
	@Override
	public List<Tutorial> getAllTutorials() {
		// TODO Auto-generated method stub
		return tutorialRepository.findAll();
	}

	@Override
	public List<Tutorial> getAllTutorialsByType(String type) {
		// TODO Auto-generated method stub
		return tutorialRepository.findByType(type);
	}

	@Override
	public List<Tutorial> findAllPublishedTutorials() {
		// TODO Auto-generated method stub
		return tutorialRepository.findByPublised(true);
	}

	@Override
	public Tutorial saveTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		return tutorialRepository.save(null);
	}

	@Override
	public Tutorial updateTutorial(long tutorialId, Tutorial tutorial) {
		// TODO Auto-generated method stub
		return tutorialRepository.save(tutorial);
	}

	@Override
	public boolean deleteTutorial(long tutorialId) {
		// TODO Auto-generated method stub
		tutorialRepository.deleteById(tutorialId);
		return true;
	}

}
