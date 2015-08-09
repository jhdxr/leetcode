SELECT
	a.Score,
	(
		SELECT
			count(DISTINCT Score)
		FROM
			Scores b
		WHERE
			b.Score > a.Score
	) + 1 as Rank
FROM
	Scores a
ORDER BY
	Score DESC