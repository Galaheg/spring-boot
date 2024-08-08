package com.hemre.springboot.mvc.validation.model;

import Validate.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "REQUIRED")
    @Size(min=2, message = "min 2 char")
    private String lastName;

    @NotNull(message = "Required")
    @Min(value=0, message="Must be greater than or equal to zero")
    @Max(value=10, message="Must be lower than or equal to ten")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    @NotNull(message = "REQUIRED")
    private String postalCode;

    @NotNull(message = "REQUIRED")
    @CourseCode()
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
