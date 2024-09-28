select
    d.name Department,
    e.name Employee,
    e.salary Salary
from
    department d
        join
    (
        select name, salary, departmentid
        from employee
        where (departmentid, salary) in
              (
                  select a.departmentid, a.salary
                  from employee a
                  where (
                            select count(distinct salary) from employee b
                            where b.departmentid = a.departmentid and b.salary > a.salary
                        ) < 3
              )
    ) e on d.id = e.departmentid
