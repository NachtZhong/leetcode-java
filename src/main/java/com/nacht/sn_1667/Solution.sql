select user_id,
       concat(upper(SUBSTRING(name, 1, 1)), lower(SUBSTRING(name, 2))) name
from users
order by user_id