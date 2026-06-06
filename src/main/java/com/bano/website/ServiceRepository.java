package com.bano.website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceItem, Long> {
    // Iske andar kuch nahi likhna, Spring Jpa humein saare CRUD operations readymade de dega!
}