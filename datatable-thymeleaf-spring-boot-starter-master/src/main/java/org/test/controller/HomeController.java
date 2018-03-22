package org.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.test.model.Numbers;
import org.test.model.Person;
import org.test.model.ResultObject;

/**
 * Home Controller
 */
@Controller
public class HomeController
{
    
    @GetMapping("/")
    public String numbersForm(Model model) {
        model.addAttribute("numbers", new Numbers());
        return "display";
    }
    
    @GetMapping("/reset")
    public String reset(Model model) {
        model.addAttribute("numbers", new Numbers());
        return "display";
    }
    
    @GetMapping("/display")
    public String display(Model model) {
        model.addAttribute("numbers", new Numbers());
        return "display";
    }

    @PostMapping("/display")
    public String getNumbersList(@ModelAttribute Numbers numbers,Model model) {
    	
    	System.out.println("==================");
		
		String url = "http://multiplescalculator.cloudhub.io/api/calculateMultiples?number1="+ numbers.getNumberOne() + "&number2=" + numbers.getNumberTwo();
		
	    RestTemplate restTemplate = new RestTemplate();
	    @SuppressWarnings("unchecked")
		Map<String,Object> mainObj = (HashMap<String, Object>) restTemplate.getForObject(url, Object.class);
	  
	    System.out.println(mainObj.toString());
	    @SuppressWarnings("unchecked")
		LinkedHashMap<String,String> linkedHashMap = (LinkedHashMap<String,String>) mainObj.get("result");
	    
	    
	    List<ResultObject> numbersList = new ArrayList<ResultObject>();
	    
	    for (Entry<String, String> entry : linkedHashMap.entrySet()) {
	       ResultObject resultObject =new ResultObject();
	       resultObject.setKey(entry.getKey());
	       resultObject.setValue(entry.getValue().toString());	    
	       numbersList.add(resultObject);
	    }
	    
	    model.addAttribute("numbersList", numbersList);
	    
	    return "display";
    }
}