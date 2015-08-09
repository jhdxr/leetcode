delete from Person where Id in(select * from(
	select p.Id from Person p, Person q where p.Email=q.Email and p.Id>q.Id
) as x)