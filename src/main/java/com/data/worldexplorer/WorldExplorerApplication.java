package com.data.worldexplorer;

import com.data.worldexplorer.mapper.GlobalTreeNode;
import com.data.worldexplorer.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WorldExplorerApplication implements CommandLineRunner {

	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(WorldExplorerApplication.class, args);
	}

	public void run(String... arg){
		System.out.println("Start creating World tree...");
		List<GlobalTreeNode<String>> globalCities = cityRepository.findAll();
		System.out.println(" \n --------------------World Cities-------------------- \n" );
		for(GlobalTreeNode<String> globalCity : globalCities){
			if(globalCity != null){
				System.out.println(globalCity + ":" + globalCity.getParent() + ":" + globalCity.getParent().getParent());
			}
		}
	}
}
