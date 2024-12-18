package vn.edu.iuh.fit.labweek05.backend.models;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private Long addId;

    @Column(name = "city")
    private String city;

    @Column(name = "number")
    private String number;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "street")
    private String street;

    @Enumerated(EnumType.STRING) 
    @Column(name = "country")
    private CountryCode country;

    // Default constructor
    public Address() {}

    // Parameterized constructor
    public Address(String city, String number, String zipcode, String street, int countryCode) {
        this.city = city;
        this.number = number;
        this.zipcode = zipcode;
        this.street = street;
        this.country = CountryCode.fromCode(countryCode); 
    }

    // Getters and Setters
    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public CountryCode getCountry() {
        return country;
    }

    public void setCountry(int countryCode) {
        this.country = CountryCode.fromCode(countryCode); 
    }

    @Override
    public String toString() {
        return city + ", " + number + ", " + zipcode + ", " + street + ", " + country.getCountryName();
    }
}