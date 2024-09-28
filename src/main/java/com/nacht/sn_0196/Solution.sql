DELETE p1
FROM person p1
         JOIN (
    SELECT MIN(id) AS min_id, email
    FROM person
    GROUP BY email
) p2 ON p1.email = p2.email AND p1.id > p2.min_id;