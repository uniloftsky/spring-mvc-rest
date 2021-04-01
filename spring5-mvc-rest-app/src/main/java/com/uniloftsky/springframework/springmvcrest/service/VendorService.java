package com.uniloftsky.springframework.springmvcrest.service;

import com.uniloftsky.springframework.springmvcrest.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {

    VendorDTO findById(Long id);
    List<VendorDTO> getAllVendors();
    VendorDTO createNewVendor(VendorDTO vendorDTO);
    VendorDTO saveVendor(Long id, VendorDTO vendorDTO);
    void deleteVendor(Long id);
    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

}
