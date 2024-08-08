package com.asklepios.asklepios_server.search;

import com.asklepios.asklepios_server.doctor.data.entity.DoctorEntity;
import com.asklepios.asklepios_server.util.data.entity.AddressEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DoctorSpecification<T> {
    public DoctorSpecification() {
    }

    public static Specification<DoctorEntity> getDoctorsByCriteria(String searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (searchCriteria != null && !searchCriteria.isEmpty()) {
                Join<DoctorEntity, AddressEntity> addressJoin = root.join("address", JoinType.INNER);
                String q = "%" + searchCriteria.trim().toLowerCase() + "%";
                predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("name"), q), criteriaBuilder.like(root.get("specialization"), q),
                        criteriaBuilder.like(addressJoin.get("city"), q)));
            }
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
    public static Specification<DoctorEntity> name(String searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            String q = "%" + searchCriteria.trim().toLowerCase() + "%";
            return criteriaBuilder.like(root.get(DoctorEntity.NAME), q);
        };
    }

    public static Specification<DoctorEntity> specialization(String searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            String q = "%" + searchCriteria.trim().toLowerCase() + "%";
            return criteriaBuilder.like(root.get(DoctorEntity.SPECIALIZATION), q);
        };
    }

    public static Specification<DoctorEntity> city(String searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            Join<DoctorEntity, AddressEntity> addressJoin = root.join(DoctorEntity.ADDRESS, JoinType.INNER);
            String q = "%" + searchCriteria.trim().toLowerCase() + "%";
            return criteriaBuilder.like(addressJoin.get(AddressEntity.CITY), q);
        };
    }
}
