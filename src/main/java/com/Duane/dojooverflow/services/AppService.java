package com.Duane.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Duane.dojooverflow.models.Answer;
import com.Duane.dojooverflow.models.Question;
import com.Duane.dojooverflow.models.Tag;
import com.Duane.dojooverflow.repositories.AnswerRepository;
import com.Duane.dojooverflow.repositories.QuestionRepository;
import com.Duane.dojooverflow.repositories.TagRepository;

@Service
public class AppService {

	private QuestionRepository qRepo;
	private AnswerRepository aRepo;
	private TagRepository tRepo;
	
	public AppService (QuestionRepository qRepo, AnswerRepository aRepo, TagRepository tRepo ) {
		
		this.aRepo = aRepo;
		this.qRepo = qRepo;
		this.tRepo = tRepo;
	}
	
	public Question createQuestion(Question toCreate) {
		
		List<Tag> questionTags = new ArrayList<Tag>();
		for(String subject : toCreate.splitTags()) {
			
			Tag tagToBeAdded = this.tRepo.findBySubject(subject).orElse(null);
			
			if (tagToBeAdded ==null ) {
				tagToBeAdded = new Tag(subject);
				this.tRepo.save(tagToBeAdded);
			}
			if(!questionTags.contains(tagToBeAdded)) {
				questionTags.add(tagToBeAdded);
			}
			
		}
		
		toCreate.setTags(questionTags);
		
		return qRepo.save(toCreate);
	}
	
	public Answer createAnswer(Answer toCreate) {
		return aRepo.save(toCreate);
	}
	
	public List<Question> getAllQuestions() {
		return (List<Question>) qRepo.findAll();
	}
	public List<Answer> getAllAnswers() {
		return (List<Answer>) aRepo.findAll();
	}
	public List<Tag> getAllTags() {
		return (List<Tag>) tRepo.findAll();
	}
	
	public Question findQuestionById(Long id) {
		return qRepo.findById(id).orElse(null);
	}
	
	public Answer findAnswerById(Long id) {
		return aRepo.findById(id).orElse(null);
	}
	
	public void deleteQuestionById(Long id) {
		this.qRepo.deleteById(id);
	}
	
	public void deleteAnswerById(Long id) {
		this.aRepo.deleteById(id);
	}
	
};
