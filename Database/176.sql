SELECT
	IF (
		(SELECT count(DISTINCT Salary) FROM Employee) >= 2,
		(
			SELECT
				Salary
			FROM
				Employee
			ORDER BY
				Salary DESC
			LIMIT 1,
			1
		),
		NULL
	)