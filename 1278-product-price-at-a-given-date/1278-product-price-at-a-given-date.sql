# Write your MySQL query statement below
-- SELECT product_id , 
-- IFNULL(MAX(new_price ) , 10) AS price
-- FROM Products
-- WHERE (product_id , DATEDIFF("2019-08-16" , change_date)) IN 
-- (
--   SELECT product_id , MIN(DATEDIFF("2019-08-16" , change_date)) AS change_date 
--   FROM Products
--   WHERE DATEDIFF("2019-08-16" , change_date)>=0
--   GROUP BY product_id
-- ) 
-- GROUP BY product_id;

SELECT product_id , new_price AS price
FROM Products
WHERE (product_id , change_date) IN
(
    SELECT product_id , MAX(change_date) 
    FROM Products
    WHERE change_date <= "2019-08-16"
    GROUP BY product_id 
)
UNION
SELECT product_id , 
10 AS price
FROM Products
WHERE product_id NOT IN  
(
    SELECT product_id 
    FROM Products
    WHERE change_date <= "2019-08-16"
)


-- SELECT p.product_id,
--        COALESCE(pp.new_price, 10) AS price
-- FROM (SELECT DISTINCT product_id FROM Products) p
-- LEFT JOIN (
--     SELECT product_id, new_price
--     FROM Products
--     WHERE (product_id, change_date) IN (
--         SELECT product_id, MAX(change_date)
--         FROM Products
--         WHERE change_date <= '2019-08-16'
--         GROUP BY product_id
--     )
-- ) pp
-- ON p.product_id = pp.product_id;
