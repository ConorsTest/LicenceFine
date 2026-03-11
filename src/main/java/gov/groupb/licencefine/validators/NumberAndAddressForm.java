package gov.groupb.licencefine.validators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NumberAndAddressForm {

    @Size(min = 16, max = 16,
            message = "The reference number must be 16 digits long")
    private String refNum;

    @NotBlank(message = "Address Line 1 is necessary")
    private String addressLineOne;

    private String addressLineTwo;

    @NotBlank(message = "Town/City is necessary")
    private String townOrCity;

    private String county;

    @NotBlank(message = "Postcode is necessary")
    private String postcode;

    public NumberAndAddressForm(){


    }

    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getTownOrCity() {
        return townOrCity;
    }

    public void setTownOrCity(String townOrCity) {
        this.townOrCity = townOrCity;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
