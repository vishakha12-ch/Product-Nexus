package com.example.Exitapi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Exitapi.dto.ReviewDTO;
import com.example.Exitapi.dto.UserDTO;
import com.example.Exitapi.entity.Review;
import com.example.Exitapi.entity.User;

public class ReviewMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ReviewDTO reviewDto;
	
	public ReviewDTO reviewtodto(Review review) {
		ReviewDTO reviewdto = mapper.map(review,ReviewDTO.class);
		return reviewdto;
		
	}
	
	public Review dtotoreview(ReviewDTO reviewdto) {
		Review review =mapper.map(reviewdto, Review.class);
		return review;
	}

}
