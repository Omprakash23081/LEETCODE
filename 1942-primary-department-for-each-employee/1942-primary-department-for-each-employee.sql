SELECT e.employee_id, e.department_id
FROM Employee e
LEFT JOIN (
    SELECT employee_id
    FROM Employee
    WHERE primary_flag = 'Y'
    GROUP BY employee_id
) p
ON e.employee_id = p.employee_id
WHERE e.primary_flag = 'Y'
   OR (p.employee_id IS NULL AND e.employee_id IN (
        SELECT employee_id
        FROM Employee
        GROUP BY employee_id
        HAVING COUNT(*) = 1
   ));
