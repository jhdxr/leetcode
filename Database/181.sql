SELECT
	a.`Name`
FROM
	Employee a,
	Employee b
WHERE
	a.ManagerId IS NOT NULL
AND a.Salary > b.Salary
AND a.ManagerId = b.Id