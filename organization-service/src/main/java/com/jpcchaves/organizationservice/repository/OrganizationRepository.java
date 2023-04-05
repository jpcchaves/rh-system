package com.jpcchaves.organizationservice.repository;

import com.jpcchaves.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findOrganizationByOrganizationCode(String organizationCode);
}
