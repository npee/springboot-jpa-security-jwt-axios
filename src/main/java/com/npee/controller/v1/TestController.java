package com.npee.controller.v1;

import com.npee.config.response.ResponseService;
import com.npee.config.response.SingleResult;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = {"0. Test"})
@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    private final ResponseService responseService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/test")
    public SingleResult<String> test() {
        String r = "" + (Math.floor(Math.random() * 100 + 1));
        return responseService.getSingleResult(r);
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
}