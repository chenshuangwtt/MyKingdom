package io.imking.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import io.imking.utils.Result;
import io.imking.utils.ResultEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: 全局异常处理类
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@RestController
@ControllerAdvice
public class ExceptionHandlerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    public Result<String> defaultExceptionHandler(HttpServletRequest request, Exception e)
            throws Exception {
        LOGGER.error("[GlobalExceptionHandler] [error to handle uri: {}", request.getRequestURI(),e);
        return new Result<>(ResultEnum.SERVER_ERROR, e.getMessage());
    }
}
