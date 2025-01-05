package com.example.Exitapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Exitapi.entity.Askreview;
import com.example.Exitapi.entity.Review;

/**
 * this class used to perform crud operation on askreview entity
 * @author vishakhachaudhary
 *
 */

public interface AskreviewRepo extends JpaRepository<Askreview, Integer> {

}
