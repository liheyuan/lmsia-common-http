package com.coder4.lmsia.commons.http.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author coder4
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Http401UnAuthorizedException extends RuntimeException {
}