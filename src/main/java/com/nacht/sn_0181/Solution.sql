select a.name as Employee
from employee a
where managerId is not null and salary > (
    select b.salary from employee b where b.id = a.managerId
)