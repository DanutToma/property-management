package com.myproject.property_management.service;

import com.myproject.property_management.dto.PropertyDTO;

import java.util.List;


public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyId);
    String deleteProperty(Long propertyId);

}
