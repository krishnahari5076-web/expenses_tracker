package com.example.expensestracker.Controller;

import aQute.bnd.annotation.headers.Resolution;
import com.example.expensestracker.Service.ExpensesService;
import com.example.expensestracker.entity.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

import static aQute.bnd.annotation.headers.Resolution.optional;

@RestController
public class ExpensesController {
    @Autowired
    ExpensesService expensesService;
    @PostMapping("/expenses")
    public Expenses addexpenses(@RequestBody Expenses expenses) {
        return expensesService.addexpenses(expenses);
    }
      @GetMapping("/expenses")
              public List<Expenses> getexpenses(){
          return expensesService.getexpenses();
        }
    @GetMapping("/expenses/{id}")
    public Expenses getExpenseById(@PathVariable Long id) {
        return expensesService.getExpenseById(id);
    }
    @PutMapping("/expenses/{id}")
    public Expenses updateExpense(@PathVariable Long id, @RequestBody Expenses expenses) {

        return expensesService.updateExpense(id, expenses);
    }
    @DeleteMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable Long id) {
        return expensesService.deleteExpense(id);
    }
    @GetMapping("/expenses/category")
    public List<Expenses> filterByCategory(@RequestParam String category) {
        return expensesService.filterByCategory(category);
    }
    @GetMapping("/expenses/monthly-total")
    public BigDecimal getMonthlyTotal() {
        return expensesService.getMonthlyTotal();
    }
    @GetMapping("/expenses/category/monthly-total")
    public BigDecimal getCategoryMonthlyTotal(
            @RequestParam String category) {

        return expensesService.getCategoryMonthlyTotal(category);
    }

    }

