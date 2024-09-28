SELECT
    visited_on,
    (SELECT SUM(amount)
     FROM customer
     WHERE visited_on BETWEEN DATE_ADD(c.visited_on, INTERVAL -6 DAY) AND c.visited_on) AS amount,
    ROUND((SELECT SUM(amount) / 7
           FROM customer
           WHERE visited_on BETWEEN DATE_ADD(c.visited_on, INTERVAL -6 DAY) AND c.visited_on), 2) AS average_amount
FROM
    customer c
WHERE
    (SELECT COUNT(distinct visited_on)
     FROM customer
     WHERE visited_on BETWEEN DATE_ADD(c.visited_on, INTERVAL -6 DAY) AND c.visited_on) = 7
GROUP BY visited_on