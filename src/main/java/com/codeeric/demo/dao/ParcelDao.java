package com.codeeric.demo.dao;

import com.codeeric.demo.model.Parcel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
@ClassName: ParcelDao
@Description: this Parcel class is part of Data Layer/View, MVC (Model View Controller) design pattern.
@author : Enrique Enolva Tan
@since: May 16, 2021
 @version: 1.0

 */
public interface ParcelDao {
    //importing Person class from model package as well as creating an interface class
    int insertParcel(UUID id, Parcel parcel);

    //POST function, inserting data to DBParcel
    default int insertParcel(Parcel parcel ) {
        UUID id = UUID.randomUUID();
        return insertParcel(id, parcel);
    }
    //firing get Postman 1 GET function
    List<Parcel> selectAllParcel();

    //Optional
    Optional<Parcel> selectParcelById(UUID id);


    //Deleting data, this is not implemented not required in the spec
    int deleteParcelById(UUID id);

    //Update PUT function, this is not implemented not required in the spec
    int updateParcelById (UUID id, Parcel parcel);

}
