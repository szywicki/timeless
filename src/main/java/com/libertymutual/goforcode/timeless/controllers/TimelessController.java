package com.libertymutual.goforcode.timeless.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.timeless.models.TimeTrackings;
import com.libertymutual.goforcode.timeless.services.TimeTrackingRepository;


@Controller
@RequestMapping("/")
public class TimelessController {
	
	private TimeTrackingRepository repository;
	
	public TimelessController(TimeTrackingRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	public String redirectToForm() {
		return "tracker/default";
	}
	
	@GetMapping("timeTrackings")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("tracker/default");
		List<TimeTrackings> items = repository.getAll();
		mv.addObject("timeTrackings", items);
		mv.addObject("hasTimeTrackings", !items.isEmpty());
		return mv;
	}

	@PostMapping("/submit")
    public String submit(TimeTrackings item) {
        repository.create(item);
        return "redirect:/timeTrackings";
    }
}