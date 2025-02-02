package co.simplon.girls_in_tech_business.controllers;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.simplon.girls_in_tech_business.controllers.errors.CustomErrors;


@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
	//データベースの一意制約違反。クライアントがすでに存在する値を挿入しようとした場合、DataIntegrityViolationException がスローされ、HTTP 409（CONFLICT）が返されます。

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolationExeption(DataIntegrityViolationException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status,
            WebRequest request) {
    	//リクエストボディのバリデーションエラー。必須フィールドが欠落している、値が無効などの場合、handleMethodArgumentNotValid が呼び出され、バリデーションエラーの詳細がレスポンスに含まれます。
        List<FieldError> errors = ex.getFieldErrors();
        CustomErrors customErrors = new CustomErrors();
        for (FieldError error : errors) {
            String fieldName = error.getField();
            String code = error.getCode();
            customErrors.addFieldError(fieldName, code);
        }
        List<ObjectError> globalErrors = ex.getGlobalErrors();
        for (ObjectError error : globalErrors) {
            String code = error.getCode();
            customErrors.addGlobalError(code);
        }
        logger.warn(customErrors);
        return handleExceptionInternal(ex, customErrors, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        logger.error(ex);
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

}