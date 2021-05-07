package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config;

import java.util.Locale;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author yure.placido
 *
 */
@ControllerAdvice(basePackages = "org.spcbrasil.cadastropositivo.centralizedauthorizationserver")
public class GlobalControllerExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReloadableResourceBundleMessageSource exceptionResourceBundleMessageSource;

	public GlobalControllerExceptionHandler() {
		super();
	}

	@ExceptionHandler(BusinessException.class)
	ResponseEntity<ErrorMessageDto> handleBusinessException(BusinessException businessException) {
		String error = exceptionResourceBundleMessageSource.getMessage(businessException.getCode(),
				businessException.getParams(), Locale.getDefault());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(
				new ErrorMessageDto(businessException.getCode(), status.value(), error, businessException.getParams()),
				headers, status);

	}

	@ExceptionHandler(AccessDeniedException.class)
	ResponseEntity<ErrorMessageDto> handleException(AccessDeniedException exception) {
		exception.printStackTrace();
		String message = exceptionResourceBundleMessageSource.getMessage("msg.acesso.negado", null,
				Locale.getDefault());
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(new ErrorMessageDto("msg.acesso.negado", status.value(), message), headers, status);

	}

	@ExceptionHandler(value = { BadCredentialsException.class })
	public ResponseEntity<ErrorMessageDto> handleUnauthorized(final DataIntegrityViolationException ex,
			final WebRequest request) {
		return handleExceptionInternal(ex, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public ResponseEntity<ErrorMessageDto> handleBadRequest(final ConstraintViolationException ex,
			final WebRequest request) {
		return handleExceptionInternal(ex, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	public ResponseEntity<ErrorMessageDto> handleBadRequest(final DataIntegrityViolationException ex,
			final WebRequest request) {
		return handleExceptionInternal(ex, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ InvalidDataAccessApiUsageException.class, DataAccessException.class })
	protected ResponseEntity<ErrorMessageDto> handleConflict(final RuntimeException ex, final WebRequest request) {
		return handleExceptionInternal(ex, new HttpHeaders(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
	public ResponseEntity<ErrorMessageDto> handleInternal(final RuntimeException ex, final WebRequest request) {
		return handleExceptionInternal(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorMessageDto> handleException(Exception exception) {
		logger.debug("BusinessExceptionHandler: ERRO GENERICO", exception);
		return handleExceptionInternal(exception, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	protected ResponseEntity<ErrorMessageDto> handleExceptionInternal(Exception exception, HttpHeaders headers,
			HttpStatus status) {

		String message = exceptionResourceBundleMessageSource.getMessage("msg.erro.generico", null,
				Locale.getDefault());
		return new ResponseEntity<>(new ErrorMessageDto("msg.erro.generico", status.value(), message), headers, status);
	}

}
