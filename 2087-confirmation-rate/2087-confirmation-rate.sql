SELECT
    S.user_id,
    COALESCE(ROUND(SUM(C.action = 'confirmed') / NULLIF(COUNT(C.action), 0), 2), 0) AS confirmation_rate
FROM Signups S
LEFT JOIN Confirmations C
    ON S.user_id = C.user_id
GROUP BY S.user_id;
