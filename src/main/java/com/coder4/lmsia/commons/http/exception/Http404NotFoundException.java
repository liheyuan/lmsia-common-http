package com.coder4.lmsia.commons.http.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author coder4
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class Http404NotFoundException extends RuntimeException {
}