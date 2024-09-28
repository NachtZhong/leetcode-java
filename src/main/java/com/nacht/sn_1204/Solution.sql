select person_name
from queue a
where (
          select sum(weight) from queue b where turn <= a.turn
      ) <= 1000 order by turn desc limit 1