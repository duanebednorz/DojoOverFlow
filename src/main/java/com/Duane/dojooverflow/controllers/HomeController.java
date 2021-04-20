package com.Duane.dojooverflow.controllers;




import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Duane.dojooverflow.models.Answer;
import com.Duane.dojooverflow.models.Question;
import com.Duane.dojooverflow.services.AppService;

@Controller
public class HomeController {
	
	private AppService appServ;
	
	public HomeController(AppService appServ) {
		this.appServ = appServ;
	}

	@GetMapping("/")
	public String homepage() {
		return "redirect:/questions/dashboard";
	}
	
	@GetMapping("/questions/dashboard")
	public String quesDashboard(Model model) {
		model.addAttribute("allQuestions", appServ.getAllQuestions());
		model.addAttribute("allTags", appServ.getAllTags());
		return "QuestionsDashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newQuestion") Question question) {
		return "QuestionsNew.jsp";
	}
	
	@PostMapping("questions/create")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result) {
		
		if(result.hasErrors() ) {
			return "QuestionsNew.jsp";
		}
		else {
			appServ.createQuestion(question);
			return "redirect:/questions/dashboard";
		}
	}
	
	@GetMapping("questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("newAnswer") Answer answer, Model model) {	
		model.addAttribute("question", appServ.findQuestionById(id));
		return "ViewOneQuestion.jsp";
		
	}
	
	@PostMapping("questions/addAnswer")
	public String createAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result) {
		System.out.println("*********");
		if(result.hasErrors() ) {
			return "ViewOneQuestion.jsp";
		}
		else {
			Answer newAnswer = appServ.createAnswer(answer);
			return "redirect:/questions/" + newAnswer.getQuestion().getId();
		}
	}
	
	@GetMapping("questions/delete/{id}")
	public String deleteQuestion(@PathVariable("id") Long id) {
		appServ.deleteQuestionById(id);
		return "redirect:/questions/dashboard";
	}
	
	@RequestMapping("answers/delete/{id}")
	public String deleteAnswer(@PathVariable("id") Long id) {
		Answer answerSelect = appServ.findAnswerById(id);
		String questionId = Long.toString(answerSelect.getQuestion().getId());
		appServ.deleteAnswerById(id);
		return "reirect:/questions/"+ questionId;
	}
	
};
