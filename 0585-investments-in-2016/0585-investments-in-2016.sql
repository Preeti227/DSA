SELECT 
    ROUND(SUM(tiv_2016),2) AS tiv_2016

FROM
(
    SELECT *,
        COUNT(*) OVER(PARTITION BY tiv_2015) AS tiv_count,
        COUNT(*) OVER(PARTITION BY lat, lon) AS loc_count
    FROM Insurance
) t

WHERE tiv_count > 1
AND loc_count = 1;