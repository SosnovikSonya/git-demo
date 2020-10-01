package com.epam.courses.JavaClasses;

public class House {
    private  int id;
    private  int apartmentNumber;
    private  float area;
    private  int floor;
    private  int roomNumbers;
    private  String street;
    private  String houseType;
    private  float lifetime;

    public House(){}

    public House(int id, int apartmentNumber, float area, int floor, int roomNumbers, String street, String houseType, float lifetime) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.roomNumbers = roomNumbers;
        this.street = street;
        this.houseType = houseType;
        this.lifetime = lifetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(int roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public float getLifetime() {
        return lifetime;
    }

    public void setLifetime(float lifetime) {
        this.lifetime = lifetime;
    }

    @Override
    public String toString() {
        return "Квартира{" +
                " номер кваритиры = " + apartmentNumber +
                ", площадь = " + area + " кв.м." +
                ", этаж = " + floor +
                ", количество комнат = " + roomNumbers +
                ", улица = " + street +
                ", тип здания = " + houseType +
                ", срок эксплуатации = " + lifetime + " лет" +
                '}';
    }


}
