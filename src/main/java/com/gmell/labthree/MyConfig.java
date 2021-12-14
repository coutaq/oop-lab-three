package com.gmell.labthree;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.gmell.labthree")
@EnableAspectJAutoProxy
public class MyConfig {
}
