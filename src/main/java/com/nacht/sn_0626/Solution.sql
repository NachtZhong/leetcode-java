select a.id, b.student
from
    seat a, seat b
where
    (a.id & 1 = 1 and a.id = b.id - 1) or
    (a.id & 1 = 0 and a.id = b.id + 1) or
    (a.id = (select max(id) from seat) and b.id = (select max(id) from seat) and a.id & 1 = 1)
order by id