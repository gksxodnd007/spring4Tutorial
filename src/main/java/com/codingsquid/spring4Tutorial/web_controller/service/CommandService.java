package com.codingsquid.spring4Tutorial.web_controller.service;

import com.codingsquid.spring4Tutorial.web_controller.command.CommandTest;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class CommandService {

    private CommandTest commandTest;

    CommandService() {
        this.commandTest = new CommandTest();
    }

}
