select customer_id
from
    (
        select a.customer_id, count(distinct product_key) as buy_count, b.all_count
        from
            customer a, (
            select count(product_key) as all_count from product
        ) b
        group by a.customer_id

    ) tmp where buy_count = all_count