package com.example.webproject.data.remotes.repositories;

import com.example.webproject.data.models.db.entity.BillDetail;
import com.example.webproject.data.models.db.entity.BillDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailKey> {
}
