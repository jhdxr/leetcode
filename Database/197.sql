SELECT a.Id FROM 
    Weather a, Weather b
WHERE
    a.Temperature > b.Temperature
    AND b.Date = subdate(a.Date, 1) 