select contest_id, round((count(*) / (select count(1) from users)) * 100, 2) percentage
from register
group by contest_id
order by percentage desc, contest_id asc