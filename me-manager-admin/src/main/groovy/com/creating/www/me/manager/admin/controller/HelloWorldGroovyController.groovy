/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.creating.www.me.manager.admin.controller

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author Administrator
 */
@Slf4j
@RestController
class HelloWorldGroovyController {
	
    @GetMapping("hello-world")
    public String showHelloWorld(){
        log.info("groovy {}","access");
        return "hello world";
    }
}

