package com.uniloftsky.springframework.springmvcrest.api.v1.mapper;

import com.uniloftsky.springframework.springmvcrest.api.v1.model.VendorDTO;
import com.uniloftsky.springframework.springmvcrest.model.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor);
    Vendor vendorDtoToVendor(VendorDTO vendorDTO);

}
