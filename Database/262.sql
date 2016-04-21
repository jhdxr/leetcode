SELECT
	Request_at AS `Day`,
	ROUND(
		IFNULL(cancel_count.c, 0) / all_count.c,
		2
	) AS `Cancellation Rate`
FROM
	(
		SELECT
			Request_at,
			COUNT(*) AS c
		FROM
			Trips
		WHERE
			Client_Id IN (
				SELECT
					Users_Id
				FROM
					Users
				WHERE
					Banned = 'No'
				AND Role = 'client'
			)
		GROUP BY
			Request_at
	) AS all_count
LEFT JOIN (
	SELECT
		Request_at,
		COUNT(*) AS c
	FROM
		Trips
	WHERE
		(
			`Status` = 'cancelled_by_client'
			OR `Status` = 'cancelled_by_driver'
		)
	AND Client_Id IN (
		SELECT
			Users_Id
		FROM
			Users
		WHERE
			Banned = 'No'
		AND Role = 'client'
	)
	GROUP BY
		Request_at
) AS cancel_count USING (Request_at)
WHERE
	Request_at BETWEEN '2013-10-01'
AND '2013-10-03'
GROUP BY
	Request_at