package com.uniloftsky.springframework.springmvcrest.controllers.v1;

import com.uniloftsky.springframework.springmvcrest.api.v1.model.VendorDTO;
import com.uniloftsky.springframework.springmvcrest.api.v1.model.VendorListDTO;
import com.uniloftsky.springframework.springmvcrest.service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendors/")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors() {
        return new VendorListDTO(vendorService.getAllVendors());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id) {
        return vendorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createNewVendor(vendorDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.saveVendor(id, vendorDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.patchVendor(id, vendorDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return new VendorListDTO(vendorService.getAllVendors());
    }
}
