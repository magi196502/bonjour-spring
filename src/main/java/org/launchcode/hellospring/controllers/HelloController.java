package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){

        String name = request.getParameter("name");
        if (name == null) {
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='Dutch'>Dutch</option>" +
                "<option value='French'>French</option>" +
                "<option value='German'>German</option>" +
                "<option value='Japanese'>Japanese</option>" +
                "<option value='Thai'>Thai</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Swahili'>Swahili</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me' />" +
                "</form>";

        return html;
    }

    public  static String createMessage(String name, String lang){
        String greeting = "";

//      language = language.toString().trim();
        if (name == null){
            name = "World!";
        }

        if  (lang.equals("English")) {
            greeting = "Hello ";
        } else if (lang.equals("Dutch")) {
            greeting = "Hallo ";
        } else if (lang.equals("French")) {
            greeting = "Bonjour ";
        } else if (lang.equals("German")) {
            greeting = "Hallo ";
        } else if (lang.equals("Japanese")) {
            greeting = "Konichiwa ";
        } else if (lang.equals("Spanish")) {
            greeting = "Hola ";
        } else if (lang.equals("Swahili")) {
            greeting = "Hujambo ";
        } else if (lang.equals("Thai")) {
            greeting = "Sawadika ";
        } else {
            greeting = "Hello ";
        }

        return greeting + name;
    }

    @RequestMapping(value = "hello", method=RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){

        String name = request.getParameter("name");
        String language = request.getParameter("language");

        String message = createMessage(name, language);

        return message;

    }

    @RequestMapping(value="hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value="goodbye")
    public String goodbye(){
        return "redirect:/";
    }
}

