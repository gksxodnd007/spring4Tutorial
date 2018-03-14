package com.codingsquid.spring4Tutorial.web_controller;

import com.codingsquid.spring4Tutorial.dao.StudentRepositoryImpl;
import com.codingsquid.spring4Tutorial.web_controller.command.CommandTest;
import com.codingsquid.spring4Tutorial.web_controller.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller(value = "/page")
public class WebControllerTest {

    private CommandService commandService;
    private StudentRepositoryImpl studentRepositoryImpl;

    @Autowired
    WebControllerTest(CommandService commandService,
                      StudentRepositoryImpl studentRepositoryImpl) {
        this.commandService = commandService;
        this.studentRepositoryImpl = studentRepositoryImpl;
    }

    @ModelAttribute("memberInfo")
    public CommandTest commandReturnMethod() {
        commandService.getCommandTest().setEmail("gksxodnd007@gmail.com");
        return commandService.getCommandTest();
    }

    @RequestMapping(value = "/webController")
    public String helloWorld(ModelMap modelMap) {
        modelMap.addAttribute("author", "CodingSquid");
        return "index";
    }
    //@ModelAttribute("memberInfo")CommandTest command
    @RequestMapping(value = "/testCommand", method = RequestMethod.GET)
    public String testCommand() {
        return "showingPage";
    }

    @RequestMapping(value = "/getStudent", method = RequestMethod.GET)
    public String showingStudent(ModelMap modelMap,
                                 @RequestParam("name")String name) {
        modelMap.addAttribute("student", studentRepositoryImpl.findStudentByName(name));
        return "showingPage";
    }

}
