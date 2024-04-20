package com.educlaas.helpdesk.configuration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Target(ElementType.PARAMETER)

@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}
