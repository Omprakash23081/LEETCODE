# Write your MySQL query statement below
-- SELECT 
-- S.student_id , S.student_name , SB.subject_name , COUNT(E.subject_name)
-- FROM Students 
SELECT 
    St.student_id,
    St.student_name,
    Sb.subject_name,
    COUNT(E.student_id) AS attended_exams
FROM Students St
CROSS JOIN Subjects Sb
LEFT JOIN Examinations E
    ON St.student_id = E.student_id
    AND Sb.subject_name = E.subject_name
GROUP BY 
    St.student_id,
    St.student_name,
    Sb.subject_name
ORDER BY 
    St.student_id

