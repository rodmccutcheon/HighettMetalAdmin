package com.highettmetal.services;

import com.highettmetal.domain.BinType;

import java.util.List;

/**
 * Created by rodmccutcheon on 17/7/17.
 */
public interface BinTypeService {
    List<BinType> listAllBinTypes();

    BinType getBinTypeById(Long id);

    BinType saveBinType(BinType binType);

    void deleteBinType(Long id);
}
