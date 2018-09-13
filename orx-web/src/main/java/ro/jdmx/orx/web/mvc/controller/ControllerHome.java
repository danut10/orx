package ro.jdmx.orx.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHome {

    @RequestMapping("/home")
    public String goHome(Model model) {
        return "home";
    }

    @RequestMapping("/error/404")
    private String showEroare404(Model model) {
        return "err/error404";
    }

    @RequestMapping("/underConstruction")
    private String underCstr(Model model) {
    	return "err/underConstruction";
    }
}
