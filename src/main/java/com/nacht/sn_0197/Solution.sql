select a.id
from weather a join weather b
on a.recordDate = date_add(b.recordDate, INTERVAL 1 DAY) where a.temperature > b.temperature