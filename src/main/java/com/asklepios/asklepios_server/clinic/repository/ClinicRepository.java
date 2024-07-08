package com.asklepios.asklepios_server.clinic.repository;

import com.asklepios.asklepios_server.clinic.data.entity.ClinicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<ClinicEntity, Long> {}
