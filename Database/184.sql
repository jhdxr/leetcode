SELECT
	d. Name AS Department,
	e. Name AS Employee,
	e.Salary
FROM
	Employee AS e,
	Department AS d,
	(
		SELECT
			DepartmentId,
			max(Salary) AS Salary
		FROM
			Employee
		GROUP BY
			DepartmentId
	) tmp
WHERE
	e.Salary = tmp.Salary
AND e.DepartmentId = tmp.DepartmentId
AND d.id = e.DepartmentId