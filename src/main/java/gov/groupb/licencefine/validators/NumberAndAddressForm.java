package gov.groupb.licencefine.validators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NumberAndAddressForm {

    @Size(min = 16, max = 16,
            message = "The reference number must be 16 digits long")
    private String refNum;

    @NotBlank(message = "Address Line 1 is necessary")
    private String addressLineOne;

    private String getAddressLineTwo;

    @NotBlank(message = "Town/City is necessary")
    private String townOrCity;

    private String county;

    @NotBlank(message = "Postcode is necessary")
    private String postcode;

    public NumberAndAddressForm(){

    }
}
