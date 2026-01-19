# Write your MySQL query statement below
-- SELECT visited_on  , SUM(amount) AS amount , AVG(amount) AS average_amount    
-- FROM Customer
-- WHERE ((SELECT MAX(visited_on) FROM Customer) - visited_on) <'7' 
-- GROUP BY visited_on 

-- SELECT * FROM Customer A , Customer B
-- WHERE DATEDIFF(A.visited_on , B.visited_on) <= 6;

-- SELECT A.visited_on , SUM(B.amount) , AVG(B.amount)  FROM Customer A
-- JOIN Customer B
-- ON (A.visited_on - B.visited_on )<'7'
-- GROUP BY A.visited_on

SELECT 
    B.visited_on,
    SUM(A.amount) AS amount,
    ROUND(SUM(A.amount) / 7, 2) AS average_amount
FROM Customer A
JOIN (
    SELECT DISTINCT visited_on
    FROM Customer
    WHERE DATEDIFF(
        visited_on,
        (SELECT MIN(visited_on) FROM Customer)
    ) >= 6
) B
ON DATEDIFF(B.visited_on, A.visited_on) BETWEEN 0 AND 6
GROUP BY B.visited_on
ORDER BY B.visited_on;

