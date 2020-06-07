/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.manager.admin.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author Administrator
 */
@Slf4j
@RestController
class HelloWorldController {

    @GetMapping("hello-world")
    public String showHelloWorld(){
        log.info("{}","is accessing");
        return "hello world";
    }
    
    
    
    
    
}

