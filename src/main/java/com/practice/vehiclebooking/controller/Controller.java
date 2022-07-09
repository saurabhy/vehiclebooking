package com.practice.vehiclebooking.controller;

import com.practice.vehiclebooking.custom.StrategyProcessor;
import com.practice.vehiclebooking.orchestrator.RequestDispatcher;
import com.practice.vehiclebooking.request.ProcessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@Component
@RestController
@RequestMapping("/vehiclebooking")
public class Controller {

    @Autowired
    private RequestDispatcher requestDispatcher;

    @PostMapping("/process")
    public ResponseEntity<?> processRequest(@RequestBody ProcessRequest request) throws IOException {

        File file = new File(request.getFilePath());

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            requestDispatcher.identifyAndDispatchRequest(st);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
