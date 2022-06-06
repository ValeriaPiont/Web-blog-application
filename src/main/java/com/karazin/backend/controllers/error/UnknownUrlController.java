package com.karazin.backend.controllers.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnknownUrlController implements ErrorController {

    @GetMapping("/404")
    public String getUnknownPage() {
        return "error";
    }

    @GetMapping("/error")
    public String redirectNonExistentUrlsToHome() {
        return "redirect:/404";
    }

}
