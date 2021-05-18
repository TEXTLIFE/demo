package com.codeeric.demo.api;

import com.codeeric.demo.model.Parcel;
import com.codeeric.demo.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
/**
@ClassName: ParcelController
@Description: this Parcel class is part of Controller, MVC (Model View Controller) design pattern.
@author: Enrique Enolva Tan
@since: May 16, 2021
 @version: 1.0
 */

@RequestMapping("api/v1/parcel")//this is the path to complete with localhost:8080/ so the complete path is localhost:8080/api/v1/parcel
@RestController
public class ParcelController {

    private final ParcelService parcelService;

    @Autowired
    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @PostMapping
    public void addParcel(@RequestBody Parcel parcel    ) {
        parcelService.addParcel(parcel);

    }
    //Getting data using postman no param
    @GetMapping
    public List<Parcel> getAllParcel() {
        return parcelService.getAllParcel();
    }

    //getting data using postman filtered by ID param with path specified below
    @GetMapping(path = "{id}")
    public  Parcel getParcelById(@PathVariable("id") UUID id) {
        return parcelService.getParcelById(id)
                .orElse(null);
    }
}
