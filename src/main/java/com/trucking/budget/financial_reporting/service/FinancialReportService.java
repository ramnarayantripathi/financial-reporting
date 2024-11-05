////package com.trucking.budget.financial_reporting.service;
////
////
////import com.trucking.budget.financial_reporting.model.FinancialReport;
////import com.trucking.budget.financial_reporting.repository.FinancialReportRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.Optional;
////
////@Service
////public class FinancialReportService {
////
////    @Autowired
////    private FinancialReportRepository repository;
////
////    // Create a new financial report
////    public FinancialReport createReport(FinancialReport report) {
////        return repository.save(report);
////    }
////
////    // Update an existing financial report by ID
////    public FinancialReport updateReport(Long id, FinancialReport report) {
////        report.setId(id); // Ensure the report has the correct ID
////        return repository.save(report);
////    }
////
////    // Delete a financial report by ID
////    public void deleteReport(Long id) {
////        repository.deleteById(id);
////    }
////
////    // Get a financial report by ID
////    public FinancialReport getReportById(Long id) {
////        return repository.findById(id).orElse(null);
////    }
////
////    // Get all financial reports
////    public List<FinancialReport> getAllReports() {
////        return repository.findAll();
////    }
////}
//
//
//package com.trucking.budget.financial_reporting.service;
//
//import com.trucking.budget.financial_reporting.model.FinancialReport;
//import com.trucking.budget.financial_reporting.repository.FinancialReportRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class FinancialReportService {
//
//    @Autowired
//    private FinancialReportRepository financialReportRepository;
//
//    public FinancialReport createReport(FinancialReport report) {
//        return financialReportRepository.save(report);
//    }
//
//    public List<FinancialReport> findAllReports() {
//        return financialReportRepository.findAll();
//    }
//
//    public Optional<FinancialReport> findById(Long id) {
//        return financialReportRepository.findById(id);
//    }
//
//    public FinancialReport updateReport(Long id, FinancialReport reportDetails) {
//        FinancialReport report = financialReportRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));
//        report.setReportName(reportDetails.getReportName());
//        report.setAmount(reportDetails.getAmount());
//        report.setCurrency(reportDetails.getCurrency());
//        report.setDescription(reportDetails.getDescription());
//        return financialReportRepository.save(report);
//    }
//
//    public void deleteReport(Long id) {
//        FinancialReport report = financialReportRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));
//        financialReportRepository.delete(report);
//    }
//}


package com.trucking.budget.financial_reporting.service;

import com.trucking.budget.financial_reporting.model.FinancialReport;
import com.trucking.budget.financial_reporting.repository.FinancialReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialReportService {
    @Autowired
    private FinancialReportRepository financialReportRepository;

    public FinancialReport createReport(FinancialReport report) {
        return financialReportRepository.save(report);
    }

    public List<FinancialReport> getAllReports() {
        return financialReportRepository.findAll();
    }

    public FinancialReport getReportById(Long id) {
        return financialReportRepository.findById(id).orElse(null);
    }

    public FinancialReport updateReport(Long id, FinancialReport reportDetails) {
        FinancialReport report = financialReportRepository.findById(id).orElse(null);
        if (report != null) {
            report.setReportName(reportDetails.getReportName());
            report.setAmount(reportDetails.getAmount());
            report.setCurrency(reportDetails.getCurrency());
            report.setDescription(reportDetails.getDescription());
            return financialReportRepository.save(report);
        }
        return null;
    }

    public void deleteReport(Long id) {
        financialReportRepository.deleteById(id);
    }
}
