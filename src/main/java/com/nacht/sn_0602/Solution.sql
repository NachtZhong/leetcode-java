select user_id id, sum(cnt) num
from
    (
        select requester_id user_id, count(*) cnt from RequestAccepted
        group by requester_id

        union all

        select accepter_id user_id, count(*) cnt from RequestAccepted
        group by accepter_id
    ) tmp
group by user_id
order by num desc limit 1
