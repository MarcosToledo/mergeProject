package br.com.sisnoti.utils.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Retention(RUNTIME)
public @interface Transacional {

}