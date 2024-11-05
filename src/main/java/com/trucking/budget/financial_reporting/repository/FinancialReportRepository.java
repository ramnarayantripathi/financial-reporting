package com.trucking.budget.financial_reporting.repository;


import com.trucking.budget.financial_reporting.model.FinancialReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FinancialReportRepository extends JpaRepository<FinancialReport, Long> {
}
