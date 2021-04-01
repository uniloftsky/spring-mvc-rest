package com.uniloftsky.springframework.springmvcrest.service;

import com.uniloftsky.springframework.springmvcrest.api.v1.mapper.VendorMapper;
import com.uniloftsky.springframework.springmvcrest.api.v1.model.VendorDTO;
import com.uniloftsky.springframework.springmvcrest.exceptions.ResourceNotFoundException;
import com.uniloftsky.springframework.springmvcrest.model.Vendor;
import com.uniloftsky.springframework.springmvcrest.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public VendorDTO findById(Long id) {
        return vendorRepository.findById(id).map(vendor -> {
            VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
            vendorDTO.setVendorUrl("/api/v1/vendors/");
            return vendorDTO;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll().stream().map(vendor -> {
            VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
            vendorDTO.setVendorUrl("/api/v1/vendors/" + vendor.getId());
            return vendorDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        return saveAndReturnDTO(vendor);
    }

    @Override
    public VendorDTO saveVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
        vendor.setId(id);
        return saveAndReturnDTO(vendor);
    }

    private VendorDTO saveAndReturnDTO(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(savedVendor);
        returnDTO.setVendorUrl("/api/v1/vendors/" + savedVendor.getId());
        return returnDTO;
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id).map(vendor -> {
            if (vendor.getName() != null) {
                vendor.setName(vendorDTO.getName());
            }
            VendorDTO vendorDto = vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
            vendorDto.setVendorUrl("/api/v1/vendors/" + id);
            return vendorDto;
        }).orElseThrow(ResourceNotFoundException::new);
    }
}
