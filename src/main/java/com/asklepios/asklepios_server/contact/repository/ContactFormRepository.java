package com.asklepios.asklepios_server.contact.repository;

import com.asklepios.asklepios_server.contact.data.entity.ContactFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactFormRepository extends JpaRepository<ContactFormEntity, Long> {}
