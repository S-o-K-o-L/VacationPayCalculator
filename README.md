# Калькулятор для расчета отпускных

Endpoint:
- GET http://localhost:8080/calculate

Поддерживает три типа запроса:
1. Расчет отпускных с количеством дней отпуска

   GET http://localhost:8080/calculate?averageSalary=3000&vacationDays=10
2. Расчет отпускных с датой начала и количеством дней отпуска

   GET http://localhost:8080/calculate?averageSalary=600000&vacationDays=25&startDate=2023-01-01
3. Расчет отпускных с датой начала и конца отпуска

   GET http://localhost:8080/calculate?averageSalary=600000&vacationDays=10&startDate=2023-01-01&endDate=2023-01-25
