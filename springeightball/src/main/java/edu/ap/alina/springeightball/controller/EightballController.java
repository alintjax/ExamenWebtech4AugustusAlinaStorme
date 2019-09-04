package edu.ap.alina.springeightball.controller;

import edu.ap.alina.springeightball.service.RedisService;

import java.text.Normalizer.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("session")
public class EightballController {

    private RedisService service; // pattern : "products":question:answer
    private String answers[] = {"It is certain.", "It is decidedly so.", "Without a doubt.", "Yes - definitely.", "You may rely on it.", "As I see it, yes.",
    "Most likely.", "Outlook good.", "Yes.", "Signs point to yes.", "Reply hazy", "try again", "Ask again later.", "Better not tell you now.",
    "Cannot predict now.", "Concentrate and ask again.", "Don't count on it.", "My reply is no.", "My sources say no",
    "Outlook not so good.", "Very doubtful."};

    @Autowired
    public void setRedisService(RedisService service) {
        this.service = service;
    }

    public EightballController() { }


    @RequestMapping("/")
    public String root() {
        return "redirect:/searchByQuestionForm";
    }

    @GetMapping("/searchByquestionForm")
    public String searchByQuestionForm() {
        return "searchByQuestion";
    }

    @RequestMapping("/listByQuestion")
    public String searchAnswer(@RequestParam("question") String question,
                                       Model model) {
        String answer = " ";
        if  (service.getKey(question) != null){
            answer = service.getKey(question);
        }
        else{
            int max = this.answers.length - 1;
            int min = 0;
            int range = max - min + 1;
            int rnd = ((int)Math.random() * range) + min;
            answer = this.answers[(int)Math.floor(rnd)];
            service.setKey(question, answer);
        }
        model.addAttribute("question", answer);

        return answer;
    }
}
