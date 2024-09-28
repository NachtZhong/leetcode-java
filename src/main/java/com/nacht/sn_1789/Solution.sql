select
    employee_id,
    if(count(*) = 1, department_id, max(case primary_flag when 'Y' then department_id end)) as department_id
from employee
group by employee_id
