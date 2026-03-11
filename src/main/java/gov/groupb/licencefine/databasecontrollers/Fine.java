package gov.groupb.licencefine.databasecontrollers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String refNum;
    private float fine;
    private boolean paid;
    private String issueDate;
    private String dueDate;

    private String addressLineOne;
    private String addressLineTwo; //Optional
    private String townOrCity;
    private String county; //Optional
    private String postcode;

    private String email;

    public Fine(){

    }

    //For use when county has been provided.
    public Fine(String refNum,
                float fine,
                boolean paid,
                String issueDate,
                String dueDate,
                String addressLineOne,
                String addressLineTwo,
                String townOrCity,
                String county,
                String postcode){

        this.refNum = refNum;
        this.fine = fine;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.paid = paid;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.townOrCity = townOrCity;
        this.county = county;
        this.postcode = postcode;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getIssueDate(){
        return issueDate;
    }

    public void setIssueDate(String issueDate){
        this.issueDate = issueDate;
    }

    public String getDueDate(){
        return dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
