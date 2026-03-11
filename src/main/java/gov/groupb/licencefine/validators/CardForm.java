package gov.groupb.licencefine.validators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

public class CardForm {

    @NotBlank(message = "Credit card number required")
    @CreditCardNumber(message = "Not a valid credit card number")
    private String cardNumber;

    @NotBlank(message = "Expiry Date Required")
    @Pattern(regexp = "(0[1-9]|1[0-2])/(\\d{2})",
            message = "Expiry date must be in MM/YY format")
    private String expiryDate;

    @NotBlank(message = "Security code required")
    @Pattern(regexp = "\\d{3,4}", message = "Security code must be 3 or 4 digits")
    private String cvv;
}
