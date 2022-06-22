##Принцип единственной ответственности

Принцип единственной ответственности гласит, что модуль должен отвечать только за одного актора. 
Под актором понимаем группу состоящую из одного или нескольких лиц.

Рассмотрим пример:

```mermaid
classDiagram
class Employee {
  calculatePay()
  reportHours()
  save()
}
```
Здесь нарушается принцип, потому что за три эти метода отвечают три разных актора. Как следствие доработка одного метода,
может повлечь неожиданные изменения в других, или также их доработку.

Для решения данной проблемы необходимо вынесение функций в разные классы, либо фактически, либо с ипользованием фасада

```mermaid
classDiagram
PayCalculator-->EmployeeData
PayCalculator : calculatePay()
HourReporter-->EmployeeData
HourReporter : reportHours()
EmployeeSaver-->EmployeeData
EmployeeSaver : saveEmployee()
```

Пример с фасадом:

```mermaid
classDiagram
EmployeeFacade-->PayCalculator
EmployeeFacade-->HourReporter
EmployeeFacade-->EmployeeSaver
EmployeeFacade : calculatePay()
EmployeeFacade : reportHours()
EmployeeFacade : save()
PayCalculator-->EmployeeData
PayCalculator : calculatePay()
HourReporter-->EmployeeData
HourReporter : reportHours()
EmployeeSaver-->EmployeeData
EmployeeSaver : saveEmployee()
```