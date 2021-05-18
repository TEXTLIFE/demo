package com.codeeric.demo.dao;

import com.codeeric.demo.model.Parcel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
@ClassName: FakeParcelDataAccessService
@Description: this Parcel class is part of View, Data Access Layer MVC (Model View Controller) design pattern.
@author: Enrique Enolva Tan
@since: May 16, 2021
 @version: 1.0
 */

@Repository("fakeDaoParcel") //1st annotation from Spring

public class FakeParcelDataAccessService implements ParcelDao {
    private static List<Parcel> DBParcel = new ArrayList<>();

    @Override
    public int insertParcel(UUID id, Parcel parcel) {
        DBParcel.add(new Parcel(id, parcel.getRuleName(), parcel.getPriority(), parcel.getHeight(), parcel.getWidth(),
                parcel.getLength(), parcel.getWeight(), parcel.getVolume(), parcel.getVoucherCode(), parcel.getDiscount(), parcel.getCost() ));
        return 1;
    }

    @Override
    public List<Parcel> selectAllParcel() {
        return DBParcel; //change the DB from null
    }

    @Override
    public Optional<Parcel> selectParcelById(UUID id) {
        return DBParcel.stream()
                .filter(parcel -> parcel.getId().equals(id))
                .findFirst();
    }

    // this is not implemented not required in the exam spec
    @Override
    public int deleteParcelById(UUID id) {
        return 0;
    }

    // this is not implemented not required in the exam spec
    @Override
    public int updateParcelById(UUID id, Parcel parcel) {
        return 0;
    }
}
