package com.example.webproject.data.remotes.repositories;

import com.example.webproject.data.models.db.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query(value = "SELECT * FROM tbl_bill WHERE customer_id = ?1 ORDER BY bill_id ASC LIMIT 1", nativeQuery = true)
    public Bill findNewBillIdByCustomerId(Long customerId);

}
