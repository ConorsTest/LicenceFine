package gov.groupb.licencefine.validators;

import jakarta.validation.constraints.Email;
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

    @NotBlank
    private String refNum;

    @Email
    private String email;

    public CardForm(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
