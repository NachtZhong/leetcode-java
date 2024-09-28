select round((
                 select
                     count(distinct a.player_id)
                 from activity a, activity b
                 where a.event_date = date_add(b.event_date, interval 1 day) and a.player_id = b.player_id and (b.player_id, b.event_date) in
                                                                                                               (select player_id, min(event_date) from activity group by player_id)
             ) / (select count(distinct player_id) from activity
             ), 2) fraction