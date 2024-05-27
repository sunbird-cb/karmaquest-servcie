package com.igot.cb.interest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.igot.cb.interest.service.InterestService;
import com.igot.cb.pores.dto.CustomResponse;
import com.igot.cb.pores.elasticsearch.dto.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interest")
public class InterestController {

  @Autowired
  private InterestService interestService;

  @PostMapping("/create")
  public ResponseEntity<CustomResponse> create(@RequestBody JsonNode interestDetails) {
    CustomResponse response = interestService.createInterest(interestDetails);
    return new ResponseEntity<>(response, response.getResponseCode());
  }

  @PostMapping("/search")
  public ResponseEntity<?> search(@RequestBody SearchCriteria searchCriteria) {
    CustomResponse response = interestService.searchDemand(searchCriteria);
    return new ResponseEntity<>(response, response.getResponseCode());
  }

  @PutMapping("/assign")
  public ResponseEntity<CustomResponse> assign(@RequestBody JsonNode interestDetails) {
    CustomResponse response = interestService.assignInterestToDemand(interestDetails);
    return new ResponseEntity<>(response, response.getResponseCode());
  }

  @GetMapping("/read/{id}")
  public ResponseEntity<?> read(@PathVariable String id) {
    CustomResponse response = interestService.read(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}