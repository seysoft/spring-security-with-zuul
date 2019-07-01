package com.f1soft.loginservice.controller;

import com.f1soft.loginservice.constants.WebResourceKeyConstants;
import com.f1soft.loginservice.requestDTO.LoginRequestDTO;
import com.f1soft.loginservice.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = WebResourceKeyConstants.BASE_API)
@Api(value = "This is login controller")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = WebResourceKeyConstants.LOGIN)
    @ApiOperation(value = "This is login api", notes = "Request contains username and password")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO requestDTO, HttpServletRequest request) {
        return ok(loginService.login(requestDTO, request));
    }

    @GetMapping("/test")
    public String test() {
        return "test done";
    }
}
