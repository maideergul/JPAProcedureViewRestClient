package com.works.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.works.models.Article;
import com.works.models.NewsData;
import com.works.repositories.ActorProcRepository;
import com.works.repositories.CustomerViewRepository;

@Controller
public class CustomerController {

	@Autowired CustomerViewRepository cViewRepo;
	@Autowired ActorProcRepository actorProcRepo;
	
	@GetMapping("")
	public String customer(Model model)
	{
		model.addAttribute("customer", cViewRepo.findAll());
		model.addAttribute("news", restResult());	
		model.addAttribute("actor_proc", actorProcRepo.getAllActorFilm("jennifer"));		

		return "customer";
	}
	
	public List<Article> restResult()
	{
		String url = "http://newsapi.org/v2/top-headlines?country=tr&apiKey=38a9e086f10b445faabb4461c4aa71f8";
		RestTemplate restTemplate  =new RestTemplate();
		NewsData dataObj = restTemplate.getForObject(url, NewsData.class);			
		List<Article> ls = dataObj.getArticles();
		
		return ls;		
	}
}