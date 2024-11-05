package com.org.mailservice.repository;

import com.org.mailservice.model.MailDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailDeliveryRepository extends JpaRepository<MailDelivery, String> {

}