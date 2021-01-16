package com.uniloftsky.springframework.springmvcrest.controllers.v1;

import com.uniloftsky.springframework.springmvcrest.api.v1.model.VendorDTO;
import com.uniloftsky.springframework.springmvcrest.api.v1.model.VendorListDTO;
import com.uniloftsky.springframework.springmvcrest.service.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "Vendors API")
@RestController
@RequestMapping("/api/v1/vendors/")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ApiOperation(value = "List all the vendors")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors() {
        return new VendorListDTO(vendorService.getAllVendors());
    }

    @ApiOperation(value = "Get a vendor by id")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id) {
        return vendorService.findById(id);
    }

    @ApiOperation(value = "Create a vendor")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createNewVendor(vendorDTO);
    }

    @ApiOperation("Update a vendor")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.saveVendor(id, vendorDTO);
    }

    @ApiOperation("Patch a vendor")
    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.patchVendor(id, vendorDTO);
    }

    @ApiOperation("Delete a vendor")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return new VendorListDTO(vendorService.getAllVendors());
    }
}
