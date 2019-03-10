package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * JSONPAdvice
 */
@ControllerAdvice
public class JSONPAdvice extends AbstractJsonpResponseBodyAdvice {
    // 参数带callback,即jsonp请求,此时不返回json,返回js代码,即callback参数的函数调用
    // jQuery111306779623778597157_1552226056754({"data":"get1 ok"});
    public JSONPAdvice() {
        // 参数改为jsonpCallBack
        super("jsonpCallBack");
    }

}