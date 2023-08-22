package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import survey.AnsweredData;
import survey.Question;

@Controller
@RequestMapping("/survey")
@Slf4j
public class SurveyController {

	@GetMapping
	public String form(Model model) {
		List<Question> list = new ArrayList<Question>();
		Question que = Question.builder().title("당신의 역할은 무엇입니까?").options(Arrays.asList("서버", "프론트", "풀스택")).build();
		list.add(que);
		
		que = Question.builder().title("많이 사용하는 개발도구는 무엇입니까?").options(Arrays.asList("이클립스", "인텔리J", "서브라임")).build();
		list.add(que);
		
		que = new Question("하고싶은 말을 적어주세요");
		list.add(que);
		model.addAttribute("questions", list);
		return "survey/surveyForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted";
	}
}
