package com.uniloftsky.springframework.springmvcrest.repositories;

import com.uniloftsky.springframework.springmvcrest.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
