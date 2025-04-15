package be.vdab.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = VerkoopPrijsAankoopPrijsValidator.class)
public @interface VerkoopPrijsAankoopPrijs {
    String message() default "{be.vdab.VerkoopPrijsAankoopPrijs.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
