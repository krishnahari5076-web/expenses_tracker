package com.example.expensestracker.repository;

import com.example.expensestracker.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {

    List<Expenses> findByCategoryIgnoreCase(String category);
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expenses e " +
            "WHERE e.date BETWEEN :startDate AND :endDate")
    BigDecimal getMonthlyTotal(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expenses e " +
            "WHERE LOWER(e.category) = LOWER(:category) " +
            "AND e.date BETWEEN :startDate AND :endDate")
    BigDecimal getCategoryMonthlyTotal(
            @Param("category") String category,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );


}
