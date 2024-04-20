package com.educlaas.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.helpdesk.dao.Caller;
import com.educlaas.helpdesk.service.CallerService;

@RestController
@RequestMapping(value = "/api")
public class CallerController {

    @Autowired
    private CallerService callerService;

    @GetMapping("/callers")
    public List<Caller> getAllCallers() {
        return callerService.getAllCallers();
    }

    @GetMapping("/caller/{callerID}")
    public Caller getCallerById(@PathVariable Long callerID) {
        return callerService.getCallerById(callerID);
    }

    @PostMapping("/caller")
    public Caller saveCaller(@RequestBody Caller caller) {
        return callerService.saveCaller(caller);
    }

    @DeleteMapping("/caller/{callerID}")
    public String deleteCaller(@PathVariable Long callerID) {
        callerService.deleteCaller(callerID);
		return "Delete Store Succesfully";
    }

}
