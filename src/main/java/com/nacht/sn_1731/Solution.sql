select a.employee_id, a.name, b.reports_count, b.average_age
from employees a
         join (select reports_to as employee_id, count(*) as reports_count, round(avg(age)) as average_age
               from employees
               where reports_to is not null
               group by reports_to) b on a.employee_id = b.employee_id
order by a.employee_id