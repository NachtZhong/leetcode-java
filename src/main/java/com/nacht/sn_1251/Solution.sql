select a.product_id,
       ifnull(round(sum(a.price * b.units) / sum(b.units), 2), 0) as average_price
from prices a
         left join unitssold b
                   on a.product_id = b.product_id
where a.start_date <= b.purchase_date and a.end_date >= purchase_date or b.purchase_date is null
group by a.product_id