package com.highettmetal.services;

import com.highettmetal.domain.BinType;
import com.highettmetal.repositories.BinTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rodmccutcheon on 17/7/17.
 */
@Service
public class BinTypeServiceImpl implements BinTypeService {

    private BinTypeRepository binTypeRepository;

    @Autowired
    public BinTypeServiceImpl(BinTypeRepository binTypeRepository) {
        this.binTypeRepository = binTypeRepository;
    }

    @Override
    public List<BinType> listAllBinTypes() {
        return binTypeRepository.findAll();
    }

    @Override
    public BinType getBinTypeById(Long id) {
        return binTypeRepository.findOne(id);
    }

    @Override
    public BinType saveBinType(BinType binType) {
        return binTypeRepository.save(binType);
    }

    @Override
    public void deleteBinType(Long id) {
        binTypeRepository.delete(id);
    }
}
