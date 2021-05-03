package henkvantkruijs.Springbootfinalassignmentbootcamphvtk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping(value = "/")
    public String getDemo() {
        return "Hello World";
    }


    @GetMapping(value = "/grap")
    public String getGrap() {
        return "Hoe vangt een koe een haas?";
    }

    @GetMapping(value = "/antwoord")
    public String getAntwoord() {
        return "Wie het weet mag het zeggen!";
    }

}
