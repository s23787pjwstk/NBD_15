printjson(db.people.aggregate({$unwind:'$credit'},{$match: {nationality: "Poland", sex: "Female"}},
{$group:{_id: "$credit.currency",
totalSum:{$sum:{$toDouble: "$credit.balance"}}, 
avgSalary: {$avg:{$toDouble: "$credit.balance"}}}}).toArray())