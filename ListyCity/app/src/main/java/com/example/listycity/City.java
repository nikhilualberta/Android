package com.example.listycity;

public class City implements Comparable<City> {
    private String name;
    private String province;

    /**
     * Constuctor for a city object
     * @param name
     * @param province
     */
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    /**
     * Getter for the name attribute
     * @return
     * the name of the city
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name attribute
     * @param name
     * the name of the city
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the province attribute
     * @return
     * the province of the city
     */
    public String getProvince() {
        return province;
    }

    /**
     * setter for the province attribute
     * @param province
     * the province of the city
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Method that allows us to compare cities by name, used for sorting
     * @param city
     * @return
     * Returns an int based on the comparison.
     */
    @Override
    public int compareTo(City city) {
        return this.name.compareTo(city.getName());
    }

}
