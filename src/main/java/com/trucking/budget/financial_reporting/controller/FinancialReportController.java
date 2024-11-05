

package com.trucking.budget.financial_reporting.controller;

import com.trucking.budget.financial_reporting.model.FinancialReport;
import com.trucking.budget.financial_reporting.service.FinancialReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial-reports")
public class FinancialReportController {
    @Autowired
    private FinancialReportService financialReportService;

    @PostMapping
    public ResponseEntity<FinancialReport> createReport(@RequestBody FinancialReport financialReport) {
        FinancialReport createdReport = financialReportService.createReport(financialReport);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    @GetMapping
    public List<FinancialReport> getAllReports() {
        // Call the correct method
        return financialReportService.getAllReports(); // Ensure this matches the service method name
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialReport> getReportById(@PathVariable Long id) {
        FinancialReport report = financialReportService.getReportById(id);
        return report != null ? ResponseEntity.ok(report) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancialReport> updateReport(@PathVariable Long id, @RequestBody FinancialReport reportDetails) {
        FinancialReport updatedReport = financialReportService.updateReport(id, reportDetails);
        return updatedReport != null ? ResponseEntity.ok(updatedReport) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        financialReportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
