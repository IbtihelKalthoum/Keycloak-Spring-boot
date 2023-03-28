package com.TeamwillFaces.authserver.controller;

import com.TeamwillFaces.authserver.model.IntrospectResponse ;
import com.TeamwillFaces.authserver.model.Response;
import com.TeamwillFaces.authserver.model.TokenRequest;
import com.TeamwillFaces.authserver.model.LoginRequest;
import com.TeamwillFaces.authserver.model.LoginResponse;
import com.TeamwillFaces.authserver.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    LoginService loginservice;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginrequest) {
        return loginservice.login(loginrequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<Response> logout (@RequestBody TokenRequest token) {
        return loginservice.logout(token);
    }

    @PostMapping("/introspect")
    public ResponseEntity<IntrospectResponse> introspect(@RequestBody TokenRequest token) {
        return loginservice.introspect(token);
    }
}