-- 注意：如果出现工资相同的，计算排名时应该只算作一名，而非多名。例如（8000, 7500, 7500, 6900；则6900仍应该被列出来，因为是第三名）
SELECT
	d. NAME AS Department,
	e1. NAME AS Employee,
	e1.Salary
FROM
	Employee e1,
	Department d
WHERE
	e1.DepartmentId = d.Id
AND (
	SELECT
		count(DISTINCT e2.Salary)
	FROM
		Employee e2
	WHERE
		e2.DepartmentId = e1.DepartmentId
	AND e2.Salary > e1.Salary
) < 3
ORDER BY
	e1.DepartmentId ASC,
	e1.Salary DESC
	
-- 如果工资相同的算作多名，可以考虑如下的sql
SELECT
	d. NAME AS Department,
	e. NAME AS Employee,
	e.Salary
FROM
	(
		SELECT
			SUBSTRING_INDEX(GROUP_CONCAT(Id ORDER BY Salary DESC), ',', 3) AS list
		FROM
			Employee
		GROUP BY
			DepartmentId
	) AS o,
	Employee AS e,
	Department AS d
WHERE
	e.DepartmentId = d.Id
AND FIND_IN_SET(e.Id, o.list)
ORDER BY
	d.Id ASC,
	e.Salary DESC