package com.myproject.property_management.service.impl;

import com.myproject.property_management.converter.PropertyConverter;
import com.myproject.property_management.dto.PropertyDTO;
import com.myproject.property_management.entity.PropertyEntity;
import com.myproject.property_management.repository.PropertyRepository;
import com.myproject.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //it makes it a singleton , only create once
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO)
    {
        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        propertyDTO = propertyConverter.convertEntitytoDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProperties = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for(PropertyEntity pe:  listOfProperties){
            PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId)
    {
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        if(optEn.isPresent()) {
            PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
            pe.setId(propertyId);
            pe = propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);
        }

        return propertyDTO;
    }

    @Override
    public String deleteProperty(Long propertyId) {
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        if(optEn.isPresent()){
            propertyRepository.deleteById(propertyId);
            return "Ok";
        }
        return "No Found";
    }
}
