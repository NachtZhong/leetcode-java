select a.product_name,
       b.unit
from products a
         join
     (
         select
             product_id,
             sum(unit) as unit
         from orders
         where order_date >= '2020-02-01' and order_date < '2020-03-01'
         group by product_id, date_format(order_date, '%Y-%m')
         having unit >= 100
     ) b
     on a.product_id = b.product_id