package com.example.demo.controller;

import com.example.demo.depots.dto.DepoCloseDto;
import com.example.demo.depots.dto.DepoDto;
import com.example.demo.depots.dto.DepoResponse;
import com.example.demo.services.DepoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class DepoController {

  @Autowired
  DepoServices depoServices;

  @PostMapping(value = "/depo", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation("depo kaydetme işlemi gerçekleştirilir")
  public ResponseEntity<DepoResponse> createDepo(@RequestBody DepoDto depoDto) {
    return new ResponseEntity<>(depoServices.save(depoDto), HttpStatus.OK);
  }

  @PostMapping(value = "/depo/close", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation("depo kapatma işlemi gerçekleştirilir")
  public ResponseEntity<DepoResponse> closeDepo(@RequestBody DepoCloseDto depoCloseDto) {
    return new ResponseEntity<>(depoServices.closeDepo(depoCloseDto), HttpStatus.OK);
  }
}
