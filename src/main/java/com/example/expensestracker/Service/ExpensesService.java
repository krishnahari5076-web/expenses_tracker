package com.example.expensestracker.Service;

import com.example.expensestracker.entity.Expenses;
import com.example.expensestracker.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExpensesService {
    @Autowired
      ExpensesRepository expensesRepository;

    public Expenses addexpenses(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    public List<Expenses> getexpenses() {
        return expensesRepository.findAll();
    }

    public Expenses getExpenseById(Long id) {
        return expensesRepository.findById(id).get();
    }

    public Expenses updateExpense(Long id, Expenses expenses) {

            Expenses existingExpense = expensesRepository.findById(id).get();

            existingExpense.setTitle(expenses.getTitle());
            existingExpense.setAmount(expenses.getAmount());
            existingExpense.setCategory(expenses.getCategory());
            existingExpense.setDescription(expenses.getDescription());
            existingExpense.setDate(expenses.getDate());

            return expensesRepository.save(existingExpense);

    }

    public String deleteExpense(Long id) {
            expensesRepository.deleteById(id);
            return "Expense deleted successfully";
    }

    public List<Expenses> filterByCategory(String category) {
        return expensesRepository.findByCategoryIgnoreCase(category);
    }

    public BigDecimal getMonthlyTotal() {
        LocalDate today = LocalDate.now();

        LocalDate startDate = today.withDayOfMonth(1);

        return expensesRepository.getMonthlyTotal(startDate, today);
    }
    public BigDecimal getCategoryMonthlyTotal(String category) {

        LocalDate today = LocalDate.now();

        LocalDate startDate = today.withDayOfMonth(1);

        return expensesRepository.getCategoryMonthlyTotal(
                category,
                startDate,
                today
        );
    }
}
