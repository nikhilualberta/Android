package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city){
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        else {
            cities.add(city);
        }
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Returns the sorted list
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if a city is in the city list
     * @param city
     *      The candidate city to be looked for in the list
     * @return
     * Returns true if the list contains the city and false if the list does not contain the candidate city
     */
    public Boolean hasCity(City city) {
        if (cities.contains(city)) {
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }

    /**
     * This method deletes a given city from the city list
     * @param city
     *      The candidate city to be deleted
     */
    public void delete(City city){
        if (hasCity(city)){
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method counts the numbers of cities in the city list
     * @return
     * Returns the number of cities within the city list
     */
    public int countCities() {
        return cities.size();
    }
}
