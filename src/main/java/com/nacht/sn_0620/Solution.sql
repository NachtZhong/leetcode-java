select * from cinema
where description != 'boring' and id & 1 = 1
order by rating desc