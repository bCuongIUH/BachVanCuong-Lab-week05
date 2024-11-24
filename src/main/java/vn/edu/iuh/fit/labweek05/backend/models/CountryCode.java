package vn.edu.iuh.fit.labweek05.backend.models;

public enum CountryCode {
    VN(11, "Viet Nam"),
    US(12, "United States"),
    JP(13, "Japan");

    private final int code;
    private final String countryName;

    CountryCode(int code, String countryName) {
        this.code = code;
        this.countryName = countryName;
    }

    public int getCode() {
        return code;
    }

    public String getCountryName() {
        return countryName;
    }

    public static CountryCode fromCode(int code) {
        for (CountryCode countryCode : CountryCode.values()) {
            if (countryCode.getCode() == code) {
                return countryCode;
            }
        }
        throw new IllegalArgumentException("Invalid country code: " + code);
    }
}

