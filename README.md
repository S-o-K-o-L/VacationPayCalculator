# Калькулятор для расчета отпускных

Endpoint:
- GET http://localhost:8080/calculate

Поддерживает три типа запроса:
1. Расчет отпускных с количеством дней отпуска

   GET http://localhost:8080/calculate?averageSalary=100000&vacationDays=10
   
Ответ 2844.10

2. Расчет отпускных с датой начала и количеством дней отпуска

   GET http://localhost:8080/calculate?averageSalary=100000&vacationDays=10&startDate=2024-01-01
   
Ответ 568.82

3. Расчет отпускных с датой начала и конца отпуска

   GET http://localhost:8080/calculate?averageSalary=600000&vacationDays=10&startDate=2024-01-01&endDate=2024-01-11
   
Ответ 568.82
