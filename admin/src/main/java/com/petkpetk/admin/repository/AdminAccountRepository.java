package com.petkpetk.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petkpetk.admin.entity.AdminAccount;

public interface AdminAccountRepository extends JpaRepository<AdminAccount, Long> {
}
