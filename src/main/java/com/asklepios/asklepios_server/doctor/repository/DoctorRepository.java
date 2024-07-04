package com.asklepios.asklepios_server.doctor.repository;

import com.asklepios.asklepios_server.doctor.controller.data.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {}
