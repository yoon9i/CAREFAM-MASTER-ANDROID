package com.jgy.animal.repository;

import java.util.List;

public class ApiFacility {

    // API에서 불러온 자료를 JSON 파싱을 거처 한 줄의 데이터를 분리해줍니다.
    // 따라서 우리가 서버 내에서 각 행의 각 열마다 필요한 정보를 가져와 사용할 수 있습니다.
    private String name;
    private String address;
    private String category3;

    private String city;
    private String district;
    private String town;
    private String ri;


    private double latitude;
    private double longitude;

    private String phoneNumber;
    private String closingDay;
    private String openingHours;
    private String parkingAvailable;
    private String admissionPrice;
    private String petFriendly;
    private String petExclusive;
    private String animalSize;
    private String petRestrictions;
    private String indoorFacility;
    private String outdoorFacility;
    private String description;
    private String additionalPetFee;
    private String lastUpdated;



    // facility 인스턴스를 출력할 시, 오버라이드를 통해 우리가 원하는 정보만 출력하게 해줍니다.
    // 여기서는 시설명, 카테고리3, 도로명 주소만을 출력 합니다.
    @Override
    public String toString() {
        return this.getName()
                + " " + this.getCategory3()
                + " " + this.getAddress();
    }

    // Getter, Setter ==================================================================================
    public String getName() {
        return name;
    }

    public ApiFacility setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ApiFacility setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCategory3() {
        return category3;
    }

    public ApiFacility setCategory3(String category3) {
        this.category3 = category3;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ApiFacility setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public ApiFacility setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getTown() {
        return town;
    }

    public ApiFacility setTown(String town) {
        this.town = town;
        return this;
    }

    public String getRi() {
        return ri;
    }

    public ApiFacility setRi(String ri) {
        this.ri = ri;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public ApiFacility setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public ApiFacility setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ApiFacility setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getClosingDay() {
        return closingDay;
    }

    public ApiFacility setClosingDay(String closingDay) {
        this.closingDay = closingDay;
        return this;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public ApiFacility setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
        return this;
    }

    public String getParkingAvailable() {
        return parkingAvailable;
    }

    public ApiFacility setParkingAvailable(String parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
        return this;
    }

    public String getAdmissionPrice() {
        return admissionPrice;
    }

    public ApiFacility setAdmissionPrice(String admissionPrice) {
        this.admissionPrice = admissionPrice;
        return this;
    }

    public String getPetFriendly() {
        return petFriendly;
    }

    public ApiFacility setPetFriendly(String petFriendly) {
        this.petFriendly = petFriendly;
        return this;
    }

    public String getPetExclusive() {
        return petExclusive;
    }

    public ApiFacility setPetExclusive(String petExclusive) {
        this.petExclusive = petExclusive;
        return this;
    }

    public String getAnimalSize() {
        return animalSize;
    }

    public ApiFacility setAnimalSize(String animalSize) {
        this.animalSize = animalSize;
        return this;
    }

    public String getPetRestrictions() {
        return petRestrictions;
    }

    public ApiFacility setPetRestrictions(String petRestrictions) {
        this.petRestrictions = petRestrictions;
        return this;
    }

    public String getIndoorFacility() {
        return indoorFacility;
    }

    public ApiFacility setIndoorFacility(String indoorFacility) {
        this.indoorFacility = indoorFacility;
        return this;
    }

    public String getOutdoorFacility() {
        return outdoorFacility;
    }

    public ApiFacility setOutdoorFacility(String outdoorFacility) {
        this.outdoorFacility = outdoorFacility;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ApiFacility setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAdditionalPetFee() {
        return additionalPetFee;
    }

    public ApiFacility setAdditionalPetFee(String additionalPetFee) {
        this.additionalPetFee = additionalPetFee;
        return this;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public ApiFacility setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    // ======================================================================================================


    // facility 생성자 =======================================================================================
    public ApiFacility(String name, String address, String category3, String city, String district, String town, String ri, double latitude, double longitude, String phoneNumber, String closingDay, String openingHours, String parkingAvailable, String admissionPrice, String petFriendly, String petExclusive, String animalSize, String petRestrictions, String indoorFacility, String outdoorFacility, String description, String additionalPetFee, String lastUpdated) {
        this.name = name;
        this.address = address;
        this.category3 = category3;
        this.city = city;
        this.district = district;
        this.town = town;
        this.ri = ri;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.closingDay = closingDay;
        this.openingHours = openingHours;
        this.parkingAvailable = parkingAvailable;
        this.admissionPrice = admissionPrice;
        this.petFriendly = petFriendly;
        this.petExclusive = petExclusive;
        this.animalSize = animalSize;
        this.petRestrictions = petRestrictions;
        this.indoorFacility = indoorFacility;
        this.outdoorFacility = outdoorFacility;
        this.description = description;
        this.additionalPetFee = additionalPetFee;
        this.lastUpdated = lastUpdated;
    }

}


