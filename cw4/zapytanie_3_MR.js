db.people.mapReduce(
    function()
	{emit(this.job, "");},
    function(key,values)
		{return values[0]},
    {
            out:"jobs"
    }
)
printjson(db.jobs.find({}).toArray())