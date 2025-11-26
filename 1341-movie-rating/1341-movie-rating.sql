-- # Write your MySQL query statement below



-- -- SELECT * FROM MovieRating M
-- -- JOIN Users U
-- -- ON M.user_id = U.user_id
-- -- JOIN Movies MO
-- -- ON M.movie_id = MO.movie_id
-- -- ORDER BY U.name ASC  , MO.title ASC


-- SELECT name AS results
-- FROM Users
-- WHERE user_id = 
-- (
--     SELECT user_id 
--     FROM MovieRating 
--     GROUP BY user_id
--     ORDER BY COUNT(user_id) DESC LIMIT 1
-- )

-- UNION 

-- SELECT title
-- FROM Movies
-- WHERE movie_id = 
-- (
--     SELECT movie_id 
--     FROM MovieRating 
--     GROUP BY movie_id
--     ORDER BY SUM(rating)/COUNT(movie_id) DESC LIMIT 1
-- )

(SELECT name AS results      
FROM Users
JOIN MovieRating
USING(user_id) 
GROUP BY user_id
ORDER BY COUNT(user_id) DESC , name
LIMIT 1 )

UNION ALL

(SELECT title FROM Movies
JOIN MovieRating
USING(movie_id) 
WHERE MONTH(created_at)=2 AND YEAR(created_at)=2020
GROUP BY movie_id
ORDER BY AVG(rating) DESC , title
LIMIT 1 )