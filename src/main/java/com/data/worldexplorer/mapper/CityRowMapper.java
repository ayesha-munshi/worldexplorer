package com.data.worldexplorer.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class CityRowMapper implements RowMapper<GlobalTreeNode<String>> {

    private GlobalTreeNode<String> rootNode;

    @Override
    public GlobalTreeNode<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        initializeRoot();
        GlobalTreeNode<String> continent;
        GlobalTreeNode<String> country;
        GlobalTreeNode<String> city = null;

        String continentName = rs.getString("continent");
        if(!rootNode.hasChild(continentName)) {
            continent = new GlobalTreeNode<>(continentName);
            rootNode.addChild(continent);
            System.out.println("Adding new Continent " + continentName + " to World");
        } else {
            continent = rootNode.getChild(continentName);
        }
        String countryName = rs.getString("country");
        if(!doesCountryExistsInOtherContinent(countryName, continentName) && !continent.hasChild(countryName)){
            country = new GlobalTreeNode<>(countryName);
            continent.addChild(country);
            System.out.println("Adding new Country " + countryName + " to Continent " + continentName);
        } else {
            country = continent.getChild(countryName);
        }

        String cityName = rs.getString("city");
        if(country != null && !doesCityExistsInOtherCountry(cityName, countryName) && !country.hasChild(cityName)){
            city = new GlobalTreeNode<>(cityName);
            country.addChild(city);
            System.out.println("Adding new City " + cityName + " to Country " + countryName);
        }
        return city;
    }

    private boolean doesCountryExistsInOtherContinent(String countryName, String continentName) {
        for(GlobalTreeNode<String> childContinent : rootNode.getChildren()) {
            for(GlobalTreeNode<String> childCountry : childContinent.getChildren()){
                if (childCountry.getData().equals(countryName) && !childContinent.getData().equals(continentName)){
                    System.out.println("Country " + countryName + " exists in continent " + childContinent.getData() + ". Cannot add same country in two continents");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean doesCityExistsInOtherCountry(String cityName, String countryName) {
        for(GlobalTreeNode<String> childContinent : rootNode.getChildren()) {
            for(GlobalTreeNode<String> childCountry : childContinent.getChildren()){
                for(GlobalTreeNode<String> childCity : childCountry.getChildren()) {
                    if (childCity.getData().equals(cityName) && !childCountry.getData().equals(countryName)) {
                        System.out.println("City " + cityName + " exists in country " + childCountry.getData() + ". Cannot add same city in two countries");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public GlobalTreeNode initializeRoot(){
        if(Objects.isNull(rootNode)){
            rootNode = new GlobalTreeNode("World");
            System.out.println("Adding root node : " + rootNode.getData() );
        }
        return rootNode;
    }

}
