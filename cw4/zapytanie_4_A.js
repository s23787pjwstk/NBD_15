printjson(db.people.aggregate([
	{$project: {
		nationality: "$nationality",
		bmi: { $divide: [{$toDouble: "$weight"},{$pow: [{$divide: [{$toDouble: "$height"}, 100]}, 2]}
		]}
	}},
	{$group: {
		_id: "$nationality",
		min: {$min: "$bmi"},
        max: {$max: "$bmi"},
        avg: {$avg: "$bmi"}
	}}
]).toArray())