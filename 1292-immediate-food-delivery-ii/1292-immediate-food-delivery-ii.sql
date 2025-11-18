# Write your MySQL query statement below
-- SELECT ROUND(
--     SUM(
--         IF(DATEDIFF(customer_pref_delivery_date , order_date)=0 , 1, 0)
--     )/COUNT(customer_id)*100,2)
-- AS immediate_percentage
-- FROM Delivery
-- GROUP BY customer_id;

-- SELECT ROUND(
--     COUNT(
--         DATEDIFF(customer_pref_delivery_date , order_date)=0
--     )/COUNT(customer_id)*100,2)
-- AS immediate_percentage
-- FROM Delivery
-- GROUP BY customer_id;


SELECT
    ROUND(
        (SUM(order_date = customer_pref_delivery_date) / COUNT(*))*100,
        2
    ) AS immediate_percentage
FROM Delivery
WHERE (customer_id , order_date) IN 
(SELECT customer_id , MIN(order_date) FROM Delivery GROUP BY customer_id);
