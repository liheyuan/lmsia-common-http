/**
 * @(#)Http413ForbiddenException.java, Jun 20, 2018.
 * <p>
 * Copyright 2018 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.coder4.lmsia.commons.http.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author coder4
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class Http404NotFoundException extends RuntimeException {
}