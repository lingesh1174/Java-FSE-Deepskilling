package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.model.ProductSearchFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCriteriaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Product> searchProducts(ProductSearchFilter filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.getKeyword().toLowerCase() + "%"));
        }

        if (filter.getRamSize() != null) {
            predicates.add(cb.equal(root.get("ramSize"), filter.getRamSize()));
        }

        if (filter.getCpu() != null) {
            predicates.add(cb.equal(root.get("cpu"), filter.getCpu()));
        }

        if (filter.getOs() != null) {
            predicates.add(cb.equal(root.get("os"), filter.getOs()));
        }

        if (filter.getMaxWeight() != null) {
            predicates.add(cb.le(root.get("weight"), filter.getMaxWeight()));
        }

        if (filter.getCustomerReview() != null) {
            predicates.add(cb.equal(root.get("customerReview"), filter.getCustomerReview()));
        }

        if (filter.getMinCpuSpeed() != null) {
            predicates.add(cb.ge(root.get("cpuSpeed"), filter.getMinCpuSpeed()));
        }

        if (filter.getHardDiskSize() != null) {
            predicates.add(cb.equal(root.get("hardDiskSize"), filter.getHardDiskSize()));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Product> query = em.createQuery(cq);
        return query.getResultList();
    }
}
