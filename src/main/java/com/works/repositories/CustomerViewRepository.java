package com.works.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.entities.CustomerView;

public interface CustomerViewRepository extends JpaRepository<CustomerView, Integer> {

}
