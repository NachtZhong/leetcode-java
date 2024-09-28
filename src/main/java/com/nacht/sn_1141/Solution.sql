select activity_date as day, count(distinct user_id) as active_users
from activity
where activity_date > date_add('2019-07-27', interval -30 day) and activity_date <= '2019-07-27'
group by activity_date