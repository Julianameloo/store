package br.com.api.store.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UsuarioExistenteValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UsuarioExistente {
	String message() default "endereço de email já utilizado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
