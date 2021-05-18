package com.codeeric.demo.service;

import com.codeeric.demo.dao.ParcelDao;
import com.codeeric.demo.model.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
@ClassName: ParcelService
@Description: this Parcel class is part of Service Package, MVC (Model View Controller) design pattern.
@author : Enrique Enolva Tan
@since: May 16, 2021
 @version: 1.0
 */
@Service //annotation from Spring boot framework
public class ParcelService {

    private final ParcelDao parcelDao;

    @Autowired //@Qualifer with connection from FakeParcelData...not actual db is used in this exam
    public ParcelService(@Qualifier("fakeDaoParcel") ParcelDao parcelDao) {
        this.parcelDao = parcelDao;
    }

    //inserting to Postman
    public int addParcel(Parcel parcel){
        return parcelDao.insertParcel(parcel);
    }

    //getting all data for Postman GET command
    public List<Parcel> getAllParcel() {
        return parcelDao.selectAllParcel();
    }

    //getting optonal data from Postman GET command
    public Optional<Parcel> getParcelById(UUID id) {
        return parcelDao.selectParcelById(id);
    }

}
