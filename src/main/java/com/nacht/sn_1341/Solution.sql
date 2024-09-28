select (
           select
               b.name
           from
               (
                   select
                       user_id, count(*) as cnt
                   from movierating
                   group by user_id
               ) a
                   join users b on a.user_id = b.user_id
           order by a.cnt desc, b.name asc limit 1
       ) results
union all
select (
           select
               d.title results
           from
               (
                   select movie_id, avg(rating) as rating from movierating
                   where created_at between '2020-02-01' and '2020-02-28'
                   group by movie_id
               ) c join movies d on c.movie_id = d.movie_id
           order by c.rating desc, d.title asc limit 1
       ) results
