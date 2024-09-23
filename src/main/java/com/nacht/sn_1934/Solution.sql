select a.user_id, case when tmp.confirmation_rate is null then 0 else tmp.confirmation_rate end confirmation_rate
from signups a left join
     (
         select user_id,
                round(sum(case when action = 'confirmed' then 1 else 0 end) /
                      count(*), 2) as confirmation_rate
         from confirmations
         group by user_id

     ) as tmp on a.user_id = tmp.user_id
